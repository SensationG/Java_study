package com.hsp.inherit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hsp.collection.Department;

public class App1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/hsp/inherit/beans.xml");
		Graduate graduate = (Graduate)ac.getBean("graduate");
		System.out.println(graduate.getAge()+" "+graduate.getDegree()+" "+graduate.getName());
	}

}
