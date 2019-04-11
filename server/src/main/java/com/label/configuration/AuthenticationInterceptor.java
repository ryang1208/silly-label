package com.label.configuration;

import com.label.bo.LoginUser;
import com.label.constant.CookieConstant;
import com.label.dao.user.UserInfoRepository;
import com.label.po.user.UserInfo;
import com.label.service.CacheService;
import com.label.utils.CookieUtils;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

public class AuthenticationInterceptor implements HandlerInterceptor {

  @Autowired private UserInfoRepository userInfoRepository;
  @Autowired private CacheService cacheService;

  private final Logger logger = LoggerFactory.getLogger(getClass());

  @Override
  public boolean preHandle(
      HttpServletRequest request, HttpServletResponse response, Object handler) {
    // todo:用户登录失败的返回
    Cookie cookie = CookieUtils.get(request, CookieConstant.TOKEN);

    if (cookie == null) {
      // response.setStatus(405);
      logger.info("用户未登录");
      return false;
    }

    Map<String, Integer> cookieMaps = cacheService.getCookieMaps();
    Integer userId = cookieMaps.get(cookie.getValue());
    if (userId == null) {
      logger.info("用户信息错误");
      return false;
    }

    UserInfo userInfo = userInfoRepository.findById(userId).orElse(null);

    if (userInfo == null) {
      return false;
    }

    LoginUser loginUser = new LoginUser();
    loginUser.setUserId(userId);
    loginUser.setUsername(userInfo.getUsername());
    loginUser.setPassword(userInfo.getPassword());
    loginUser.setState(cookie.getValue());

    request.setAttribute("currentUser", loginUser);

    return true;
  }
}
