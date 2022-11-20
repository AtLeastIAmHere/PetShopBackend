package com.itaem.crazy.petshopdemo.modules.petshop.dto;

import lombok.Data;

@Data
public class GetOrderDTO {
    private Integer orderState;
    private Integer page;
    private Integer pageSize;
    private String token;
}
