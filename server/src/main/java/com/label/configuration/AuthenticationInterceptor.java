package com.label.configuration;

import com.label.bo.LoginUser;
import com.label.dao.user.LoginStatusRepository;
import com.label.dao.user.UserInfoRepository;
import com.label.po.user.LoginStatus;
import com.label.po.user.UserInfo;
import com.label.service.CacheService;
import com.label.util.CookieUtils;
import com.label.util.constant.CookieConstant;
import com.label.util.constant.HttpCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private CacheService cacheService;
    @Autowired
    private LoginStatusRepository loginStatusRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        Cookie cookie = CookieUtils.get(request, CookieConstant.TOKEN);

        if (cookie == null) {
            response.setStatus(HttpCode.StatusUserNotLogin);
            logger.info("用户未登录");
            return false;
        }

        LoginUser loginUser = cacheService.getUserMaps().get(cookie.getValue());
        if (loginUser == null) {
            // 如果缓存没有则从数据库里面查询
            LoginStatus loginStatus = loginStatusRepository.findByStateAndExpiredTimeAfter(cookie.getValue(), new Date());
            if (loginStatus == null) {
                response.setStatus(HttpCode.StatusUserNotLogin);
                return false;
            } else {
                loginUser = new LoginUser();
                UserInfo userInfo = userInfoRepository.findById(loginStatus.getUserId()).orElse(null);
                loginUser.setUserId(loginStatus.getUserId());
                loginUser.setState(loginStatus.getState());
                if (userInfo != null) {
                    loginUser.setUsername(userInfo.getUsername());
                }
            }
        }

        request.setAttribute("loginUser", loginUser);

        return true;
    }
}
