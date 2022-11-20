package com.itaem.crazy.petshopdemo.modules.petshop.service;

import com.itaem.crazy.petshopdemo.modules.petshop.entity.User;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.UserOrder;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.UserOrderGoods;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.frontweb.Good;

import java.util.List;

public interface UserService {
    /**
     * find all user order by userId and order state
     * @param userId
     * @param state
     * @return
     */
    List<UserOrder> findUserOrderByUserIdAndState(Integer userId, Integer state);

    /**
     * find all order_goods data by userOrderId
     * @param userOrderId
     * @return
     */
    List<UserOrderGoods> getAllOrderGoods(Integer userOrderId);

    /**
     *
     * @param goodId
     * @return
     */
    Good getGoodById(Integer goodId);

    /**
     * add UserOrder
     * @param userOrder
     */
    void saveUserOrder(UserOrder userOrder);

    /**
     * add UserOrderGoods
     * @param userOrderGoods
     */
    void saveUserOrderGoods(UserOrderGoods userOrderGoods);

    /**
     * find user by user id
     * @param userId
     * @return
     */
    User getUserById(Integer userId);

    /**
     * find all UserOrder by userId
     * @param userId
     * @return
     */
    List<UserOrder> findUserOrderByUserId(Integer userId);
}
