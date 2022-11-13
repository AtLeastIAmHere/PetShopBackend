package com.itaem.crazy.shirodemo.modules.shiro.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserOrder {
    private Integer orderId;
    private String userName;
    private Integer userId;
    private Integer petId;
    private Double petPrice;
    private Integer petQuantity;
    private String userPhone;
    private String userAddress;
    private LocalDateTime orderTime;
    private String remarks;
    private String expressCarrier;
    private String curierNumber;
    private LocalDateTime deliverTime;
    private String evaluation;
    private Double orderPrice;
}
