package com.itaem.crazy.petshopdemo.modules.petshop.service;


import com.itaem.crazy.petshopdemo.modules.petshop.entity.Supplier;

public interface SupplierService {
    Supplier findByAccount(String account);
}
