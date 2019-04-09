package com.label.bo;

import lombok.Data;

@Data
public class LoginUser {

  /** 用户id */
  private Integer userId;
  /** 用户名 */
  private String username;
  /** 密码 */
  private String password;
  /** state信息 */
  private String state;
}
