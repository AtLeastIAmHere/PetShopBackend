package com.itaem.crazy.shirodemo.modules.shiro.service;


import com.itaem.crazy.shirodemo.modules.shiro.entity.SysToken;
import com.itaem.crazy.shirodemo.modules.shiro.entity.User;

import java.util.Map;


public interface ShiroService {
     /**
      * Find User by username
      * @param username
      * @return
      */
     User findByUsername(String username);

     /**
      * create token by userId
      * @param userId
      * @return
      */
     Map<String,Object> createToken(Integer userId);

     /**
      * logout
      * @param token
      */
     void logout(String token);

     /**
      * find token by token
      * @param accessToken
      * @return
      */
     SysToken findByToken(String accessToken);

     /**
      * find User by userId
      * @param userId
      * @return
      */
     User findByUserId(Integer userId);
}
