package com.itaem.crazy.petshopdemo.modules.petshop.controller.frontweb;


import com.itaem.crazy.petshopdemo.modules.petshop.dto.LoginDTO;
import com.itaem.crazy.petshopdemo.modules.petshop.dto.dto.UserDTO;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.User;
import com.itaem.crazy.petshopdemo.modules.petshop.service.ShiroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;



@Api(tags = "petShop权限管理")
@RestController
public class ShiroController {

    private final ShiroService shiroService;

    public ShiroController(ShiroService shiroService) {
        this.shiroService = shiroService;
    }


    /**
     * 登录
     */
    @ApiOperation(value = "登陆", notes = "参数:用户名 密码")
    @PostMapping("/front/login")
    public Map<String, Object> login(@RequestBody @Validated LoginDTO loginDTO, BindingResult bindingResult) {
        Map<String, Object> result = new HashMap<>();
        if (bindingResult.hasErrors()) {
            result.put("code", 400);
            result.put("msg", bindingResult.getFieldError().getDefaultMessage());
            return result;
        }

        String account = loginDTO.getAccount();
//        String username = loginDTO.getAccount();
        String password = loginDTO.getPassword();

        //用户信息
        User user = shiroService.findByAccount(account);
        //账号不存在、密码错误
        if (user == null || !user.getPassword().equals(password)) {
            result.put("code", 400);
            result.put("msg", "账号或密码有误");
        } else {
            //生成token，并保存到数据库
            Map<String,Object> tokenList = shiroService.createToken(user.getUserId());
            result.put("code", 200);
            result.put("msg", "登陆成功");
            Map<String,Object> data = new HashMap<>();
            data.put("id",user.getUserId());
            data.put("account",user.getAccount());
            data.put("nickname",user.getUsername());
            data.put("mail",user.getEMail());
            data.put("mobile",user.getPhone());
            data.put("address",user.getAddress());
            data.put("avatar","http://yjy-xiaotuxian-dev.oss-cn-beijing.aliyuncs.com/picture/2021-04-06/db628d42-88a7-46e7-abb8-659448c33081.png");
            data.put("creditCard",user.getCreditCard());
            data.put("token",tokenList.get("token"));
            result.put("result",data);
        }
        return result;
    }

    /**
     * 注册
     */
    @ApiOperation(value = "注册",notes = "参数:用户名 密码")
    @PostMapping("/front/register")
    public Map<String, Object> register(@RequestBody @Validated LoginDTO loginDTO, BindingResult bindingResult){
        boolean type = false;
        Map<String, Object> result = new HashMap<>();
        if (bindingResult.hasErrors()) {
            result.put("status", 400);
            result.put("msg", bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        String account = loginDTO.getAccount();
        String password = loginDTO.getPassword();

        try{
            type = shiroService.RegisterUser(account,password);
        }
        catch (Exception e){
            result.put("code",500);
            result.put("msg","注册失败");
        }
        finally {
            if(type){
                result.put("code",200);
                result.put("msg","注册成功");
            }
            else{
                result.put("code",501);
                result.put("msg","用户名已存在");
            }
        }
        return  result;
    }

    /**
     * 修改个人信息
     */
    @ApiOperation(value = "个人信息修改",notes="参数:user")
    @PostMapping("/front/modify")
    public Map<String,Object> ModifyUser(@RequestBody @Validated UserDTO userDTO, BindingResult bindingResult){
        Map<String, Object> result = new HashMap<>();
        if (bindingResult.hasErrors()) {
            result.put("code", 400);
            result.put("msg", bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        boolean type = false;
        try{
            type = shiroService.ModifyUser(userDTO);
        }
        catch (Exception e){
            result.put("code",400);
            result.put("msg",e.getMessage());
        }finally {
            if(type){
                result.put("code",200);
                result.put("msg","修改成功");
            }
            else{
                result.put("code",400);
                result.put("msg","修改失败");
            }
        }
        return result;
    }

    /**
     * 退出
     */
    @ApiOperation(value = "登出", notes = "参数:token")
    @PostMapping("/sys/logout")
    public Map<String, Object> logout(@RequestHeader("token")String token) {
        Map<String, Object> result = new HashMap<>();
        shiroService.logout(token);
        result.put("code", 200);
        result.put("msg", "您已安全退出系统");
        return result;
    }
}


