package com.itaem.crazy.petshopdemo.modules.petshop.dao;

import com.itaem.crazy.petshopdemo.modules.petshop.entity.UserOrderGoods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserOrderGoodsRepository extends JpaRepository<UserOrderGoods, Integer> {
    List<UserOrderGoods> findAllByUserOrderId(Integer userOrderId);
}
