package com.hsp.dispatch;

import javax.rmi.CORBA.Util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/hsp/dispatch/beans.xml");
		DBUtil dbutil=(DBUtil) ac.getBean("dbutil");
		DBUtil dbutil2=(DBUtil) ac.getBean("dbutil2");
		System.out.println(dbutil.getDrivername()+" "+dbutil2.getDrivername()+" "+dbutil2.getName());
	}

}
