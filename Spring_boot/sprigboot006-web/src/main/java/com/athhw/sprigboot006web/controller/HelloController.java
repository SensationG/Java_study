package com.athhw.sprigboot006web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }

    //Thymeleaf测试
    @RequestMapping("/success")
    public String success(){
        //找到类路径下的
        // classpath:/templates/success.html
        return "success";//网页名
    }

    //Thymeleaf 传值测试
    @RequestMapping("/success1")
    public String success1(Map<String,Object> map){
        map.put("hello2","你好");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "success1";//网页名
    }
}
