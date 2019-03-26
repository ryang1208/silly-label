package com.label.controller;

import com.label.exception.BusinessException;
import com.label.po.user.UserInfo;
import com.label.service.CacheService;
import com.label.service.UserService;
import com.label.utils.WebUtils;
import com.label.vo.ResultVO;
import com.label.vo.UserInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@Api(value="用户相关接口")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录接口",response = String.class)
    public ResultVO login(HttpServletResponse httpServletResponse, @RequestBody UserInfo userInfo){
            try {
                userService.login(httpServletResponse, userInfo);
                return WebUtils.success();
            }
            catch (BusinessException e){
                return WebUtils.error(201,e.getMessage());
            }
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ApiOperation(value = "注册接口",response = String.class)
    public ResultVO register(@RequestBody UserInfo userInfo){
        try {
            userService.register(userInfo);
            return WebUtils.success();
        }catch (BusinessException e){
            return WebUtils.error(201,e.getMessage());
        }
    }


    @RequestMapping(value = "/reset",method = RequestMethod.POST)
    public ResultVO reset(@RequestBody UserInfoVO userInfoVO){

        return null;
    }





}
