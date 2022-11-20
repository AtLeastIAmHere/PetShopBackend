package com.itaem.crazy.petshopdemo.modules.petshop.dao;

import com.itaem.crazy.petshopdemo.modules.petshop.entity.SupplierPetStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierPetStockRepository extends JpaRepository<SupplierPetStock, Integer> {
    SupplierPetStock findByStockPetId(Integer petId);
}
