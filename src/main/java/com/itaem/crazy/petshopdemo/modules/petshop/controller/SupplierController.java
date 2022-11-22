package com.itaem.crazy.petshopdemo.modules.petshop.controller;

import com.itaem.crazy.petshopdemo.modules.petshop.dto.ConfirmOrderDTO;
import com.itaem.crazy.petshopdemo.modules.petshop.dto.LoginDTO;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.*;
import com.itaem.crazy.petshopdemo.modules.petshop.service.SupplierService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Api(tags = "供应商")
@RestController
public class SupplierController {
    private final SupplierService supplierService;

    SupplierController(SupplierService supplierService){ this.supplierService = supplierService; }

    /**
     * 1. 登录
     * 2. 返回库存信息（宠物+宠物用品）
     * 3. 返回已完成订单
     * 4. 返回未发货订单
     * 5. 宠物发货：修改宠物库存信息、供应商账单、用户帐单
     * 6. 宠物用品发货：修改宠物库存信息、供应商账单、用户帐单
     *
     *  待测试 5、6
     */

    /**
     * 1. 登录
     */
    @ApiOperation(value = "登录", notes = "参数:账号 密码")
    @PostMapping("/supplier/login")
    public Map<String, Object> login(@RequestBody @Validated LoginDTO loginDTO, BindingResult bindingResult) {
        Map<String, Object> result = new HashMap<>();
        if (bindingResult.hasErrors()) {
            result.put("status", 400);
            result.put("msg", bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        String account = loginDTO.getAccount();
        String password = loginDTO.getPassword();

        // 获取供应商信息
        Supplier supplier = supplierService.findByAccount(account);
        // 获取账号不存在、密码错误
        if (supplier == null || !supplier.getPassword().equals(password)) {
            result.put("status", 400);
            result.put("msg", "账号或密码有误");
        } else {
            result.put("token", "123456");
            result.put("status", 200);
            result.put("msg", "登录成功");
            result.put("result",supplier);
        }
        return result;
    }

    /**
     * 2.0. 返回库存信息（宠物+用品）
     */
    @ApiOperation(value = "获取库存", notes = "参数:无")
    @PostMapping("/supplier/getStock")
    public Map<String, Object> getStock() {
        Map<String, Object> result = new HashMap<>();

        List<SupplierProductsStock> supplierProductsStockList = supplierService.getAllProductsStock();
        List<SupplierPetStock> supplierPetStocksList = supplierService.getAllPetStock();

        if (supplierPetStocksList == null || supplierProductsStockList == null) {
            // 如果为null则可能获取失败
            result.put("status", 400);
            result.put("msg", "库存获取失败，请联系后台");
        } else {
            // 获取成功，返回账单
            result.put("status", 200);
            result.put("msg", "所有库存获取成功");
            result.put("宠物库存", supplierPetStocksList);
            result.put("宠物用品库存", supplierProductsStockList);
        }
        return result;
    }

    /**
     * 2.1. 返回库存信息（宠物）
     */
    @ApiOperation(value = "获取宠物库存", notes = "参数:无")
    @PostMapping("/supplier/getStock/pet")
    public Map<String, Object> getPetStock() {
        Map<String, Object> result = new HashMap<>();

        List<SupplierPetStock> supplierPetStocksList = supplierService.getAllPetStock();

        if (supplierPetStocksList == null) {
            // 如果为null则可能获取失败
            result.put("status", 400);
            result.put("msg", "库存获取失败，请联系后台");
        } else {
            // 获取成功，返回账单
            result.put("status", 200);
            result.put("msg", "库存获取成功");
            result.put("宠物库存", supplierPetStocksList);
        }
        return result;
    }

    /**
     * 2.2. 返回库存信息（宠物用品）
     */
    @ApiOperation(value = "获取宠物用品库存", notes = "参数:无")
    @PostMapping("/supplier/getStock/products")
    public Map<String, Object> getProductsStock() {
        Map<String, Object> result = new HashMap<>();

        List<SupplierProductsStock> supplierProductsStockList = supplierService.getAllProductsStock();

        if (supplierProductsStockList == null) {
            // 如果为null则可能获取失败
            result.put("status", 400);
            result.put("msg", "库存获取失败，请联系后台");
        } else {
            // 获取成功，返回账单
            result.put("status", 200);
            result.put("msg", "成功获取宠物用品库存");
            result.put("宠物用品库存", supplierProductsStockList);
        }
        return result;
    }

    /**
     * 3. 返回已完成订单
     */
    @ApiOperation(value = "获取所已完成订单", notes = "参数:无")
    @PostMapping("/supplier/getOrders/finish")
    public Map<String, Object> getOrdersFinish() {
        Map<String, Object> result = new HashMap<>();

        List<SupplierPetOrderSales> petsOrdersList = supplierService.getAllPetOrders();
        List<SupplierProductsOrderSales> productsOrdersList = supplierService.getAllProductsOrders();

        List<SupplierPetOrderSales> petsOrdersFinish = new ArrayList<>();
        List<SupplierProductsOrderSales> productsOrdersFinish = new ArrayList<>();

        if (petsOrdersList == null || productsOrdersList == null) {
            // 如果为null则可能获取失败
            result.put("status", 400);
            result.put("msg", "订单获取失败，请联系后台");
            return result;
        }

        // 将已完成订单加入结果
        for(int i = 0; i < petsOrdersList.size(); ++i){
            if(petsOrdersList.get(i).getIsDelivery().equals("1")){
                petsOrdersFinish.add(petsOrdersList.get(i));
            }
        }
        for(int i = 0; i < productsOrdersList.size(); ++i){
            if(productsOrdersList.get(i).getIsDelivery().equals("1")){
                productsOrdersFinish.add(productsOrdersList.get(i));
            }
        }

        // 根据订单时间升序排序
        Collections.sort(petsOrdersFinish, new Comparator<SupplierPetOrderSales>(){
            @Override
            public int compare(SupplierPetOrderSales s1, SupplierPetOrderSales s2){
                return s1.getOrderDate().compareTo(s2.getOrderDate());
            }
        });
        Collections.sort(productsOrdersFinish, new Comparator<SupplierProductsOrderSales>(){
            @Override
            public int compare(SupplierProductsOrderSales s1, SupplierProductsOrderSales s2){
                return s1.getOrderDate().compareTo(s2.getOrderDate());
            }
        });

        // 获取成功，返回账单
        result.put("status", 200);
        result.put("msg", "成功获取已完成订单");
        result.put("宠物订单", petsOrdersFinish);
        result.put("宠物用品订单", productsOrdersFinish);
        return result;
    }

    /**
     * 4. 返回未发货订单
     */
    @ApiOperation(value = "获取未发货订单", notes = "参数:无")
    @PostMapping("/supplier/getOrders/notDelivery")
    public Map<String, Object> getOrdersNotDelivery() {
        Map<String, Object> result = new HashMap<>();

        List<SupplierPetOrderSales> petsOrdersList = supplierService.getAllPetOrders();
        List<SupplierProductsOrderSales> productsOrdersList = supplierService.getAllProductsOrders();

        List<SupplierPetOrderSales> petsOrdersFinish = new ArrayList<>();
        List<SupplierProductsOrderSales> productsOrdersFinish = new ArrayList<>();

        if (petsOrdersList == null || productsOrdersList == null) {
            // 如果为null则可能获取失败
            result.put("status", 400);
            result.put("msg", "订单获取失败，请联系后台");
            return result;
        }

        // 将已完成订单加入结果
        for(int i = 0; i < petsOrdersList.size(); ++i){
            if(petsOrdersList.get(i).getIsDelivery().equals("0")){
                petsOrdersFinish.add(petsOrdersList.get(i));
            }
        }
        for(int i = 0; i < productsOrdersList.size(); ++i){
            if(productsOrdersList.get(i).getIsDelivery().equals("0")){
                productsOrdersFinish.add(productsOrdersList.get(i));
            }
        }

        // 根据订单时间升序排序
        Collections.sort(petsOrdersFinish, new Comparator<SupplierPetOrderSales>(){
            @Override
            public int compare(SupplierPetOrderSales s1, SupplierPetOrderSales s2){
                return s1.getOrderDate().compareTo(s2.getOrderDate());
            }
        });
        Collections.sort(productsOrdersFinish, new Comparator<SupplierProductsOrderSales>(){
            @Override
            public int compare(SupplierProductsOrderSales s1, SupplierProductsOrderSales s2){
                return s1.getOrderDate().compareTo(s2.getOrderDate());
            }
        });

        // 获取成功，返回账单
        result.put("status", 200);
        result.put("msg", "成功获取未发货订单");
        result.put("宠物订单", petsOrdersFinish);
        result.put("宠物用品订单", productsOrdersFinish);
        return result;
    }



    /**
     * 5. 宠物发货：修改宠物库存信息、供应商账单、用户帐单
     */
    @ApiOperation(value = "修改宠物订单状态", notes = "参数: 宠物订单id")
    @PostMapping("/supplier/confirmOrder/pet")
    public Map<String, Object> confirmOrderPet(@RequestBody ConfirmOrderDTO confirmOrderDTO) {
        Map<String, Object> result = new HashMap<>();

        // 获取需要修改的订单的id
        Integer orderId = confirmOrderDTO.getOrderId();

        SupplierPetOrderSales petOrderSales = supplierService.getPetOrderById(orderId);

        if (petOrderSales == null) {
            // 如果为null则可能获取失败
            result.put("status", 400);
            result.put("msg", "订单确认失败，请联系后台");
            return result;
        }


        // 订单宠物的对应ID
        Integer petId = petOrderSales.getSalesPetId();

        // 订单上宠物交易数量
        Integer orderPetNum = petOrderSales.getSalesPetQuantity();

        // 找到对应库存位置
        SupplierPetStock petStock = supplierService.getPetStockById(petId);
        // 检查库存是否还有足够容量
        if(petStock.getQuantity() >= orderPetNum){
            // 容量足够，可发货，更新状态

            // 更新库存
            petStock.setQuantity(petStock.getQuantity() - orderPetNum);
            supplierService.petStockSave(petStock);

            // 将供应商订单的”isDelivery“状态改为1，表示已发货
            petOrderSales.setIsDelivery("1");
            supplierService.petOrdersSave(petOrderSales);

            // 更新用户订单
            // 更改GoodStatus状态
            Integer userOrderId = petOrderSales.getUserOrderId();
            UserOrder userOrder = supplierService.getUserOrderById(userOrderId);
            userOrder.setOrderState(3);// 状态变为待收货
            supplierService.saveUserOrder(userOrder);

            // 获取成功，返回账单
            result.put("status", 200);
            result.put("msg", "订单确认成功，已更改配送状态");
        }
        else{
            // 容量不足，不进行更新
            result.put("status", 200);
            result.put("msg", "宠物库存不足，请等待库存补充或查看类似商品");
        }
        return result;
    }

    /**
     * 6. 宠物用品发货：修改宠物库存信息、供应商账单、用户帐单
     */
    @ApiOperation(value = "修改宠物用品订单状态", notes = "参数: 宠物用品订单id")
    @PostMapping("/supplier/confirmOrder/products")
    public Map<String, Object> confirmOrderProducts(@RequestBody ConfirmOrderDTO confirmOrderDTO) {
        Map<String, Object> result = new HashMap<>();

        // 获取需要修改的订单的id
        Integer orderId = confirmOrderDTO.getOrderId();

        SupplierProductsOrderSales productsOrderSales = supplierService.getProductsOrderById(orderId);

        if (productsOrderSales == null) {
            // 如果为null则可能获取失败
            result.put("status", 400);
            result.put("msg", "订单确认失败，请联系后台");
            return result;
        }


        // 供订单宠物用品的对应ID
        Integer productsId = productsOrderSales.getSalesProductsId();

        // 订单上宠物交易数量
        Integer orderPetNum = productsOrderSales.getSalesProductsQuantity();

        // 找到对应库存位置
        SupplierProductsStock productsStock = supplierService.findProductStockById(productsId);
        // 检查库存是否还有足够容量

        //**null
        if(productsStock == null){
            result.put("status", 400);
            result.put("msg", "致命错误，请联系后台技术人员");
            result.put("orderId", orderId);
            result.put("salesOrder", productsOrderSales);
            return result;
        }

        if(productsStock.getQuantity() >= orderPetNum){
            // 容量足够，可发货，更新状态

            // 更新库存
            productsStock.setQuantity(productsStock.getQuantity() - orderPetNum);
            supplierService.productsStockSave(productsStock);

            // 将供应商订单的”isDelivery“状态改为1，表示已发货
            productsOrderSales.setIsDelivery("1");
            supplierService.productsOrdersSave(productsOrderSales);

            // 更改GoodStatus状态
            // 更改订单状态
            // 1-5分别表示 待支付、已支付、待发货、待收货、已完成
            // 更新用户订单
            // 更改GoodStatus状态
            Integer userOrderId = productsOrderSales.getUserOrderId();
            UserOrder userOrder = supplierService.getUserOrderById(userOrderId);
            userOrder.setOrderState(3);// 状态变为待收货
            supplierService.saveUserOrder(userOrder);

            // 获取成功，返回账单
            result.put("status", 200);
            result.put("msg", "订单修改成功，已更改配送状态");
        }
        else{
            // 容量不足，不进行更新
            result.put("status", 400);
            result.put("msg", "宠物库存不足，请等待库存补充或查看类似商品");
        }
        return result;
    }

    /**
     * 7. 返回宠物所有订单
     */
    @ApiOperation(value = "获取未发货订单", notes = "参数:无")
    @PostMapping("/supplier/getOrders/AllPet")
    public Map<String, Object> getPetAllOrder() {
        Map<String, Object> result = new HashMap<>();

        List<SupplierPetOrderSales> petsOrdersList = supplierService.getAllPetOrders();

        if (petsOrdersList == null) {
            // 如果为null则可能获取失败
            result.put("status", 400);
            result.put("msg", "订单获取失败，请联系后台");
            return result;
        }

        // 根据订单时间升序排序
        Collections.sort(petsOrdersList, new Comparator<SupplierPetOrderSales>(){
            @Override
            public int compare(SupplierPetOrderSales s1, SupplierPetOrderSales s2){
                return s1.getOrderDate().compareTo(s2.getOrderDate());
            }
        });

        // 获取成功，返回账单
        result.put("status", 200);
        result.put("msg", "成功获取所有宠物订单");
        result.put("宠物订单", petsOrdersList);
        return result;
    }

    /**
     * 8. 返回宠物用品所有订单
     */
    @ApiOperation(value = "获取未发货订单", notes = "参数:无")
    @PostMapping("/supplier/getOrders/AllProducts")
    public Map<String, Object> getProductsAllOrders() {
        Map<String, Object> result = new HashMap<>();

        List<SupplierProductsOrderSales> productsOrdersList = supplierService.getAllProductsOrders();


        if (productsOrdersList == null) {
            // 如果为null则可能获取失败
            result.put("status", 400);
            result.put("msg", "订单获取失败，请联系后台");
            return result;
        }

        Collections.sort(productsOrdersList, new Comparator<SupplierProductsOrderSales>(){
            @Override
            public int compare(SupplierProductsOrderSales s1, SupplierProductsOrderSales s2){
                return s1.getOrderDate().compareTo(s2.getOrderDate());
            }
        });

        // 获取成功，返回账单
        result.put("status", 200);
        result.put("msg", "成功获取所有宠物用品订单");
        result.put("宠物用品订单", productsOrdersList);
        return result;
    }

}
