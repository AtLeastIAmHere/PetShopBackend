package com.itaem.crazy.petshopdemo.modules.petshop.dao;

import com.itaem.crazy.petshopdemo.modules.petshop.entity.SupplierStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierStockRepository extends JpaRepository<SupplierStock, Integer> {
    SupplierStock findByStockPetId(Integer stockPetId);
}
