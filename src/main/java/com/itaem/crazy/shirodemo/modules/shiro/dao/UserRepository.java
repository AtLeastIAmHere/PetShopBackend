package com.itaem.crazy.shirodemo.modules.shiro.dao;


import com.itaem.crazy.shirodemo.modules.shiro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    User findByUserId(Integer userId);

    User findByAccount(String account);
}
