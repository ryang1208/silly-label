package com.label.service;

import com.label.bo.LoginUser;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CacheServiceImpl implements CacheService {


    private Logger logger = LoggerFactory.getLogger(getClass());

    // 存入state和对应的loginUser
    private static Map<String, LoginUser> userMaps = new WeakHashMap<>();

    @Override
    public Map<String, LoginUser> getUserMaps() {
        return userMaps;
    }

    @Override
    public void setUserMaps(String cookie, LoginUser loginUser) {
        userMaps.put(cookie, loginUser);
    }

}
