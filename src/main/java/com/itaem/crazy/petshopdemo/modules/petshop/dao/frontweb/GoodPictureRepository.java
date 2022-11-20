package com.itaem.crazy.petshopdemo.modules.petshop.dao.frontweb;

import com.itaem.crazy.petshopdemo.modules.petshop.entity.frontweb.GoodPicture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodPictureRepository extends JpaRepository<GoodPicture,Integer> {
    List<GoodPicture> findByGoodId(Integer id);
}
