package com.itaem.crazy.shirodemo.modules.shiro.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Operator {
    private Integer operatorId;
    private String operatorName;
    private String account;
    private String password;
    private String phone;
    private String level;
    private String bankAccount;
}
