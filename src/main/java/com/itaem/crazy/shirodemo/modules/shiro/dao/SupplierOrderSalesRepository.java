package com.itaem.crazy.shirodemo.modules.shiro.dao;

import com.itaem.crazy.shirodemo.modules.shiro.entity.SupplierOrderSales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierOrderSalesRepository extends JpaRepository<SupplierOrderSales, Integer> {
    SupplierOrderSales findBySalesOrderId(Integer salesOrderId);
}
