package com.itaem.crazy.petshopdemo.modules.petshop.controller.frontweb;


import com.itaem.crazy.petshopdemo.modules.petshop.config.LogManager;
import com.itaem.crazy.petshopdemo.modules.petshop.dto.dto.GoodDTO;
import com.itaem.crazy.petshopdemo.modules.petshop.service.FrontService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "获取商品信息")
@RestController
public class FrontController {
    @Autowired
    private FrontService frontService;

    /**
     * 登录
     */
    @ApiOperation(value = "登陆", notes = "参数:用户名 密码")
    @GetMapping("/front/home/banner")
    public Map<String,Object> banner(){
        Map<String, Object> result = new HashMap<>();
        result.put("code","1");
        result.put("msg","操作成功");
        result.put("result", frontService.FindAllBanner());
        return result;
    }

    @GetMapping("/front/home/category/head")
    public Map<String,Object> category(){
        return frontService.CategoryHead();
    }

    @PostMapping("/front/category/goods/temporary")
    public Map<String,Object> GoodList(@RequestBody @Validated GoodDTO goodDTO){
        return frontService.GoodList(goodDTO);
    }

    @GetMapping("/front/goods")
    public Map<String,Object> product(@RequestParam Integer id){
        LogManager.GetInstance().logger.info(id.toString());
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> data = new HashMap<>();
        try{
            data = frontService.Product(id);
        }catch (Exception e){
            result.put("code",400);
            result.put("msg","获取失败");
            return result;
        }
        result.put("code","1");
        result.put("msg","操作成功");
        result.put("result",data);
        return result;
    }
}
