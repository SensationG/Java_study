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
		//������ȥʵ����beans.xml�����ļ������õ�bean��ʵ��������bean scope��singleton��
		//�󲿷�������ô˷���ʵ����bean
		//ApplicationContext ac = new ClassPathXmlApplicationContext("com/hsp/ioc/beans.xml");
		
		//ͨ���ļ�·������ȡ  ��Ҫ����ļ��ľ���·��
		ApplicationContext ac = new FileSystemXmlApplicationContext("C:\\Users\\hhw\\Desktop\\work\\����\\myspring\\src\\com\\hsp\\ioc\\beans.xml");
		
		Student s1=(Student)ac.getBean("student");
		Student s2=(Student)ac.getBean("student");
		System.out.println(s1+" "+s2);
		//��beanfactory��ȡbean��ֻ��ʵ��������������ô������bean���ᱻʵ����
		//ֻ�е���ȥgetBeanʱ���Ż�ʵʱ����
		//�ٲ���������ô˷���
		//BeanFactory factory = new XmlBeanFactory(
		//		new ClassPathResource("com/hsp/ioc/beans.xml"));
		//factory.getBean("student");
	}

}
