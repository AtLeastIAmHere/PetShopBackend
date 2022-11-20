package com.itaem.crazy.petshopdemo.modules.petshop.controller;

import com.itaem.crazy.petshopdemo.modules.petshop.config.LogManager;
import com.itaem.crazy.petshopdemo.modules.petshop.dto.CreateOrderDTO;
import com.itaem.crazy.petshopdemo.modules.petshop.dto.GetOrderDTO;
import com.itaem.crazy.petshopdemo.modules.petshop.dto.ChangeOrderDTO;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.*;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.frontweb.Good;
import com.itaem.crazy.petshopdemo.modules.petshop.service.OperatorService;
import com.itaem.crazy.petshopdemo.modules.petshop.service.ShiroService;
import com.itaem.crazy.petshopdemo.modules.petshop.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.scene.control.TextFormatter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "用户操作界面")
@RestController
public class UserController {
    private final UserService userService;
    private final ShiroService shiroService;
    private final OperatorService operatorService;

    UserController(UserService userService, ShiroService shiroService, OperatorService operatorService){
        this.userService = userService;
        this.shiroService = shiroService;
        this.operatorService = operatorService;
    }

    /**
     * 1. 用户下单：获取订单，生成订单，更新订单
     * 2. 用户获取订单：根据输入状态返回对应的订单
     * 3. 用户确认订单
     * 4. 用户取消订单
     *
     * 待测试
     */

    /**
     * 1. 用户下单
     */
    @ApiOperation(value = "用户下单", notes = "参数：createOrderDTO")
    @PostMapping("/front/member/createOrder")
    public Map<String, Object> createOrder(@RequestBody List<CreateOrderDTO> createOrderDTOList){
//        LogManager.GetInstance().logger.info(createOrderDTOList.toString());

        Map<String, Object> result = new HashMap<>();


        UserOrder userOrder = new UserOrder();
        String token = createOrderDTOList.get(0).getToken();
        Integer userId = shiroService.findByToken(token).getUserId();
        userOrder.setUserId(userId);
        userOrder.setOrderState(2);
        userOrder.setCreateTime(LocalDateTime.now());
        userOrder.setPostFee(15.0);

        // 计算payMoney
        Double payMoney = 0.0;

        userService.saveUserOrder(userOrder);


        for(int i = 0; i < createOrderDTOList.size(); ++i){
            CreateOrderDTO item = createOrderDTOList.get(i);

            UserOrderGoods userOrderGoods = new UserOrderGoods();
            userOrderGoods.setUserOrderId(userOrder.getUserOrderId());
            userOrderGoods.setGoodId(item.getId());
            userOrderGoods.setCount(item.getCount());
            userOrderGoods.setPrice(item.getNowPrice());

            userService.saveUserOrderGoods(userOrderGoods);

            payMoney += item.getCount() * Double.parseDouble(item.getPrice());

            /**
             *     private Integer userOrderId;
             *     private Integer userId;
             *     private Integer orderState;
             *     private LocalDateTime createTime;
             *     private Double payMoney;
             *     private Double postFee;
             */

            // 根据GoodId判断时pet还是products，1-狗，2-猫，3-其他小动物，4-宠物用品
            Good good  = userService.getGoodById(item.getId());
            if(good.getCategoryId() <= 3){
                OperatorPetOrderSales sales = new OperatorPetOrderSales();
                sales.setSalesPetId(item.getId());
                sales.setSalesPetQuantity(item.getCount());
                sales.setSalesPetPrice(Double.parseDouble(item.getNowPrice()));
                sales.setUserId(userId);
                sales.setUserOrderId(userOrder.getUserOrderId());
                User user = userService.getUserById(userId);
                sales.setUserName(user.getUsername());
                sales.setUserPhone(user.getPhone());
                sales.setUserAddress(user.getAddress());
                sales.setUserRemarks("不错哦");
                sales.setOrderDate(LocalDateTime.now());
                sales.setSalesAllPrice(sales.getSalesPetPrice() * sales.getSalesPetQuantity());
                sales.setIsConfirm("0");
                operatorService.petOrderSalesSave(sales);
            }
            else{
                // products
                OperatorProductsOrderSales sales = new OperatorProductsOrderSales();
                sales.setSalesProductsId(item.getId());
                sales.setSalesProductsQuantity(item.getCount());
                sales.setSalesProductsPrice(Double.parseDouble(item.getNowPrice()));
                sales.setUserId(userId);
                sales.setUserOrderId(userOrder.getUserOrderId());
                User user = userService.getUserById(userId);
                sales.setUserName(user.getUsername());
                sales.setUserPhone(user.getPhone());
                sales.setUserAddress(user.getAddress());
                sales.setUserRemarks("不错哦");
                sales.setOrderDate(LocalDateTime.now());
                sales.setSalesAllPrice(sales.getSalesProductsPrice() * sales.getSalesProductsQuantity());
                sales.setIsConfirm("0");
                operatorService.productsOrderSalesSave(sales);
            }
        }

        userOrder.setUserOrderId(userOrder.getUserOrderId());
        userOrder.setPayMoney(payMoney);
        // 更新账单总价后，保存账单
        userService.saveUserOrder(userOrder);

        /**
         * 管理员增加未处理订单
         */


        result.put("code", 200);
        result.put("msg", "下单成功");
        return result;
    }

