package com.itaem.crazy.shirodemo.modules.shiro.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class OperatorPet {
    private Integer petId;
    private String petName;
    private String specie;
    private String color;
    private LocalDate birthday;
    private Integer age;
    private Double weight;
    private String health;
    private String remarks;
    private Double price;
}
