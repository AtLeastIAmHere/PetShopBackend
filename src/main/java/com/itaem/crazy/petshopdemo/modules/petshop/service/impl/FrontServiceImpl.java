package com.itaem.crazy.petshopdemo.modules.petshop.service.impl;

import com.itaem.crazy.petshopdemo.modules.petshop.config.LogManager;
import com.itaem.crazy.petshopdemo.modules.petshop.service.FrontService;
import com.itaem.crazy.petshopdemo.modules.petshop.dao.frontweb.BannerRepository;
import com.itaem.crazy.petshopdemo.modules.petshop.dao.frontweb.CategoryRepository;
import com.itaem.crazy.petshopdemo.modules.petshop.dao.frontweb.GoodPictureRepository;
import com.itaem.crazy.petshopdemo.modules.petshop.dao.frontweb.GoodRepository;
import com.itaem.crazy.petshopdemo.modules.petshop.dto.dto.GoodDTO;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.frontweb.Banner;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.frontweb.Category;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.frontweb.Good;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.frontweb.GoodPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;

@Service
public class FrontServiceImpl implements FrontService {

    @Autowired
    private BannerRepository bannerRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private GoodRepository goodRepository;
    @Autowired
    private GoodPictureRepository goodPictureRepository;

    @Override
    public List<Banner> FindAllBanner() {
        return bannerRepository.findAll();
    }

    @Override
    public Map<String, Object> CategoryHead() {
        Map<String,Object> result = new HashMap<>();
        List<Category> categoryList = categoryRepository.findAll();
        result.put("code","1");
        result.put("msg","操作成功");
        List<Map<String,Object>> list = new ArrayList<>();
        for (Category category:categoryList) {
            Map<String,Object> data = new HashMap<>();
            data.put("id",category.getId());
            data.put("name",category.getName());
            data.put("picture",category.getPicture());
            data.put("children",null);
            data.put("goods",goodRepository.findByCategoryId(category.getId()));
            list.add(data);
        }
        result.put("result",list);
        return result;
    }

    @Override
    public Map<String, Object> GoodList(GoodDTO goodDTO) {
//        LogManager.GetInstance().logger.info(goodDTO.getCategoryId());
        Integer id = Integer.valueOf(goodDTO.getCategoryId());
        List<Good> sysGoods = goodRepository.findByCategoryId(id);
        Map<String,Object> result = new HashMap<>();
        Integer count = sysGoods.size();
        result.put("counts",count);
        int fromId = (goodDTO.getPage() -1)*goodDTO.getPageSize();
        int endId = goodDTO.getPage()*goodDTO.getPageSize();
        if(count >= endId)
            result.put("items",sysGoods.subList(fromId,endId));
        else
            result.put("items",sysGoods.subList(fromId,count));
        result.put("page",goodDTO.getPage());
        result.put("pageSize",goodDTO.getPageSize());
        result.put("pages",count/goodDTO.getPageSize()+1);
        LogManager.GetInstance().logger.info(result.toString());
        return result;
    }

    @Override
    public Map<String, Object> Product(Integer id) {
        Map<String,Object> result = new HashMap<>();
        Good good = goodRepository.findGoodsByIdIs(id);
        if(good == null){
            LogManager.GetInstance().logger.info("111");
            result.put("code",400);
            result.put("msg","找不到该商品");
            return result;
        }
        result.put("id",good.getId());
        result.put("name",good.getName());
        result.put("desc",good.getDesc());
        double discount = Double.parseDouble(good.getDiscount());
        double oldPrice = Double.parseDouble(good.getPrice());
        double price = discount*oldPrice;
        DecimalFormat df   = new DecimalFormat("######0.00");
        result.put("price",df.format(price));
        result.put("oldPrice",df.format(oldPrice));
        result.put("discount",df.format(discount));
        result.put("inventory",Integer.valueOf(good.getOrderNum()));
        List<String> mainPictures = new ArrayList<>();
        List<GoodPicture> goodPictures = goodPictureRepository.findByGoodId(id);
        for(GoodPicture goodPicture:goodPictures){
            mainPictures.add(goodPicture.getUrl());
        }
        result.put("mainPictures",mainPictures);

        LogManager.GetInstance().logger.info(result.toString());
        return result;
    }
}
