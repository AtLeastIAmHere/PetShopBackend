package com.itaem.crazy.shirodemo.modules.shiro.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Set;

@Getter
@Setter
public class User {
    private Integer userId;
    private String username;
    private String account;
    private String password;
    private String phone;
    private String creditCard;
    private String eMail;
    private String address;
    private String selfIntroduction;
}
