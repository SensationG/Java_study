package com.athhw.sprigboot006web.config;
import com.athhw.sprigboot006web.clanguage.MylocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//使用WebMvcConfigurationSupport来扩展springmvc功能
@Configuration //步骤1 使用@Configuration注解 2 继承WebMvcConfigurationSupport
public class MyMvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {

        //将默认主页定向到模板引擎解析的templates下的login.html
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
    }

    //使用自定义区域解析器
    @Bean
    public LocaleResolver localeResolver(){
        return new MylocaleResolver();
    }
}
