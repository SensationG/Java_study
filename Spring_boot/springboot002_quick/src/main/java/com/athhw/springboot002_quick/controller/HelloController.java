package com.athhw.springboot002_quick.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*
    @RestController 相当于 @Controller+ @ResponseBody 组合效果
    表示该类下的所有方法都是直接向浏览器返回一个数据
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello Quick Start Spring Boot";
    }
}

