package com.itaem.crazy.petshopdemo.modules.petshop.controller;


import com.itaem.crazy.petshopdemo.modules.petshop.dto.LoginDTO;
import com.itaem.crazy.petshopdemo.modules.petshop.dto.RegisterDTO;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.Operator;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.Supplier;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.User;
import com.itaem.crazy.petshopdemo.modules.petshop.service.PetshopService;
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


@Api(tags = "Shiro权限管理")
@RestController
public class PetshopController {

    private final PetshopService petshopService;

    public PetshopController(PetshopService petshopService) { this.petshopService = petshopService; }


    /**
     * 登录
     */
    @ApiOperation(value = "登陆", notes = "参数:账号 密码 账户类型")
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody @Validated LoginDTO loginDTO, BindingResult bindingResult) {
        Map<String, Object> result = new HashMap<>();
        if (bindingResult.hasErrors()) {
            result.put("status", 400);
            result.put("msg", bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        String type = loginDTO.getType();
        String account = loginDTO.getAccount();
        String password = loginDTO.getPassword();

        if(type.equals("1")){
            //用户信息
            User user = petshopService.findByUserAccount(account);
            //账号不存在、密码错误
            if (user == null || !user.getPassword().equals(password)) {
                result.put("status", 400);
                result.put("msg", "账号或密码有误");
            } else {
                result.put("token", "123456");
                result.put("status", 200);
                result.put("msg", "登陆成功");
                result.put("account type", "USER");
                result.put("result",user);
            }
        }
        else if(type.equals("2")){
            // 商店方
            Operator operator = petshopService.findByOperatorAccount(account);
            if(operator == null || !operator.getPassword().equals(password)){
                result.put("status", 400);
                result.put("msg", "账号或密码有误");
            }
            else{
                result.put("token", "123456");
                result.put("status", 200);
                result.put("msg", "登陆成功");
                result.put("account type", "Operator");
                result.put("result", operator);
            }
        }
        else if(type.equals("3")){
            // 供应商
            Supplier supplier = petshopService.findBySupplierAccount(account);
            if(supplier == null || !supplier.getPassword().equals(password)){
                result.put("status", 400);
                result.put("msg", "账号或密码有误");
            }
            else{
                result.put("token", "123456");
                result.put("status", 200);
                result.put("msg", "登陆成功");
                result.put("account type", "SUPPLIER");
                result.put("result", supplier);
            }
        }
        else{
            // 错误类型
            result.put("status", 400);
            result.put("msg", "未知错误，请联系管理员！");
        }
        return result;
    }


    /**
     * 用户注册
     */
    @ApiOperation(value = "用户注册", notes = "参数:账号 用户名 密码")
    @PostMapping("/user/register")
    public Map<String, Object> register(@RequestBody @Validated RegisterDTO registerDTO, BindingResult bindingResult){
        Map<String, Object> result = new HashMap<>();
        if (bindingResult.hasErrors()) {
            result.put("status", 400);
            result.put("msg", bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        String account = registerDTO.getAccount();
        String username = registerDTO.getUsername();
        String password = registerDTO.getPassword();

        // 查找用户是否存在
        User user = petshopService.findByUserAccount(account);
        if(user == null){
            // 用户表中没有该username，可以进行注册
            User userNew = new User();
            userNew.setAccount(account);
            userNew.setUsername(username);
            userNew.setPassword(password);

            petshopService.addUser(user);
            result.put("status", 200);
            result.put("msg", "注册成功，请登录");

//            if(petshopService.addUser(userNew) != null){
//                result.put("status", 200);
//                result.put("msg", "注册成功，请登录");
//            }
        }
        else{
            // 用户表已存在该username，不能进行注册
            result.put("status", 400);
            result.put("msg", "注册失败，该账号已存在");
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
//        shiroService.logout(token);
        result.put("status", 200);
        result.put("msg", "您已安全退出系统");
        return result;
    }

}


