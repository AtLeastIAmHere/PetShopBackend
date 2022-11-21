package com.itaem.crazy.petshopdemo.modules.petshop.dao;

import com.itaem.crazy.petshopdemo.modules.petshop.entity.User;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.UserOrder;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserOrderRepository extends JpaRepository<UserOrder, Integer> {
    List<UserOrder> findAllByUserIdAndOrderState(Integer userId, Integer state);

    List<UserOrder> findAllByUserId(Integer userOrderId);

    UserOrder findByUserOrderId(Integer userOrderId);
}
