package com.itaem.crazy.petshopdemo.modules.petshop.dao;

import com.itaem.crazy.petshopdemo.modules.petshop.entity.OperatorPet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperatorPetRepository extends JpaRepository<OperatorPet, Integer> {
    OperatorPet findByPetId(Integer petId);
}
