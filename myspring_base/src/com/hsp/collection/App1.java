package com.hsp.collection;



import java.util.Properties;
import java.util.Map.Entry;

import org.omg.CORBA.Object;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/hsp/collection/beans.xml");
		Department department = (Department)ac.getBean("department");
		System.out.println(department.getName());
		//��ǿ��forѭ���÷����� for(������� : ���ʽ){ //�������} �����ı������������Ԫ������ƥ��
		for(String emName:department.getEmpName()){
			System.out.println(emName);
		}
		System.out.println("------ͨ��list����ȡ������------");
		for(Employee e: department.getEmpList()){
			System.out.println("name="+e.getName()+e.getId());
		}
		System.out.println("------ͨ��set����ȡ������------");
		for(Employee e: department.getEmpsets()){
			System.out.println("name="+e.getName());
		}
		System.out.println("------ͨ��MAP����ȡ������------");
		for(Entry<String,Employee> entry1: department.getEmpMaps().entrySet()){
			System.out.println(entry1.getKey()+" "+entry1.getValue().getName());
		}
		System.out.println("------ͨ��Propertiesȡ������----");
		Properties pp = department.getPp();
		System.out.println(pp.get("pp1").toString());
		//Properties�̳�map�����Կ���ͨ�����ϴ�map�ķ���ȡ������
		for(Entry<java.lang.Object, java.lang.Object>entry:pp.entrySet()){
			System.out.println(entry.getKey()+" "+entry.getValue().toString());
		}
		
	}

}
