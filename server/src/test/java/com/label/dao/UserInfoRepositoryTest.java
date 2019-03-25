package com.label.dao;

import com.label.TestBase;
import com.label.dao.user.UserInfoRepository;
import com.label.po.user.UserInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;

public class UserInfoRepositoryTest  extends TestBase {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Test
    public void test(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("123");
        userInfo.setPassword("456");
        userInfoRepository.save(userInfo);
    }

    @Test
    public void update(){
        userInfoRepository.updatePassword(2, DigestUtils.md5DigestAsHex("123".getBytes()));
    }

    @Test
    public void testEncrapy(){
        System.out.println( DigestUtils.md5DigestAsHex("123".getBytes()));
    }

}