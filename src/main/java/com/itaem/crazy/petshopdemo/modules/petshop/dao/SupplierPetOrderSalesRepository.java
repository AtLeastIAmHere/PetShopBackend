package com.itaem.crazy.petshopdemo.modules.petshop.dao;

import com.itaem.crazy.petshopdemo.modules.petshop.entity.SupplierPetOrderSales;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.SupplierProductsOrderSales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierPetOrderSalesRepository extends JpaRepository<SupplierPetOrderSales, Integer> {
    SupplierPetOrderSales findBySalesOrderId(Integer salesOrderId);
}
