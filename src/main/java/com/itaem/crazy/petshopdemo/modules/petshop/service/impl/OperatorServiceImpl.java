package com.itaem.crazy.petshopdemo.modules.petshop.service.impl;

import com.itaem.crazy.petshopdemo.modules.petshop.dao.OperatorRepository;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.Operator;
import com.itaem.crazy.petshopdemo.modules.petshop.service.OperatorService;
import org.springframework.stereotype.Service;

@Service
public class OperatorServiceImpl implements OperatorService{
    private OperatorRepository operatorRepository;

    OperatorServiceImpl(OperatorRepository operatorRepository){ this.operatorRepository = operatorRepository; }

    @Override
    public Operator findByAccount(String account){
        return operatorRepository.findByAccount(account);
    }
}
