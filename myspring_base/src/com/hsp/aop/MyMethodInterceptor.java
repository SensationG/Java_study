package com.hsp.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyMethodInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("���÷���ǰִ�С������Ի���֪ͨ");
		Object obj=arg0.proceed();//�践�ض�����򲻻�Զ������еķ���ִ��
		System.out.println("���÷�����ִ�С������Ի���֪ͨ");
		return null;
	}

}
