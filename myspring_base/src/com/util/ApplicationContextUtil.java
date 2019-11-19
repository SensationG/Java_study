package com.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

final public class ApplicationContextUtil {  //��ֹ������д�����+final
	private static ApplicationContext ac=null; 
	
	private ApplicationContextUtil(){//���캯��Ϊ˽�У���ֹ���˹���
		
	}
	
	static{ //��̬�����
		ac=new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	public static ApplicationContext getApplicationContext(){
		return ac;
	}
}
