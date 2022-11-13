package com.itaem.crazy.shirodemo.modules.shiro.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OperatorOrderSales {
    private Integer salesOrderId;
    private Integer salesPetId;
    private Integer salesPetQuantity;
    private Double salesPetPrice;
    private Double salesAllPrice;
    private Integer userId;
    private String userName;
    private String userPhone;
    private String userAddress;
    private String userRemarks;
    private LocalDateTime orderDate;

}
