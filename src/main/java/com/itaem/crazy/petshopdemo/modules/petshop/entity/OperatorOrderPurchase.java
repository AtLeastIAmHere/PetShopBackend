package com.itaem.crazy.petshopdemo.modules.petshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class OperatorOrderPurchase {
    @Id
    private Integer purchaseOrderId;
    private Integer petId;
    private Integer petQuantity;
    private Double purchasePetPrice;
    private Double purchaseAllPrice;
    private LocalDateTime datetime;
    private String supplierId;
    private String supplierPhone;
    private String supplierCompany;
    private String supplierAddress;
}
