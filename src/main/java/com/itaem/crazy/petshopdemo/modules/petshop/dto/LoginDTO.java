package com.itaem.crazy.petshopdemo.modules.petshop.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 登录传输类
 */
@Data
public class LoginDTO {
    @NotBlank(message = "账号不能为空")
    private String account;
    @NotBlank(message = "密码不能为空")
    private String password;
    @NotBlank(message = "账户类型不能为空")
    private String type;
}
