package com.itaem.crazy.petshopdemo.modules.petshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class SupplierOrderSales {
    @Id
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
