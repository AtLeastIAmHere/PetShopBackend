package com.itaem.crazy.petshopdemo.modules.petshop.service.impl;

import com.itaem.crazy.petshopdemo.modules.petshop.dao.UserRepository;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.User;
import com.itaem.crazy.petshopdemo.modules.petshop.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){ this.userRepository = userRepository; }

    // 获取所有用户
    @Override
    public List<User> getAllUsers(){
//        List<User> userList = null;
//        userList = userRepository.findAll();
        return userRepository.findAll();
    }

    // 添加新用户
    @Override
    public void addUser(User user){
        userRepository.save(user);
    }

    // 根据username删除用户
    @Override
    public void deleteById(Integer Id){
        userRepository.deleteById(Id);
    }

}
