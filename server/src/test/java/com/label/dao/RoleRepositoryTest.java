package com.label.dao;

import com.label.TestBase;
import com.label.dao.user.RoleRepository;
import com.label.po.user.Role;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleRepositoryTest extends TestBase {

    @Autowired
    private RoleRepository roleRepository;


    @Test
    public void test(){
        Role role = new Role();
        role.setName("123");

        roleRepository.save(role);


    }

}