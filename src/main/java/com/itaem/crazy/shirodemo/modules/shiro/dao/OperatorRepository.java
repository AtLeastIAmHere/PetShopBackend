package com.itaem.crazy.shirodemo.modules.shiro.dao;

import com.itaem.crazy.shirodemo.modules.shiro.entity.Operator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperatorRepository  extends JpaRepository<Operator, Integer> {
    Operator findByOperatorId(Integer operatorId);

    Operator findByOperatorName(String operatorName);

    Operator findByAccount(String account);
}
