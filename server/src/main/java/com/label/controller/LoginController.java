package com.label.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LoginController {


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public void login(){
        System.out.println("login");
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public void logout(){
        System.out.println("logout");
    }

}
