package com.itaem.crazy.petshopdemo.modules.petshop.service;

import com.itaem.crazy.petshopdemo.modules.petshop.entity.*;
import io.swagger.models.auth.In;

import java.util.List;

public interface OperatorService {
    /**
     * find operator by account
     * @param account
     * @return
     */
    Operator findByAccount(String account);

    /**
     * find pet sales order by orderId
     * @param orderId
     * @return
     */
    OperatorPetOrderSales findPetOrderById(Integer orderId);

    /**
     * get all pet sales order
     * @return
     */
    List<OperatorPetOrderSales> getAllPetSales();

//    /**
//     * find all pet purchase order
//     * @return
//     */
//    List<OperatorPetOrderPurchase> getAllPetPurchase();

    /**
     * change pet sales order
     * @param operatorPetOrderSales
     */
    void petOrderSalesSave(OperatorPetOrderSales operatorPetOrderSales);

    /**
     * get all products sales order
     * @return
     */
    List<OperatorProductsOrderSales> getAllProductsSales();

//    /**
//     * get all products purchase order
//     * @return
//     */
//    List<OperatorProductsOrderPurchase> getAllProductsPurchase();

    /**
     * find products sales order by orderId
     * @param orderId
     * @return
     */
    OperatorProductsOrderSales findProductsOrderById(Integer orderId);

    /**
     * change products sales order
     * @param operatorProductsOrderSales
     */
    void productsOrderSalesSave(OperatorProductsOrderSales operatorProductsOrderSales);

    /**
     * find UserOrder by id
     * @param userOrderId
     * @return
     */
    UserOrder findUserOrderById(Integer userOrderId);

    /**
     * add/change userOrder
     * @param userOrder
     */
    void saveUserOrder(UserOrder userOrder);

    /**
     * find user by user token
     * @param token
     * @return
     */
    User findUserByToken(String token);

    /**
     * find all petOrderSales by userOrderId
     * @param userOrderId
     * @return
     */
    List<OperatorPetOrderSales> getAllPetSalesByUserOrderId(Integer userOrderId);

    /**
     * find all productOrderSales by userOrderId
     * @param userOrderId
     * @return
     */
    List<OperatorProductsOrderSales> getAllProductssalesByUserOrderId(Integer userOrderId);

}
