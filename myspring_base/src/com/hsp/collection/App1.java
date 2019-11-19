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
		//增强型for循环用法如下 for(声明语句 : 表达式){ //代码句子} 声明的变量必须和数组元素类型匹配
		for(String emName:department.getEmpName()){
			System.out.println(emName);
		}
		System.out.println("------通过list集合取出数据------");
		for(Employee e: department.getEmpList()){
			System.out.println("name="+e.getName()+e.getId());
		}
		System.out.println("------通过set集合取出数据------");
		for(Employee e: department.getEmpsets()){
			System.out.println("name="+e.getName());
		}
		System.out.println("------通过MAP集合取出数据------");
		for(Entry<String,Employee> entry1: department.getEmpMaps().entrySet()){
			System.out.println(entry1.getKey()+" "+entry1.getValue().getName());
		}
		System.out.println("------通过Properties取出数据----");
		Properties pp = department.getPp();
		System.out.println(pp.get("pp1").toString());
		//Properties继承map，所以可以通过集合传map的方法取出集合
		for(Entry<java.lang.Object, java.lang.Object>entry:pp.entrySet()){
			System.out.println(entry.getKey()+" "+entry.getValue().toString());
		}
		
	}

}
