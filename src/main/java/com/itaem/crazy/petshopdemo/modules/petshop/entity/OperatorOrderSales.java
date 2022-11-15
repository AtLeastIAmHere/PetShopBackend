package com.itaem.crazy.petshopdemo.modules.petshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class OperatorOrderSales {
    @Id
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
