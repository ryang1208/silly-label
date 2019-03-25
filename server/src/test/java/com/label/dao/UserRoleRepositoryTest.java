package com.label.dao;

import com.label.TestBase;
import com.label.dao.user.UserRoleRepository;
import com.label.po.user.UserRole;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRoleRepositoryTest  extends TestBase {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Test
    public void test(){
        UserRole userRole = new UserRole();

        userRole.setUserId(1);
        userRole.setRoleId(1);

        userRoleRepository.save(userRole);
    }

}