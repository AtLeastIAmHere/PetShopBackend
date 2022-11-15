package com.itaem.crazy.petshopdemo.modules.petshop.service.impl;

import com.itaem.crazy.petshopdemo.modules.petshop.dao.SupplierRepository;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.Supplier;
import com.itaem.crazy.petshopdemo.modules.petshop.service.SupplierService;
import org.springframework.stereotype.Service;


@Service
public class SupplierServiceImpl implements SupplierService {
    private SupplierRepository supplierRepository;

    SupplierServiceImpl(SupplierRepository supplierRepository){ this.supplierRepository = supplierRepository; }

    @Override
    public Supplier findByAccount(String account){
        return supplierRepository.findByAccount(account);
    }
}
