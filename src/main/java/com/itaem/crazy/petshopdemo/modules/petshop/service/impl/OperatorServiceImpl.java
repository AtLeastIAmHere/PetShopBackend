package com.itaem.crazy.petshopdemo.modules.petshop.service.impl;

import com.itaem.crazy.petshopdemo.modules.petshop.dao.*;
import com.itaem.crazy.petshopdemo.modules.petshop.dao.frontweb.SysTokenRepository;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.*;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.frontweb.SysToken;
import com.itaem.crazy.petshopdemo.modules.petshop.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class OperatorServiceImpl implements OperatorService{

    private final OperatorRepository operatorRepository;
    private final OperatorPetOrderSalesRepository operatorPetOrderSalesRepository;
    private final OperatorProductsOrderSalesRepository operatorProductsOrderSalesRepository;
    private final UserOrderRepository userOrderRepository;
    private final UserRepository userRepository;
    private final SysTokenRepository sysTokenRepository;

    @Autowired
    OperatorServiceImpl(OperatorRepository operatorRepository,
                        OperatorPetOrderSalesRepository operatorPetOrderSalesRepository,
                        OperatorProductsOrderSalesRepository operatorProductsOrderSalesRepository,
                        UserOrderRepository userOrderRepository,
                        UserRepository userRepository,
                        SysTokenRepository sysTokenRepository)
    {
        this.operatorRepository = operatorRepository;
        this.operatorPetOrderSalesRepository = operatorPetOrderSalesRepository;
        this.operatorProductsOrderSalesRepository = operatorProductsOrderSalesRepository;
        this.userOrderRepository = userOrderRepository;
        this.userRepository = userRepository;
        this.sysTokenRepository = sysTokenRepository;
    }


    /**
     * find operator by operatorAccount
     * @param account
     * @return
     */
    @Override
    public Operator findByAccount(String account){
        return operatorRepository.findByAccount(account);
    }


    /**
     * find operatorPetOrderSales by order id
     * @param id
     * @return
     */
    @Override
    public OperatorPetOrderSales findPetOrderById(Integer id) {
        return operatorPetOrderSalesRepository.findBySalesOrderId(id);
    }

    @Override
    public List<OperatorPetOrderSales> getAllPetSales() {
        return operatorPetOrderSalesRepository.findAll();
    }

//    @Override
//    public List<OperatorPetOrderPurchase> getAllPetPurchase() {
//        return operatorPetOrderPurchaseRepository.findAll();
//    }

    @Override
    public void petOrderSalesSave(OperatorPetOrderSales operatorPetOrderSales) {
        operatorPetOrderSalesRepository.save(operatorPetOrderSales);
    }

    @Override
    public List<OperatorProductsOrderSales> getAllProductsSales() {
        return operatorProductsOrderSalesRepository.findAll();
    }

//    @Override
//    public List<OperatorProductsOrderPurchase> getAllProductsPurchase() {
//        return operatorProductsOrderPruchaseRepository.findAll();
//    }

    @Override
    public OperatorProductsOrderSales findProductsOrderById(Integer orderId) {
        return operatorProductsOrderSalesRepository.findBySalesOrderId(orderId);
    }

    @Override
    public void productsOrderSalesSave(OperatorProductsOrderSales operatorProductsOrderSales) {
        operatorProductsOrderSalesRepository.save(operatorProductsOrderSales);
    }

    @Override
    public UserOrder findUserOrderById(Integer userOrderId) {
        return userOrderRepository.findByUserOrderId(userOrderId);
    }

    @Override
    public void saveUserOrder(UserOrder userOrder) {
        userOrderRepository.save(userOrder);
    }

    @Override
    public User findUserByToken(String token) {
        SysToken sysToken = sysTokenRepository.findByToken(token);
        Integer userId = sysToken.getUserId();
        return userRepository.findByUserId(userId);
    }

    @Override
    public List<OperatorPetOrderSales> getAllPetSalesByUserOrderId(Integer userOrderId) {
        return operatorPetOrderSalesRepository.findAllByUserOrderId(userOrderId);
    }

    @Override
    public List<OperatorProductsOrderSales> getAllProductssalesByUserOrderId(Integer userOrderId) {
        return operatorProductsOrderSalesRepository.findAllByUserOrderId(userOrderId);
    }


}
