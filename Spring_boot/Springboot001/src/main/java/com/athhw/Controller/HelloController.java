package com.athhw.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/*
    标注它是一个Controller
 */
@Controller
public class HelloController {

    @ResponseBody//  返回的数据不是html标签的页面，而是其他某种格式的数据时（如json、xml等）使用 也可以标注在类名上
    @RequestMapping("/hello") //处理一个hello请求
    public String hello(){
        return "Hello World Spring"; //返回字符串
    }
}
