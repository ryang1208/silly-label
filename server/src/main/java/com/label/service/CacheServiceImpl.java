package com.label.service;

import com.google.common.collect.Lists;
import com.label.bo.LoginUser;
import com.label.dao.user.LoginStatusRepository;
import com.label.dao.user.UserInfoRepository;
import com.label.po.user.LoginStatus;
import com.label.po.user.UserInfo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CacheServiceImpl implements CacheService {

    @Autowired
    private LoginStatusRepository loginStatusRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;

    private Logger logger = LoggerFactory.getLogger(getClass());

    // 存入state和对应的loginUser
    private static Map<String, LoginUser> cookieMaps = new HashMap<>();

    @PostConstruct
    public void init() {
        logger.info("初始化cookie信息");
        initCookie();
        logger.info("初始化cookie信息结束");
    }

    @Override
    public Map<String, LoginUser> getCookieMaps() {
        return cookieMaps;
    }

    @Override
    public void setCookieMaps(String cookie, LoginUser loginUser) {
        cookieMaps.put(cookie, loginUser);
    }

    private void initCookie() {
        List<LoginStatus> loginStatuses = loginStatusRepository.findByExpiredTimeAfter(new Date());

        List<Integer> userIds =
                loginStatuses.stream().map(LoginStatus::getUserId).collect(Collectors.toList());
        List<UserInfo> userInfos = Lists.newArrayList();

        userInfoRepository
                .findAllById(userIds)
                .forEach(
                        userInfo -> {
                            userInfos.add(userInfo);
                        });

        loginStatuses.forEach(
                loginStatus -> {
                    LoginUser loginUser = new LoginUser();
                    loginUser.setUserId(loginStatus.getUserId());
                    loginUser.setState(loginStatus.getState());
                    UserInfo userInfo =
                            userInfos
                                    .stream()
                                    .filter(existUser -> loginStatus.getUserId().equals(existUser.getId()))
                                    .findAny()
                                    .orElse(null);
                    if (userInfo != null) {
                        loginUser.setUsername(userInfo.getUsername());
                    }

                    cookieMaps.put(loginStatus.getState(), loginUser);
                });
    }
}
