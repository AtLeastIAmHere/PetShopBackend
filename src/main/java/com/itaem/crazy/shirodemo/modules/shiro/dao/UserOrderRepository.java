package com.itaem.crazy.shirodemo.modules.shiro.dao;

import com.itaem.crazy.shirodemo.modules.shiro.entity.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UserOrderRepository extends JpaRepository<UserOrder, Integer> {
    UserOrder findByOrderID(Integer orderId);

    Set<UserOrder> findByUserId(Integer userId);

    Set<UserOrder> findByUserName(String userName);
}
