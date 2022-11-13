package com.itaem.crazy.shirodemo.modules.shiro.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SupplierOrderSales {
    private Integer salesOrderId;
    private Integer salesPetId;
    private Integer salesPetQuantity;
    private Double salesPetPrice;
    private Integer petshopId;
    private String petshopName;
    private String petshopPhone;
    private String petshopAddress;
    private String petshopRemarks;
    private LocalDate orderDate;
    private Double salesAllPrice;
}
