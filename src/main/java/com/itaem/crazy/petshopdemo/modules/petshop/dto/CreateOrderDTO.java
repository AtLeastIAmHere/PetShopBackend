package com.itaem.crazy.petshopdemo.modules.petshop.dto;

import io.swagger.models.auth.In;
import lombok.Data;

@Data
public class CreateOrderDTO {
    private Integer count;
    private Integer id;
    private boolean isEffective;
    private String name;
    private String nowPrice;
    private String pricture;
    private String price;
    private boolean selected;
    private Integer stock;
    private String token;
}
