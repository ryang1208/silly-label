package com.label.service;

import com.label.exception.BusinessException;
import com.label.po.user.UserInfo;
import com.label.vo.UserInfoVO;

import javax.servlet.http.HttpServletResponse;

public interface UserService {

    /**
     * 登录接口
     * @param userInfo
     */
    public void login(HttpServletResponse httpServletResponse,UserInfo userInfo)  throws BusinessException;

    /**
     * 注册接口
     * @param userInfo
     */
    public void register(UserInfo userInfo) throws BusinessException;

    public void resetPassword(UserInfoVO userInfoVO) throws BusinessException;
}
