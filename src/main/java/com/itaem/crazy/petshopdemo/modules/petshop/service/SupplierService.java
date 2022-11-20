package com.itaem.crazy.petshopdemo.modules.petshop.service;


import com.itaem.crazy.petshopdemo.modules.petshop.entity.*;

import java.util.List;

public interface SupplierService {
    /**
     * find supplier by account
     * @param account
     * @return
     */
    Supplier findByAccount(String account);

    /**
     * get all pet stock
     * @return
     */
    List<SupplierPetStock> getAllPetStock();

    /**
     * get all pet orders
     * @return
     */
    List<SupplierPetOrderSales> getAllPetOrders();

    /**
     * find pet order by orderId
     * @param orderId
     * @return
     */
    SupplierPetOrderSales getPetOrderById(Integer orderId);

    /**
     * find pet stock by petId
     * @param petId
     * @return
     */
    SupplierPetStock getPetStockById(Integer petId);

    /**
     * change pet Order
     * @param supplierPetOrderSales
     */
    void petOrdersSave(SupplierPetOrderSales supplierPetOrderSales);

    /**
     * change pet Stock
     * @param supplierPetStock
     */
    void petStockSave(SupplierPetStock supplierPetStock);


    /**
     * get all products stock
     * @return
     */
    List<SupplierProductsStock> getAllProductsStock();

    /**
     * get all products orders
     * @return
     */
    List<SupplierProductsOrderSales> getAllProductsOrders();


    /**
     * find pruducts order by orderId
     * @param orderId
     * @return
     */
    SupplierProductsOrderSales getProductsOrderById(Integer orderId);

    /**
     * find products Stock by productId
     * @param productId
     * @return
     */
    SupplierProductsStock findProductStockById(Integer productId);

    /**
     * change products Order
     * @param supplierProductsOrderSales
     */
    void productsOrdersSave(SupplierProductsOrderSales supplierProductsOrderSales);

    /**
     * change products Stock
     * @param supplierProductsStock
     */
    void productsStockSave(SupplierProductsStock supplierProductsStock);

    /**
     * find UserOrder by userOrder id
     * @param userOrderId
     * @return
     */
    UserOrder getUserOrderById(Integer userOrderId);

    /**
     * save UserOrder
     * @param userOrder
     */
    void saveUserOrder(UserOrder userOrder);

}
