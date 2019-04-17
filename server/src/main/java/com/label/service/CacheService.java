package com.label.service;

import java.util.Map;

public interface CacheService {

    /**
     * 获得 cookie 缓存对象
     */
    public Map<String, Integer> getCookieMaps();

    /**
     * 设置 cookie
     */
    void setCookieMaps(String cookie, Integer userId);
}
