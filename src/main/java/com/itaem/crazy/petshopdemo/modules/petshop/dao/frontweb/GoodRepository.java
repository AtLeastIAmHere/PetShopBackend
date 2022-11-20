package com.itaem.crazy.petshopdemo.modules.petshop.dao.frontweb;

import com.itaem.crazy.petshopdemo.modules.petshop.entity.frontweb.Good;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodRepository extends JpaRepository<Good,Integer> {
    List<Good> findByCategoryId(int id);

    Good findGoodsByIdIs(Integer id);

}
