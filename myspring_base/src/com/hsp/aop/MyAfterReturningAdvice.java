package com.hsp.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class MyAfterReturningAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args,
			Object target) throws Throwable {
		// TODO Auto-generated method stub
		//后置通知的类 returnValue返回值 调用方法可能有返回值 method：调用了什么方法 args：你调用方法的时候传的参数是什么
		//target：目标对象类
		System.out.println("关闭资源....."+method.getName()+" "+target.getClass());
	}

}
