package com.itaem.crazy.shirodemo.modules.shiro.dao;

import com.itaem.crazy.shirodemo.modules.shiro.entity.OperatorPet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperatorPetRepository extends JpaRepository<OperatorPet, Integer> {
    OperatorPet findByPetId(Integer petId);
}
