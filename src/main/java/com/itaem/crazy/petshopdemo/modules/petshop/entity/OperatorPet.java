package com.itaem.crazy.petshopdemo.modules.petshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class OperatorPet {
    @Id
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
