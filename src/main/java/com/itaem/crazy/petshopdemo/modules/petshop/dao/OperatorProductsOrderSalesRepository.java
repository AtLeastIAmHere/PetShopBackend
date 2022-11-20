package com.itaem.crazy.petshopdemo.modules.petshop.dao;

import com.itaem.crazy.petshopdemo.modules.petshop.entity.OperatorProductsOrderSales;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperatorProductsOrderSalesRepository extends JpaRepository<OperatorProductsOrderSales, Integer> {
    OperatorProductsOrderSales findBySalesOrderId(Integer id);

    List<OperatorProductsOrderSales> findAllByUserOrderId(Integer userOrderId);
}
