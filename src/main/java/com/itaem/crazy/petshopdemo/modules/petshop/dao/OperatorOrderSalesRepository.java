package com.itaem.crazy.petshopdemo.modules.petshop.dao;

import com.itaem.crazy.petshopdemo.modules.petshop.entity.OperatorOrderSales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperatorOrderSalesRepository extends JpaRepository<OperatorOrderSales, Integer> {
    OperatorOrderSales findBySalesOrderId(Integer salesOrderId);
}
