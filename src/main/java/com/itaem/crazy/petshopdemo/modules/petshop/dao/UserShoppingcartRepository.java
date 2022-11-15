package com.itaem.crazy.petshopdemo.modules.petshop.dao;

import com.itaem.crazy.petshopdemo.modules.petshop.entity.UserShoppingcart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserShoppingcartRepository extends JpaRepository<UserShoppingcart, Object> {
    UserShoppingcartRepository findByUserShoppingcartId(Integer userShoppingcart);
}