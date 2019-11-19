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
		//------ԭ����
//		UserService  userservice = new UserService();
//		userservice.setName("hhw");
//		userservice.sayhello();
		
		//------Spring�ܹ�
		//1.�õ�spring��applicationContext����2.��new���󽻸�����xml�ӹ�
		//ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		//UserService us=(UserService)ac.getBean("userService");//Ϊbeanid
		//us.sayhello();
		
		//------ͨ��ApplicationContextUtil���� ����д����ļ���
		((UserService)ApplicationContextUtil.getApplicationContext()
		.getBean("userService")).sayhello();
		
//		BybService bybService=(BybService) ac.getBean("bybService");
//		bybService.sayBye();
	}

}
