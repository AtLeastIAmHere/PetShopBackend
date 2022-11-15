package com.itaem.crazy.petshopdemo.modules.petshop.dao;


import com.itaem.crazy.petshopdemo.modules.petshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
    // 通过username查找用户
    User findByUsername(String username);

    // 通过Id查找用户
    User findByUserId(Integer userId);

    // 通过account查找用户
    User findByAccount(String account);

    // 获取所有用户列表，方法自带
    // List<User> findAll();

    // 根据username删除用户，方法自带
    // deleteById(Integer Id);

}
