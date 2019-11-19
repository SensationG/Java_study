package com.hsp.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class MyMethodBeforeAdvice implements MethodBeforeAdvice {

	/*
	 * method：被调用方法的名字
	 * agrs：给method传递的参数
	 * target：目标对象
	 */
	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		// TODO Auto-generated method stub
		//前置通知的类
		System.out.println("记录日志。。。来自前置通知  "+method.getName());
		
	}

}
