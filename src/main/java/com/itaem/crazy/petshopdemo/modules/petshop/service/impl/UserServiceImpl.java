package com.itaem.crazy.petshopdemo.modules.petshop.service.impl;

import com.itaem.crazy.petshopdemo.modules.petshop.dao.UserOrderGoodsRepository;
import com.itaem.crazy.petshopdemo.modules.petshop.dao.UserOrderRepository;
import com.itaem.crazy.petshopdemo.modules.petshop.dao.UserRepository;
import com.itaem.crazy.petshopdemo.modules.petshop.dao.frontweb.GoodRepository;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.User;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.UserOrder;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.UserOrderGoods;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.frontweb.Good;
import com.itaem.crazy.petshopdemo.modules.petshop.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserOrderRepository userOrderRepository;
    private final UserOrderGoodsRepository userOrderGoodsRepository;
    private final GoodRepository goodRepository;
    private final UserRepository userRepository;

    UserServiceImpl(UserOrderRepository userOrderRepository,
                    UserOrderGoodsRepository userOrderGoodsRepository,
                    GoodRepository goodRepository,
                    UserRepository userRepository){
        this.userOrderRepository = userOrderRepository;
        this.userOrderGoodsRepository = userOrderGoodsRepository;
        this.goodRepository = goodRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<UserOrder> findUserOrderByUserIdAndState(Integer userId, Integer state) {
        return userOrderRepository.findAllByUserIdAndOrderState(userId, state);
    }

    @Override
    public List<UserOrderGoods> getAllOrderGoods(Integer userOrderId) {
        return userOrderGoodsRepository.findAllByUserOrderId(userOrderId);
    }

    @Override
    public Good getGoodById(Integer goodId) {
        return goodRepository.findGoodsByIdIs(goodId);
    }

    @Override
    public void saveUserOrder(UserOrder userOrder) {
        userOrderRepository.save(userOrder);
    }

    @Override
    public void saveUserOrderGoods(UserOrderGoods userOrderGoods) {
        userOrderGoodsRepository.save(userOrderGoods);
    }

    @Override
    public User getUserById(Integer userId) {
        return userRepository.findByUserId(userId);
    }

    @Override
    public List<UserOrder> findUserOrderByUserId(Integer userId) {
        return userOrderRepository.findAllByUserOrderId(userId);
    }


}
