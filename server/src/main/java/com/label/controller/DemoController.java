package com.label.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {


    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
          return "hello world";
    }
}
