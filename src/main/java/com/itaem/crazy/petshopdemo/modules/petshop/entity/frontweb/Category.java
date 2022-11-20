package com.itaem.crazy.petshopdemo.modules.petshop.entity.frontweb;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;


@Getter
@Setter
@Entity
public class Category {
    @Id
    private Integer id;
    private String name;
    private String picture;
}
