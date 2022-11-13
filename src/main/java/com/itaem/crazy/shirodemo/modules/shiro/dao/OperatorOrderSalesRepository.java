package com.itaem.crazy.shirodemo.modules.shiro.dao;

import com.itaem.crazy.shirodemo.modules.shiro.entity.OperatorOrderSales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperatorOrderSalesRepository extends JpaRepository<OperatorOrderSales, Integer> {
    OperatorOrderSales findBySalesOrderId(Integer salesOrderId);
}
