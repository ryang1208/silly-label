package com.label.service;

import java.util.Map;

public interface CacheService {

    /**
     * 获得cookie缓存对象
     * @return
     */
    public Map<String,Integer> getCookieMaps();

    /**
     * 设置cookie
     * @param cookie
     * @param userId
     */
    void setCookieMaps(String cookie,Integer userId);
}
