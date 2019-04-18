package com.label.po.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class LoginStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 存储cookie信息
     */
    private String state;
    /**
     * 登录失效时间
     */
    private Date expiredTime;

}
