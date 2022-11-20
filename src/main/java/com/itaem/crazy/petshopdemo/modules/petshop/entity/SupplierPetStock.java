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
public class SupplierPetStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
