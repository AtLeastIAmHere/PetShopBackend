package com.itaem.crazy.petshopdemo.modules.petshop.dto.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserDTO {
    @NotBlank(message = "用户名不能为空")
    private String account;
    @NotBlank(message = "token不能为空")
    private String token;

    private String nickname;

    private String mail;

    private String creditCard;

    private String mobile;

    private String address;

}
