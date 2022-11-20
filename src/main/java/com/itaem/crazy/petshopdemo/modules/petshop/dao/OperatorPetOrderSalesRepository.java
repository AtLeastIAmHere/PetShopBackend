package com.itaem.crazy.petshopdemo.modules.petshop.dao;

import com.itaem.crazy.petshopdemo.modules.petshop.entity.OperatorPetOrderSales;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperatorPetOrderSalesRepository extends JpaRepository<OperatorPetOrderSales, Integer> {
    OperatorPetOrderSales findBySalesOrderId(Integer salesOrderId);

    List<OperatorPetOrderSales> findAllByUserOrderId(Integer userOrderId);
}
