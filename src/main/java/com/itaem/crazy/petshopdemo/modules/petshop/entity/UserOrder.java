package com.itaem.crazy.petshopdemo.modules.petshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class UserOrder {
    @Id
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
