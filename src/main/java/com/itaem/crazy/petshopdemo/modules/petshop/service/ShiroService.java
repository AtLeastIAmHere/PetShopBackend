package com.itaem.crazy.petshopdemo.modules.petshop.service;


import com.itaem.crazy.petshopdemo.modules.petshop.dto.dto.UserDTO;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.User;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.frontweb.SysToken;

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

     User findByAccount(String account);

     boolean RegisterUser(String account,String password);

     boolean ModifyUser(UserDTO userDTO);
}
