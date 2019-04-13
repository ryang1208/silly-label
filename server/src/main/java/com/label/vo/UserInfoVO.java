package com.label.vo;

import lombok.Data;

@Data
public class UserInfoVO {
    /**
     * 用户名
     */
    private String username;
    /**
     * 旧密码
     */
    private String oldPassword;
    /**
     * 新密码
     */
    private String newPassword;
}
