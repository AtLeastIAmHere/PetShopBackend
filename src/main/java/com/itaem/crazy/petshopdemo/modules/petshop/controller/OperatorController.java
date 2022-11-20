package com.itaem.crazy.petshopdemo.modules.petshop.controller;

import com.itaem.crazy.petshopdemo.modules.petshop.dto.ConfirmOrderDTO;
import com.itaem.crazy.petshopdemo.modules.petshop.dto.LoginDTO;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.*;
import com.itaem.crazy.petshopdemo.modules.petshop.service.OperatorService;
import com.itaem.crazy.petshopdemo.modules.petshop.service.SupplierService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * 1. 登录接口
 * 2. 获取已完成的销售订单（宠物、宠物用品）
 * 3. 获取进货账单（宠物、宠物用品）-——————————取消
 * 4. 获取未处理订单
 * 5. 确认宠物订单：确认订单，供应商增加待处理订单
 * 6. 确认宠物用品订单：确认订单，供应商增加待处理订单
 * 7. 拒绝用户宠物订单：取消用户的宠物订单，取消管理员订单，返回用户购物车
 * 8. 拒绝用户宠物商品订单：取消用户的宠物商品订单，取消管理员订单，返回用户购物车
 *
 * 未实现：接口7，接口8
 *
 * 待测试：5、6中的更新订单状态; 7, 8
 *
 */


@Api(tags = "商店管理员")
@RestController
public class OperatorController {
    private final OperatorService operatorService;
    private final SupplierService supplierService;

    OperatorController(OperatorService operatorService, SupplierService supplierService) {
        this.operatorService = operatorService;
        this.supplierService = supplierService;
    }


