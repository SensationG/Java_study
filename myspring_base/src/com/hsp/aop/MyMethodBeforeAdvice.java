package com.hsp.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class MyMethodBeforeAdvice implements MethodBeforeAdvice {

	/*
	 * method�������÷���������
	 * agrs����method���ݵĲ���
	 * target��Ŀ�����
	 */
	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		// TODO Auto-generated method stub
		//ǰ��֪ͨ����
		System.out.println("��¼��־����������ǰ��֪ͨ  "+method.getName());
		
	}

}
