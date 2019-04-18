package com.label.service;

import com.label.bo.LoginUser;

import java.util.Map;

public interface CacheService {

    /**
     * 获得 cookie 缓存对象
     */
    Map<String, LoginUser> getUserMaps();

    /**
     * 设置 cookie
     */
    void setUserMaps(String cookie, LoginUser loginUser);
}
