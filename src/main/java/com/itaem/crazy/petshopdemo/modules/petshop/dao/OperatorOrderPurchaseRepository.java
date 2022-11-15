package com.itaem.crazy.petshopdemo.modules.petshop.dao;

import com.itaem.crazy.petshopdemo.modules.petshop.entity.OperatorOrderPurchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperatorOrderPurchaseRepository extends JpaRepository<OperatorOrderPurchase, Integer> {
    OperatorOrderPurchase findByPurchaseOrderId(Integer purchaseOrderId);
}
