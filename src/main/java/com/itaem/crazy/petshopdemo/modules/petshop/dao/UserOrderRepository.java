package com.itaem.crazy.petshopdemo.modules.petshop.dao;

import com.itaem.crazy.petshopdemo.modules.petshop.entity.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserOrderRepository extends JpaRepository<UserOrder, Integer> {
    UserOrder findByOrderId(Integer orderId);

    List<UserOrder> findByUserId(Integer userId);

    List<UserOrder> findByUserName(String userName);
}
