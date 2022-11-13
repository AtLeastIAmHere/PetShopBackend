package com.itaem.crazy.shirodemo.modules.shiro.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class SupplierStock {
    private Integer stockPetId;
    private String specie;
    private Double price;
    private String color;
    private Integer age;
    private Double weight;
    private String health;
    private LocalDate birthday;
    private Integer quantity;
    private String source;
    private LocalDateTime purchaseDate;
    private String remarks;
}
