package com.athhw.springboot003config.config;

import com.athhw.springboot003config.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
    @Configuration 指明当前类是一个配置类，就是用来代替之前spring的配置文件
        在配置文件中使用@Bean的方式来添加组件
 */
@Configuration
public class MyAppConfig {

    //将方法的返回值添加到容器中，容器中这个bean的id就是方法名
    @Bean
    public HelloService helloService(){
        return new HelloService();
    }
}
