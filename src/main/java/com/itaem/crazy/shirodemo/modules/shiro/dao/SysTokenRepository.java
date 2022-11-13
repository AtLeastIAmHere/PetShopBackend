package com.itaem.crazy.shirodemo.modules.shiro.dao;

import com.itaem.crazy.shirodemo.modules.shiro.entity.SysToken;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SysTokenRepository extends JpaRepository<SysToken, Integer> {

    SysToken findByToken(String token);

    SysToken findByUserId(Integer userId);
}
