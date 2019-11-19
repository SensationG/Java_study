package com.hsp.aop;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class MyThrowsAdvice implements ThrowsAdvice {
		
	public void afterThrowing(Method method,Object[] ob,Object Target,Exception e){
		//若抛出异常，则自动调用，并打印出哪个函数出现异常
		System.out.println("出事了 "+e.getMessage());
	}
}
