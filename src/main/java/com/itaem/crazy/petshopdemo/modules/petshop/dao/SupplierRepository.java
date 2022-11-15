package com.itaem.crazy.petshopdemo.modules.petshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.Supplier;


public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
    Supplier findBySupplierId(Integer supplierId);

    Supplier findByAccount(String account);
}
