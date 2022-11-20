package com.itaem.crazy.petshopdemo.modules.petshop.dao;

import com.itaem.crazy.petshopdemo.modules.petshop.entity.SupplierProductsOrderSales;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SupplierProductsOrderSalesRepository extends JpaRepository<SupplierProductsOrderSales, Integer> {
    SupplierProductsOrderSales findBySalesOrderId(Integer salesOrderId);
}
