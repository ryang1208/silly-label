package com.label.service;

import com.label.dao.user.LoginStatusRepository;
import com.label.po.user.LoginStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CacheServiceImpl implements CacheService{

    @Autowired
    private LoginStatusRepository loginStatusRepository;

    private Logger logger = LoggerFactory.getLogger(getClass());


    private static Map<String,Integer> cookieMaps = new HashMap<>();


    @PostConstruct
    public void init(){
        logger.info("初始化cookie信息");
        initCookie();
        logger.info("初始化cookie信息结束");
    }

    @Override
    public Map<String,Integer> getCookieMaps(){
        return cookieMaps;
    }
    @Override
    public void setCookieMaps(String cookie,Integer userId){
        cookieMaps.put(cookie,userId);
    }



    private void  initCookie(){
        List<LoginStatus> loginStatuses = loginStatusRepository.findByExpiredTimeAfter(new Date());
        loginStatuses.forEach(loginStatus -> {
            cookieMaps.put(loginStatus.getState(),loginStatus.getUserId());
        });
    }


}