    /**
     * 2. 获取不同状态的订单
     * 根据用户的token获取对应的订单，然后获取对应状态的订单
     */
    @ApiOperation(value = "获取不同状态的订单", notes = "参数: getOrderDTO")
    @PostMapping("/front/member/order")
    public Map<String, Object> getOrder(@RequestBody GetOrderDTO getOrderDTO){
        Map<String, Object> result = new HashMap<>();

        // 获取用户的token
        String token = getOrderDTO.getToken();

        // 获取需要查询的订单状态
        Integer state = getOrderDTO.getOrderState();

        // 获取用户的id
        Integer userId = shiroService.findByToken(token).getUserId();

        // 获取用户对应状态的订单
        // 如果订单状态是0，则返回该用户的所有订单，否则根据订单状态返回
        List<UserOrder> userOrderList;
        if(state == 0){
            userOrderList = userService.findUserOrderByUserId(userId);
        }
        else{
            userOrderList = userService.findUserOrderByUserIdAndState(userId, state);
        }

        // 将订单处理成结果格式
        List<Map<String, Object>> itemsList = new ArrayList<>();
        for(int i = 0; i < userOrderList.size(); ++i){
            Map<String, Object> items = new HashMap<>();
            UserOrder order = userOrderList.get(i);
            items.put("id", order.getUserOrderId());
            items.put("createTime", order.getCreateTime().toString());
            items.put("orderState", order.getOrderState());

            // add goods
            List<Map<String, Object>> goodList = new ArrayList<>();
            if(order == null){
                LogManager.GetInstance().logger.info("status = 1");
                result.put("code", 400);
                result.put("msg", "致命错误，请联系后台人员");
                return result;
            }
            List<UserOrderGoods> userOrderGoodsList = userService.getAllOrderGoods(order.getUserOrderId());
            for(int j = 0; j < userOrderGoodsList.size(); ++j){
                Map<String, Object> goodInfo = new HashMap<>();

                Integer goodId = userOrderGoodsList.get(j).getGoodId();
                Good good = userService.getGoodById(goodId);
                goodInfo.put("image", good.getPicture());
                goodInfo.put("name", good.getName());
                goodInfo.put("attrsText", "111");
                goodInfo.put("curPrice", userOrderGoodsList.get(j).getPrice());
                goodInfo.put("quantity", userOrderGoodsList.get(j).getCount());

                goodList.add(goodInfo);
            }
            items.put("good", goodList);

            items.put("payMoney", order.getPayMoney().toString());
            items.put("postFee", order.getPostFee().toString());

            itemsList.add(items);
        }

        result.put("items", itemsList);

        result.put("code", 200);
        result.put("msg", "订单获取成功");
        return result;
    }


    /**
     * 3. 用户确认收货
     */
    @ApiOperation(value = "用户确认收货", notes = "参数：订单号，用户token")
    @PostMapping("/front/member/confirmOrder")
    public Map<String, Object> confirmOrder(@RequestBody ChangeOrderDTO changeOrderDTO){
        Map<String, Object> result = new HashMap<>();

        Integer userOrderId = changeOrderDTO.getUserOrderId();
        String token = changeOrderDTO.getToken();
        User user = operatorService.findUserByToken(token);
        UserOrder userOrder = operatorService.findUserOrderById(userOrderId);
        userOrder.setOrderState(4);

        result.put("code", 200);
        result.put("msg", "成功确认收货");
        return result;
    }

    /**
     * 4. 用户取消订单
     */
    @ApiOperation(value = "用户取消订单", notes = "参数：订单id，用户token")
    @PostMapping("/front/member/concelOrder")
    public Map<String, Object> conelOrder(@RequestBody ChangeOrderDTO changeOrderDTO){
        Map<String, Object> result = new HashMap<>();

        Integer userOrderId = changeOrderDTO.getUserOrderId();
        String token = changeOrderDTO.getToken();
        User user = operatorService.findUserByToken(token);
        UserOrder userOrder = operatorService.findUserOrderById(userOrderId);
        userOrder.setOrderState(5);

        List<OperatorPetOrderSales> petOrderSalesList = operatorService.getAllPetSalesByUserOrderId(userOrderId);
        List<OperatorProductsOrderSales> productsOrderSalesList = operatorService.getAllProductssalesByUserOrderId(userOrderId);

        //将商家订单的 ”isConfirm“ 属性设置为-1，表示订单已取消
        for(int i = 0; i < petOrderSalesList.size(); ++i){
            petOrderSalesList.get(i).setIsConfirm("-1");
            operatorService.petOrderSalesSave(petOrderSalesList.get(i));
        }
        for(int i = 0; i < productsOrderSalesList.size(); ++i){
            productsOrderSalesList.get(i).setIsConfirm("-1");
            operatorService.productsOrderSalesSave(productsOrderSalesList.get(i));
        }

        result.put("code", 200);
        result.put("msg", "已成功取消该订单");
        return result;
    }


}
