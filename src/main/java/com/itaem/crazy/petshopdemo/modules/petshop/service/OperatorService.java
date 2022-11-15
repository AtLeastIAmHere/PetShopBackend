package com.itaem.crazy.petshopdemo.modules.petshop.service;

import com.itaem.crazy.petshopdemo.modules.petshop.entity.Operator;

public interface OperatorService {
    Operator findByAccount(String account);
}