    /**
     * 1. 登录接口
     */
    @ApiOperation(value = "登录", notes = "参数:账号 密码")
    @PostMapping("/operator/login")
    public Map<String, Object> login(@RequestBody @Validated LoginDTO loginDTO, BindingResult bindingResult) {
        Map<String, Object> result = new HashMap<>();
        if (bindingResult.hasErrors()) {
            result.put("status", 400);
            result.put("msg", bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        String account = loginDTO.getAccount();
        String password = loginDTO.getPassword();

        //用户信息
        Operator operator = operatorService.findByAccount(account);
        //账号不存在、密码错误
        if (operator == null || !operator.getPassword().equals(password)) {
            result.put("status", 400);
            result.put("msg", "账号或密码有误");
        } else {
            result.put("token", "123456");
            result.put("status", 200);
            result.put("msg", "登录成功");
            result.put("result",operator);
        }
        return result;
    }


    /**
     * 2. 获取已完成的销售订单
     */
    @ApiOperation(value = "获取已完成的销售账单", notes = "无参数")
    @PostMapping("/operator/getOrders/sales")
    public Map<String, Object> getSalesOrdersFinish() {
        Map<String, Object> result = new HashMap<>();

        // 查看所有订单
        List<OperatorPetOrderSales> petSalesList = operatorService.getAllPetSales();
        List<OperatorProductsOrderSales> productsSalesList = operatorService.getAllProductsSales();

        List<OperatorPetOrderSales> petSalesFinish = new ArrayList<>();
        List<OperatorProductsOrderSales> productsSalesFinish = new ArrayList<>();


        // 选择已完成的订单加入到结果中
        for(int i = 0; i < petSalesList.size(); ++i){
            if(petSalesList.get(i).getIsConfirm().equals("1")){
                petSalesFinish.add(petSalesList.get(i));
            }
        }

        for(int i = 0; i < productsSalesList.size(); ++i){
            if(productsSalesList.get(i).getIsConfirm().equals("1")){
                productsSalesFinish.add(productsSalesList.get(i));
            }
        }

        result.put("status", 200);
        result.put("msg", "已完成销售订单单获取成功");
        result.put("宠物销售订单", petSalesFinish);
        result.put("宠物用品销售订单", productsSalesFinish);

        return result;
    }


//    /**
//     * 3. 获取进货账单
//     */
//    @ApiOperation(value = "获取进货账单", notes = "参数:无")
//    @PostMapping("/operator/getOrders/purchase")
//    public Map<String, Object> getPurchaseOrders() {
//        Map<String, Object> result = new HashMap<>();
//
//        List<OperatorPetOrderPurchase> petPurchasesList = operatorService.getAllPetPurchase();
//        List<OperatorProductsOrderPurchase> productsPurchaseList = operatorService.getAllProductsPurchase();
//
//        // 获取成功，返回账单
//        result.put("status", 200);
//        result.put("msg", "进货账单获取成功");
//        result.put("宠物进货账单", petPurchasesList);
//        result.put("宠物用品进货账单", productsPurchaseList);
//
//        return result;
//    }


    /**
     * 4. 获取未处理的销售订单
     */
    @ApiOperation(value = "获取未处理的销售订单", notes = "无参数")
    @PostMapping("/operator/getOrders/notConfirm")
    public Map<String, Object> getSalesOrdersNotFinish() {
        Map<String, Object> result = new HashMap<>();

        // 查看所有订单
        List<OperatorPetOrderSales> petSalesList = operatorService.getAllPetSales();
        List<OperatorProductsOrderSales> productsSalesList = operatorService.getAllProductsSales();

        List<OperatorPetOrderSales> petSalesFinish = new ArrayList<>();
        List<OperatorProductsOrderSales> productsSalesFinish = new ArrayList<>();


        // 选择已完成的订单加入到结果中
        for(int i = 0; i < petSalesList.size(); ++i){
            if(petSalesList.get(i).getIsConfirm().equals("0")){
                petSalesFinish.add(petSalesList.get(i));
            }
        }

        for(int i = 0; i < productsSalesList.size(); ++i){
            if(productsSalesList.get(i).getIsConfirm().equals("0")){
                productsSalesFinish.add(productsSalesList.get(i));
            }
        }

        // 根据订单时间进行排序
        Collections.sort(petSalesFinish, new Comparator<OperatorPetOrderSales>(){
            @Override
            public int compare(OperatorPetOrderSales s1, OperatorPetOrderSales s2){
                return s1.getOrderDate().compareTo(s2.getOrderDate());
            }
        });

        Collections.sort(productsSalesFinish, new Comparator<OperatorProductsOrderSales>(){
            @Override
            public int compare(OperatorProductsOrderSales s1, OperatorProductsOrderSales s2){
                return s1.getOrderDate().compareTo(s2.getOrderDate());
            }
        });

        // 加入到结果中
        result.put("status", 200);
        result.put("msg", "成功获取未处理的销售账单");
        result.put("宠物销售订单", petSalesFinish);
        result.put("宠物用品销售订单", productsSalesFinish);

        return result;
    }


    /**
     * 5. 确认宠物订单：确认订单，供应商增加待处理订单
     */
    @ApiOperation(value = "确认订单", notes = "参数：宠物订单id")
    @PostMapping("/operator/confirmOrder/pet")
    public Map<String, Object> orderPetConfirm(@RequestBody ConfirmOrderDTO confirmOrderDTO){
        Map<String, Object> result = new HashMap<>();

        Integer orderId = confirmOrderDTO.getOrderId();
        OperatorPetOrderSales operatorPetOrderSales = operatorService.findPetOrderById(orderId);

        // 查找该订单是否合法
        if(operatorPetOrderSales == null){
            result.put("status", 400);
            result.put("msg", "订单确认失败，请联系后台");
            return result;
        }

        operatorPetOrderSales.setIsConfirm("1");
        operatorService.petOrderSalesSave(operatorPetOrderSales);

        // 更改GoodStatus状态

        // 供应商增加未处理订单
        SupplierPetOrderSales supplierPetOrderSales = new SupplierPetOrderSales();
        supplierPetOrderSales.setSalesPetId(operatorPetOrderSales.getSalesPetId());
        supplierPetOrderSales.setSalesPetQuantity(operatorPetOrderSales.getSalesPetQuantity());
        supplierPetOrderSales.setSalesPetPrice(operatorPetOrderSales.getSalesPetPrice());
        supplierPetOrderSales.setPetshopId(1);
        supplierPetOrderSales.setPetshopName("Wuli");
        supplierPetOrderSales.setPetshopPhone("12345678");
        supplierPetOrderSales.setPetshopAddress("Hubei Province Wuhan University of Technology");
        supplierPetOrderSales.setPetshopRemarks("None");
        supplierPetOrderSales.setUserId(operatorPetOrderSales.getUserId());
        supplierPetOrderSales.setUserOrderId(operatorPetOrderSales.getUserOrderId());
        supplierPetOrderSales.setUserName(operatorPetOrderSales.getUserName());
        supplierPetOrderSales.setUserPhone(operatorPetOrderSales.getUserPhone());
        supplierPetOrderSales.setUserAddress(operatorPetOrderSales.getUserAddress());
        supplierPetOrderSales.setUserRemarks(operatorPetOrderSales.getUserRemarks());
        supplierPetOrderSales.setOrderDate(operatorPetOrderSales.getOrderDate());
        supplierPetOrderSales.setSalesAllPrice(operatorPetOrderSales.getSalesAllPrice());
        supplierPetOrderSales.setIsDelivery("0");

        supplierService.petOrdersSave(supplierPetOrderSales);


        result.put("status", 200);
        result.put("msg", "订单确认成功，已发往供应商");
        return result;
    }


    /**
     * 6. 确认宠物用品订单：确认订单，供应商增加待处理订单
     */
    @ApiOperation(value = "确认订单", notes = "参数：宠物用品订单id")
    @PostMapping("/operator/confirmOrder/products")
    public Map<String, Object> orderProductsConfirm(@RequestBody ConfirmOrderDTO confirmOrderDTO){
        Map<String, Object> result = new HashMap<>();

        Integer orderId = confirmOrderDTO.getOrderId();
        OperatorProductsOrderSales operatorProductsOrderSales = operatorService.findProductsOrderById(orderId);

        // 查找该订单是否合法
        if(operatorProductsOrderSales == null){
            result.put("status", 400);
            result.put("msg", "订单确认失败，请联系后台");
            return result;
        }

        operatorProductsOrderSales.setIsConfirm("1");
        operatorService.productsOrderSalesSave(operatorProductsOrderSales);


        // 供应商增加未处理订单
        SupplierProductsOrderSales supplierProductsOrderSales = new SupplierProductsOrderSales();
        supplierProductsOrderSales.setSalesProductsId(operatorProductsOrderSales.getSalesProductsId());
        supplierProductsOrderSales.setSalesProductsQuantity(operatorProductsOrderSales.getSalesProductsQuantity());
        supplierProductsOrderSales.setSalesProductsPrice(operatorProductsOrderSales.getSalesProductsPrice());
        supplierProductsOrderSales.setPetshopId(1);
        supplierProductsOrderSales.setPetshopName("Wuli");
        supplierProductsOrderSales.setPetshopPhone("12345678");
        supplierProductsOrderSales.setPetshopAddress("Hubei Province Wuhan University of Technology");
        supplierProductsOrderSales.setPetshopRemarks("None");
        supplierProductsOrderSales.setUserOrderId(operatorProductsOrderSales.getUserOrderId());
        supplierProductsOrderSales.setUserName(operatorProductsOrderSales.getUserName());
        supplierProductsOrderSales.setUserPhone(operatorProductsOrderSales.getUserPhone());
        supplierProductsOrderSales.setUserPhone(operatorProductsOrderSales.getUserPhone());
        supplierProductsOrderSales.setUserAddress(operatorProductsOrderSales.getUserAddress());
        supplierProductsOrderSales.setUserRemarks(operatorProductsOrderSales.getUserRemarks());
        supplierProductsOrderSales.setOrderDate(operatorProductsOrderSales.getOrderDate());
        supplierProductsOrderSales.setSalesAllPrice(operatorProductsOrderSales.getSalesAllPrice());
        supplierProductsOrderSales.setIsDelivery("0");

        supplierService.productsOrdersSave(supplierProductsOrderSales);



        result.put("status", 200);
        result.put("msg", "订单确认成功，已发往供应商");
        return result;
    }


    /**
     * 7. 拒绝宠物订单
     */
    @ApiOperation(value = "拒绝宠物订单", notes = "参数：宠物订单id")
    @PostMapping("/operator/refuseOrder/Pet")
    public Map<String, Object> orderPetRefuse(@RequestBody ConfirmOrderDTO confirmOrderDTO){
        Integer orderId = confirmOrderDTO.getOrderId();
        Map<String, Object> result = new HashMap<>();

        OperatorPetOrderSales petOrderSales = operatorService.findPetOrderById(orderId);
        UserOrder userOrder = operatorService.findUserOrderById(petOrderSales.getSalesOrderId());

        // 商家拒绝订单，更改订单状态
        userOrder.setOrderState(5);
        petOrderSales.setIsConfirm("-1");

        operatorService.saveUserOrder(userOrder);
        operatorService.petOrderSalesSave(petOrderSales);

        result.put("status", 200);
        result.put("msg", "已退回该订单");
        return result;
    }


    /**
     * 8. 拒绝宠物用品订单
     */
    @ApiOperation(value = "拒绝宠物用品订单", notes = "参数：宠物用品订单id")
    @PostMapping("/operator/refuseOrder/Product")
    public Map<String, Object> orderProductRefuse(@RequestBody ConfirmOrderDTO confirmOrderDTO){
        Integer orderId = confirmOrderDTO.getOrderId();
        Map<String, Object> result = new HashMap<>();

        OperatorProductsOrderSales productsOrderSales = operatorService.findProductsOrderById(orderId);
        UserOrder userOrder = operatorService.findUserOrderById(productsOrderSales.getSalesOrderId());

        // 商家拒绝订单，更改订单状态
        userOrder.setOrderState(5);
        productsOrderSales.setIsConfirm("-1");

        operatorService.saveUserOrder(userOrder);
        operatorService.productsOrderSalesSave(productsOrderSales);

        result.put("status", 200);
        result.put("msg", "已退回该订单");
        return result;
    }

}
