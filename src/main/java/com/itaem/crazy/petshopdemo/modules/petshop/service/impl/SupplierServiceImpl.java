package com.itaem.crazy.petshopdemo.modules.petshop.service.impl;

import com.itaem.crazy.petshopdemo.modules.petshop.service.SupplierService;
import com.itaem.crazy.petshopdemo.modules.petshop.dao.*;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final SupplierPetStockRepository supplierPetStockRepository;
    private final SupplierPetOrderSalesRepository supplierPetOrderSalesRepository;
    private final SupplierProductsStockRepository supplierProductsStockRepository;
    private final SupplierProductsOrderSalesRepository supplierProductsOrderSalesRepository;
    private final UserOrderRepository userOrderRepository;

    SupplierServiceImpl(SupplierRepository supplierRepository,
                        SupplierPetStockRepository supplierPetStockRepository,
                        SupplierPetOrderSalesRepository supplierPetOrderSalesRepository,
                        SupplierProductsStockRepository supplierProductsStockRepository,
                        SupplierProductsOrderSalesRepository supplierProductsOrderSalesRepository,
                        UserOrderRepository userOrderRepository)
    {
        this.supplierRepository = supplierRepository;
        this.supplierPetStockRepository = supplierPetStockRepository;
        this.supplierPetOrderSalesRepository = supplierPetOrderSalesRepository;
        this.supplierProductsStockRepository = supplierProductsStockRepository;
        this.supplierProductsOrderSalesRepository = supplierProductsOrderSalesRepository;
        this.userOrderRepository = userOrderRepository;
    }


    /**
     * find supplier by account
     * @param account
     * @return
     */
    @Override
    public Supplier findByAccount(String account){
        return supplierRepository.findByAccount(account);
    }

    @Override
    public List<SupplierPetStock> getAllPetStock() {
        return supplierPetStockRepository.findAll();
    }

    @Override
    public List<SupplierPetOrderSales> getAllPetOrders() {
        return supplierPetOrderSalesRepository.findAll();
    }

    @Override
    public SupplierPetOrderSales getPetOrderById(Integer orderId) {
        return supplierPetOrderSalesRepository.findBySalesOrderId(orderId);
    }

    @Override
    public SupplierPetStock getPetStockById(Integer petId) {
        return supplierPetStockRepository.findByStockPetId(petId);
    }

    @Override
    public void petOrdersSave(SupplierPetOrderSales supplierPetOrderSales) {
        supplierPetOrderSalesRepository.save(supplierPetOrderSales);
    }

    @Override
    public void petStockSave(SupplierPetStock supplierPetStock) {
        supplierPetStockRepository.save(supplierPetStock);
    }

    @Override
    public List<SupplierProductsStock> getAllProductsStock() {
        return supplierProductsStockRepository.findAll();
    }

    @Override
    public List<SupplierProductsOrderSales> getAllProductsOrders() {
        return supplierProductsOrderSalesRepository.findAll();
    }

    @Override
    public SupplierProductsOrderSales getProductsOrderById(Integer orderId) {
        return supplierProductsOrderSalesRepository.findBySalesOrderId(orderId);
    }

    @Override
    public SupplierProductsStock findProductStockById(Integer productId) {
        return supplierProductsStockRepository.findByStockProductId(productId);
    }

    @Override
    public void productsOrdersSave(SupplierProductsOrderSales supplierProductsOrderSales) {
        supplierProductsOrderSalesRepository.save(supplierProductsOrderSales);
    }

    @Override
    public void productsStockSave(SupplierProductsStock supplierProductsStock) {
        supplierProductsStockRepository.save(supplierProductsStock);
    }

    @Override
    public UserOrder getUserOrderById(Integer userOrderId) {
        return userOrderRepository.findByUserOrderId(userOrderId);
    }

    @Override
    public void saveUserOrder(UserOrder userOrder) {
        userOrderRepository.save(userOrder);
    }


}
