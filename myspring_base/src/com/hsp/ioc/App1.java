package com.hsp.ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class App1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//当我们去实例化beans.xml，该文件中配置的bean被实例化（该bean scope是singleton）
		//大部分情况下用此方法实例化bean
		//ApplicationContext ac = new ClassPathXmlApplicationContext("com/hsp/ioc/beans.xml");
		
		//通过文件路径来获取  需要获得文件的绝对路径
		ApplicationContext ac = new FileSystemXmlApplicationContext("C:\\Users\\hhw\\Desktop\\work\\代码\\myspring\\src\\com\\hsp\\ioc\\beans.xml");
		
		Student s1=(Student)ac.getBean("student");
		Student s2=(Student)ac.getBean("student");
		System.out.println(s1+" "+s2);
		//从beanfactory获取bean，只是实例化该容器，那么容器的bean不会被实例化
		//只有当你去getBean时，才会实时创建
		//少部分情况下用此方法
		//BeanFactory factory = new XmlBeanFactory(
		//		new ClassPathResource("com/hsp/ioc/beans.xml"));
		//factory.getBean("student");
	}

}
