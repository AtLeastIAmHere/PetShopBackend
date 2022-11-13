package com.itaem.crazy.shirodemo.modules.shiro.dao;

import com.itaem.crazy.shirodemo.modules.shiro.entity.SupplierStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierStockRepository extends JpaRepository<SupplierStock, Integer> {
    SupplierStock findByStockPetId(Integer stockPetId);
}
