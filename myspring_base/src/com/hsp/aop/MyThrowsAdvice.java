package com.hsp.aop;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class MyThrowsAdvice implements ThrowsAdvice {
		
	public void afterThrowing(Method method,Object[] ob,Object Target,Exception e){
		//���׳��쳣�����Զ����ã�����ӡ���ĸ����������쳣
		System.out.println("������ "+e.getMessage());
	}
}
