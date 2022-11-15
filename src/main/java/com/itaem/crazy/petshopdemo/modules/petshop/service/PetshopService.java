package com.itaem.crazy.petshopdemo.modules.petshop.service;

import com.itaem.crazy.petshopdemo.modules.petshop.entity.Operator;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.Supplier;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.User;

/**
 * @Author 大誌
 * @Date 2019/3/30 22:18
 * @Version 1.0
 */
public interface PetshopService {
     /**
      * Find user by username
      * @param account
      * @return
      */
     User findByUserAccount(String account);

     /**
      * Find operator by username
      * @param account
      * @return
      */
     Operator findByOperatorAccount(String account);

     /**
      * Find supplier by username
      * @param account
      * @return
      */
     Supplier findBySupplierAccount(String account);

     /**
      * Add user by User(account, username, password)
      * @param user
      * @return
      */
     void addUser(User user);
}
