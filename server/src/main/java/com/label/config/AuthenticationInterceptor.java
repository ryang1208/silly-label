package com.label.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private UserInfoRepository userInfoRepository;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){

        System.out.println("进入拦截器");
        //todo:修改成正常的业务逻辑
       UserInfo userInfo =  userInfoRepository.findById(2).orElse(null);

       request.setAttribute("currentUser",userInfo);

        return true;
    }
}
