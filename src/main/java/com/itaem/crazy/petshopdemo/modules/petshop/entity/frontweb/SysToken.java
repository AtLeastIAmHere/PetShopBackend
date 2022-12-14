package com.itaem.crazy.petshopdemo.modules.petshop.entity.frontweb;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
public class SysToken implements Serializable {


    @Id
    private Integer userId;

    /**
     * token
     */
    private String token;

    /**
     * 过期时间
     */
    private LocalDateTime expireTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
