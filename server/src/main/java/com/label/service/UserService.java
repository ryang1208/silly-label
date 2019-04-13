package com.label.service;

import com.label.bo.LoginUser;
import com.label.exception.BusinessException;
import com.label.po.user.UserInfo;
import com.label.vo.UserInfoVO;

import javax.servlet.http.HttpServletResponse;

public interface UserService {
    /**
     * 登录接口
     *
     * @param userInfo
     */
    public void login(HttpServletResponse httpServletResponse, UserInfo userInfo) throws BusinessException;

    /**
     * 注册接口
     *
     * @param userInfo
     */
    public void register(UserInfo userInfo) throws BusinessException;

    /**
     * 重置密码
     *
     * @param userInfoVO
     * @throws BusinessException
     */
    public void resetPassword(UserInfoVO userInfoVO) throws BusinessException;

    /**
     * 登出功能
     *
     * @param response
     */
    public void logout(HttpServletResponse response, LoginUser loginUser);
}
