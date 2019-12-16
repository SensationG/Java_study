package com.athhw.sprigboot006web.clanguage;


import org.springframework.lang.Nullable;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

//区域信息解析器 接口LocaleResolver 根据url切换地区
public class MylocaleResolver implements LocaleResolver {

    //解析区域信息
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String l= httpServletRequest.getParameter("l"); //解析url中的参数带的值
        Locale locale = Locale.getDefault(); //设定默认值
        if(!StringUtils.isEmpty(l)){ //检测l是否为空
            String[] split=l.split("_"); //以下划线切割l
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, @Nullable HttpServletResponse httpServletResponse, @Nullable Locale locale) {

    }
}
