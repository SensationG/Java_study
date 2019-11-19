package com.hsp.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyMethodInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("调用方法前执行。。来自环绕通知");
		Object obj=arg0.proceed();//需返回对象否则不会对对象类中的方法执行
		System.out.println("调用方法后执行。。来自环绕通知");
		return null;
	}

}
