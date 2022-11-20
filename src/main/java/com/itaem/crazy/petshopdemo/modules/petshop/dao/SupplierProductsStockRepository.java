package com.itaem.crazy.petshopdemo.modules.petshop.dao;

import com.itaem.crazy.petshopdemo.modules.petshop.entity.SupplierPetStock;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.SupplierProductsStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierProductsStockRepository extends JpaRepository<SupplierProductsStock, Integer> {
    SupplierProductsStock findByStockProductId(Integer id);
}
