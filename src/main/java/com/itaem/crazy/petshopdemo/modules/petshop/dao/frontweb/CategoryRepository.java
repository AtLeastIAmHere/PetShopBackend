package com.itaem.crazy.petshopdemo.modules.petshop.dao.frontweb;

import com.itaem.crazy.petshopdemo.modules.petshop.entity.frontweb.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
