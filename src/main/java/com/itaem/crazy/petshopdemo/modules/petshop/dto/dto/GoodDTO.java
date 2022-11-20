package com.itaem.crazy.petshopdemo.modules.petshop.dto.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class GoodDTO {
    private String categoryId;
    private Integer page;
    private Integer pageSize;

}
