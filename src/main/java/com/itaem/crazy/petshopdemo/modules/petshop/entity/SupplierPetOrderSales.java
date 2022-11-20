package com.itaem.crazy.petshopdemo.modules.petshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class SupplierPetOrderSales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer salesOrderId;
    private Integer salesPetId;
    private Integer salesPetQuantity;
    private Double salesPetPrice;
    private Integer petshopId;
    private String petshopName;
    private String petshopPhone;
    private String petshopAddress;
    private String petshopRemarks;
    private Integer userId;
    private Integer userOrderId;
    private String userName;
    private String userPhone;
    private String userAddress;
    private String userRemarks;
    private LocalDateTime orderDate;
    private Double salesAllPrice;
    private String isDelivery;
}
