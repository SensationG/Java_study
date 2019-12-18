package com.athhw.sprigboot006web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;


//处理登陆请求
@Controller
public class LoginController {

    @PostMapping(value="/login")//集成post请求
    //@RequestMapping(value="user/login",method= RequestMethod.POST)
    //@RequestParam(参数) 指定从请求参数(html传来的)获取，若html没有提交，则会报错
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String passwd,
                        Map<String,Object> map,
                        HttpSession session
                        ){
        if(!StringUtils.isEmpty(username) && "123456".equals(passwd)){
            //登陆成功
            session.setAttribute("loginsuccess",username);
            return "redirect:/main.html"; //配合拦截器
        }else{
            map.put("msg","用户名密码错误"); //使用map或mpdelandview 但这里要求返回String 所以只能用map
            return "login";
        }
    }



}
