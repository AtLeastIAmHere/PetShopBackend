package com.itaem.crazy.petshopdemo.modules.petshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Operator {
    @Id
    private Integer operatorId;
    private String operatorName;
    private String account;
    private String password;
    private String phone;
    private String level;
    private String bankAccount;
}
