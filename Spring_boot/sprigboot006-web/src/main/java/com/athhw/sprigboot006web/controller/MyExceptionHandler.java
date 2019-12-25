package com.athhw.sprigboot006web.controller;

/*
    自定义异常处理器
    spingmvc可以返回默认的json报错数据，但需要自定义返回的json内容 需要以下：
    响应自定义的json数据 用于返回客户端异常
 */

import com.athhw.sprigboot006web.exception.UserNotExitException;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    //只要出现异常，就会调用这个方法获取异常 返回json数据

    //使用@ResponseBody注解，方便的返回json数据
    //第一种 浏览器客户端返回都是json
//    @ResponseBody
//    @ExceptionHandler(UserNotExitException.class)
//    public Map<String,Object> HandlerException(Exception e){
//        //自定义json数据
//        Map<String,Object> map = new HashMap<>();
//        map.put("code","user.notexist");
//        map.put("message",e.getMessage());
//        return map;
//    }

    //第二种 自适应浏览器/客户端

    @ExceptionHandler(UserNotExitException.class)
    public String HandlerException(Exception e, HttpServletRequest request){
        //自定义json数据
        Map<String,Object> map = new HashMap<>();
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        //传入我们自己的错误状态码 4xx 5xx 返回到error
        // error会获取这里设置的状态码 再转到我们自定义的错误页面
        request.setAttribute("javax.servlet.error.status_code",500);
        return "forward:/error";
    }
}
