package com.label.controller;

import com.label.annoation.CurrentUser;
import com.label.po.user.UserInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {


    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(@CurrentUser UserInfo userInfo){

        return userInfo.getUsername();
    }
}
