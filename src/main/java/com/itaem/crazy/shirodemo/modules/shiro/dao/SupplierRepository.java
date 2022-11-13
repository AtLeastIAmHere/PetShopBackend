package com.itaem.crazy.shirodemo.modules.shiro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.function.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
    Supplier findBySupplierId(Integer supplierId);
}
