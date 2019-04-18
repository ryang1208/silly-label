package com.label.service;

import com.label.bo.LoginUser;
import java.util.Map;

public interface CacheService {

  /** 获得 cookie 缓存对象 */
  public Map<String, LoginUser> getCookieMaps();

  /** 设置 cookie */
  void setCookieMaps(String cookie, LoginUser loginUser);
}
