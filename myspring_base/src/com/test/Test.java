package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.BybService;
import com.service.UserService;
import com.util.ApplicationContextUtil;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//------原方法
//		UserService  userservice = new UserService();
//		userservice.setName("hhw");
//		userservice.sayhello();
		
		//------Spring架构
		//1.得到spring的applicationContext对象2.把new对象交给容器xml接管
		//ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		//UserService us=(UserService)ac.getBean("userService");//为beanid
		//us.sayhello();
		
		//------通过ApplicationContextUtil加载 无需写上面的加载
		((UserService)ApplicationContextUtil.getApplicationContext()
		.getBean("userService")).sayhello();
		
//		BybService bybService=(BybService) ac.getBean("bybService");
//		bybService.sayBye();
	}

}
