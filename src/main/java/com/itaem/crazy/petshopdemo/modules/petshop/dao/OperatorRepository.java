package com.itaem.crazy.petshopdemo.modules.petshop.dao;

import com.itaem.crazy.petshopdemo.modules.petshop.entity.Operator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperatorRepository extends JpaRepository<Operator, Integer> {
    Operator findByOperatorId(Integer operatorId);

    Operator findByOperatorName(String operatorName);

    Operator findByAccount(String account);
}
