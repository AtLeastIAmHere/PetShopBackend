package com.itaem.crazy.petshopdemo.modules.petshop.controller;

import com.itaem.crazy.petshopdemo.modules.petshop.entity.User;
import com.itaem.crazy.petshopdemo.modules.petshop.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "Shiro权限管理")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 获取所有用户
    @ApiOperation(value = "查询所有用户", notes = "无参数")
    @PostMapping("/owner/getAllUser")
    public Map<String, Object> getAllUser(){
        Map<String, Object> result = new HashMap<>();

        List<User> userList = userService.getAllUsers();

        result.put("status", 200);
        result.put("msg", "获取成功");
        result.put("result", userList);

        return result;
    }
}
