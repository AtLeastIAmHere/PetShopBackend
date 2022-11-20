package com.itaem.crazy.petshopdemo.modules.petshop.service.impl;


import com.itaem.crazy.petshopdemo.modules.petshop.config.TokenGenerator;
import com.itaem.crazy.petshopdemo.modules.petshop.service.ShiroService;
import com.itaem.crazy.petshopdemo.modules.petshop.dao.UserRepository;
import com.itaem.crazy.petshopdemo.modules.petshop.dao.frontweb.SysTokenRepository;
import com.itaem.crazy.petshopdemo.modules.petshop.dto.dto.UserDTO;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.User;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.frontweb.SysToken;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 大誌
 * @Date 2019/3/30 22:18
 * @Version 1.0
 */
@Service
public class ShiroServiceImpl implements ShiroService {
    //12小时后失效
    private final static int EXPIRE = 12;


    private final UserRepository userRepository;
    private final SysTokenRepository sysTokenRepository;

    public ShiroServiceImpl(UserRepository userRepository, SysTokenRepository sysTokenRepository) {
        this.userRepository = userRepository;
        this.sysTokenRepository = sysTokenRepository;
    }

    /**
     * 根据username查找用户
     *
     * @param username
     * @return User
     */
    @Override
    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return user;
    }

    @Override
    public User findByAccount(String account){
        User user = userRepository.findByAccount(account);
        return user;
    }

    @Override
    public boolean RegisterUser(String account, String password) {
        if(userRepository.findByAccount(account) == null){

            User user = new User();
            Integer userId = userRepository.findAll().size() + 1;
            user.setUserId(userId);
            user.setAccount(account);
            user.setPassword(password);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean ModifyUser(UserDTO userDTO) {
        String token = userDTO.getToken();
        SysToken sysToken = sysTokenRepository.findByToken(token);
        if(sysToken == null)
            return false;
        User user = userRepository.findByUserId(sysToken.getUserId());
        if(user == null)return false;
        user.setAddress(userDTO.getAddress());
        user.setUsername(userDTO.getNickname());
        user.setEMail(userDTO.getMail());
        user.setPhone(userDTO.getMobile());
        user.setCreditCard(userDTO.getCreditCard());
        userRepository.save(user);
        return true;
    }


    @Override
    /**
     * 生成一个token
     *@param  [userId]
     *@return Result
     */
    public Map<String, Object> createToken(Integer userId) {
        Map<String, Object> result = new HashMap<>();
        //生成一个token
        String token = TokenGenerator.generateValue();
        //当前时间
        LocalDateTime now = LocalDateTime.now();
        //过期时间
        LocalDateTime expireTime = now.plusHours(EXPIRE);
        //判断是否生成过token
        SysToken tokenEntity = sysTokenRepository.findByUserId(userId);
        if (tokenEntity == null) {
            tokenEntity = new SysToken();
            tokenEntity.setUserId(userId);
            //保存token
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);
        } else {
            //更新token
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);
        }
        sysTokenRepository.save(tokenEntity);
        result.put("token", token);
        result.put("expire", expireTime);
        return result;
    }

    /**
     * 更新数据库的token，使前端拥有的token失效
     * 防止黑客利用token搞事情
     *
     * @param token
     */
    @Override
    public void logout(String token) {
        SysToken byToken = findByToken(token);
        //生成一个token
        token = TokenGenerator.generateValue();
        //修改token
        byToken.setToken(token);
        //使前端获取到的token失效
        sysTokenRepository.save(byToken);
    }

    @Override
    public SysToken findByToken(String accessToken) {
        return sysTokenRepository.findByToken(accessToken);

    }

    @Override
    public User findByUserId(Integer userId) {
        return userRepository.findByUserId(userId);
    }
}
