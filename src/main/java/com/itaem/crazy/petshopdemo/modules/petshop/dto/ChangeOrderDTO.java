package com.itaem.crazy.petshopdemo.modules.petshop.dto;

import lombok.Data;

@Data
public class ChangeOrderDTO {
    private Integer userOrderId;
    private String token;
}
