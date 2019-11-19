package com.hsp.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class MyAfterReturningAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args,
			Object target) throws Throwable {
		// TODO Auto-generated method stub
		//����֪ͨ���� returnValue����ֵ ���÷��������з���ֵ method��������ʲô���� args������÷�����ʱ�򴫵Ĳ�����ʲô
		//target��Ŀ�������
		System.out.println("�ر���Դ....."+method.getName()+" "+target.getClass());
	}

}
