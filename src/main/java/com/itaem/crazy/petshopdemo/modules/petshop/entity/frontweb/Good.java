package com.itaem.crazy.petshopdemo.modules.petshop.entity.frontweb;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Getter
@Setter
@Entity
public class Good {
    @Id
    private Integer id;
    private String name;
    @Column(name = "_desc")
    private String desc;
    private String price;
    private String picture;
    private String discount;
    private String orderNum;
    private int categoryId;
}
