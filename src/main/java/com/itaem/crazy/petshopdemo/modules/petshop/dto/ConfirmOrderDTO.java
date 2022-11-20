package com.itaem.crazy.petshopdemo.modules.petshop.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ConfirmOrderDTO {
    @NotBlank(message = "orderId不能为空")
    private Integer orderId;
}
