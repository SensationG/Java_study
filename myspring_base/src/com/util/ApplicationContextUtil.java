package com.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

final public class ApplicationContextUtil {  //防止别人外写这个类+final
	private static ApplicationContext ac=null; 
	
	private ApplicationContextUtil(){//构造函数为私有，防止别人构建
		
	}
	
	static{ //静态块加载
		ac=new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	public static ApplicationContext getApplicationContext(){
		return ac;
	}
}
