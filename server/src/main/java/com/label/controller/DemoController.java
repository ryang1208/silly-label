package com.label.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@Api(value = "示例Controller")
public class DemoController {


    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ApiOperation(value = "hello方法",response = String.class)
    public String hello(){
          return "hello world";
    }
}
