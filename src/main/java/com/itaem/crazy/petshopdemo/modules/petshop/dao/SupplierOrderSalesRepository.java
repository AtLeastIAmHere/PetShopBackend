package com.itaem.crazy.petshopdemo.modules.petshop.dao;

import com.itaem.crazy.petshopdemo.modules.petshop.entity.SupplierOrderSales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierOrderSalesRepository extends JpaRepository<SupplierOrderSales, Integer> {
    SupplierOrderSales findBySalesOrderId(Integer salesOrderId);
}
