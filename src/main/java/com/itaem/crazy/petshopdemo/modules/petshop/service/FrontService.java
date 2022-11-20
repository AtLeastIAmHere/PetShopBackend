package com.itaem.crazy.petshopdemo.modules.petshop.service;

import com.itaem.crazy.petshopdemo.modules.petshop.dto.dto.GoodDTO;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.frontweb.Banner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface FrontService {

    List<Banner> FindAllBanner();

    Map<String,Object> CategoryHead();

    Map<String,Object> GoodList(GoodDTO goodDTO);

    Map<String,Object> Product(Integer id);
}
