package com.itaem.crazy.petshopdemo.modules.petshop.service;

import com.itaem.crazy.petshopdemo.modules.petshop.entity.User;

import java.util.List;

public interface UserService {

    // 获取所有用户
    List<User> getAllUsers();

    // 添加新用户
    void addUser(User user);

    // 根据username删除用户
    void deleteById(Integer Id);

}
