package com.itaem.crazy.petshopdemo.modules.petshop.dao.frontweb;

import com.itaem.crazy.petshopdemo.modules.petshop.entity.frontweb.SysToken;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SysTokenRepository extends JpaRepository<SysToken, Integer> {

    SysToken findByToken(String token);

    SysToken findByUserId(Integer userId);
}
