package com.label.service;

import com.label.bo.LoginUser;
import com.label.dao.user.LoginStatusRepository;
import com.label.dao.user.UserInfoRepository;
import com.label.exception.BusinessException;
import com.label.po.user.LoginStatus;
import com.label.po.user.UserInfo;
import com.label.util.CookieUtils;
import com.label.util.TimeUtils;
import com.label.util.constant.CookieConstant;
import com.label.vo.UserInfoVO;

import java.util.Date;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private LoginStatusRepository loginStatusRepository;
    @Autowired
    private CacheService cacheService;

    @Override
    public void login(HttpServletResponse httpServletResponse, UserInfo userInfo)
            throws BusinessException {
        UserInfo existUser = userInfoRepository.findByUsername(userInfo.getUsername());

        if (existUser != null) {
            String encryptPassword = DigestUtils.md5DigestAsHex(userInfo.getPassword().getBytes());
            if (existUser.getPassword().equals(encryptPassword)) {
                // 登录成功后缓存登录数据和插入数据库
                String token = UUID.randomUUID().toString().replaceAll("-", "");
                LoginUser loginUser = new LoginUser();
                loginUser.setUserId(existUser.getId());
                loginUser.setUsername(userInfo.getUsername());
                loginUser.setState(token);

                cacheService.setUserMaps(token, loginUser);

                LoginStatus loginStatus = new LoginStatus();
                loginStatus.setUserId(existUser.getId());
                loginStatus.setState(token);
                loginStatus.setExpiredTime(TimeUtils.addTime(CookieConstant.EXPIRE_TIME));
                loginStatusRepository.save(loginStatus);

                CookieUtils.set(
                        httpServletResponse, CookieConstant.TOKEN, token, CookieConstant.EXPIRE_TIME);
                return;
            }
        }

        throw new BusinessException("用户名或密码错误");
    }

    @Override
    public void register(UserInfo userInfo) throws BusinessException {
        UserInfo existUser = userInfoRepository.findByUsername(userInfo.getUsername());

        if (existUser != null) {
            throw new BusinessException("用户名已经存在");
        }
        userInfo.setPassword(DigestUtils.md5DigestAsHex(userInfo.getPassword().getBytes()));
        userInfoRepository.save(userInfo);
    }

    @Override
    public void resetPassword(UserInfoVO userInfoVO) throws BusinessException {
        UserInfo existUser = userInfoRepository.findByUsername(userInfoVO.getUsername());

        if (existUser != null) {
            String encryptPassword = DigestUtils.md5DigestAsHex(userInfoVO.getOldPassword().getBytes());
            if (existUser.getPassword().equals(encryptPassword)) {
                // 修改密码
                userInfoRepository.updatePassword(
                        existUser.getId(), DigestUtils.md5DigestAsHex(userInfoVO.getNewPassword().getBytes()));
            }
            return;
        }

        throw new BusinessException("用户名或密码错误");
    }

    @Override
    public void logout(HttpServletResponse response, LoginUser loginUser) {
        // 从内存中删除
        Map<String, LoginUser> userMaps = cacheService.getUserMaps();
        userMaps.remove(loginUser.getState());

        // 更新数据库
        loginStatusRepository.updateExpiredByState(loginUser.getState(), new Date());

        // 在返回头里返回
        CookieUtils.set(response, CookieConstant.TOKEN, null, 0);
    }
}
