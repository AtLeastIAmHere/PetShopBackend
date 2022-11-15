package com.itaem.crazy.petshopdemo.modules.petshop.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 注册传输类
 */
@Data
public class RegisterDTO {
    @NotBlank(message = "账号不能为空")
    private String account;
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;

}
