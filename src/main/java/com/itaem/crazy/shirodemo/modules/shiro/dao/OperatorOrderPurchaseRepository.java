package com.itaem.crazy.shirodemo.modules.shiro.dao;

import com.itaem.crazy.shirodemo.modules.shiro.entity.OperatorOrderPurchase;
import org.hibernate.dialect.Ingres9Dialect;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperatorOrderPurchaseRepository extends JpaRepository<OperatorOrderPurchase, Integer> {
    OperatorOrderPurchase findByPurchaseOrderId(Integer purchaseOrderId);
}
