package com.hsp.beanlife;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class PersonService implements BeanNameAware, BeanFactoryAware,
		ApplicationContextAware, InitializingBean{
	private String name;

	public PersonService() {
		System.out.println("PersonService����������");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("setname����");
		this.name = name;
	}

	public void sayHi() {
		System.out.println("hi " + name);
	}

	// �÷������Ը�arg0��ʾ���ڱ�ʵ������bean id
	@Override
	public void setBeanName(String arg0) {
		// TODO Auto-generated method stub
		System.out.println("����setBeanName id " + arg0);
	}

	// �÷������Դ���beanFactory
	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("setBeanFactory " + arg0);
	}

	// �����Ľӿڴ���ApplicationContext
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("setApplicationContext " + arg0);
	}

	//
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterPropertiesSet()���{��");
	}
	
	//Ҳ������ע��ķ�ʽ�������ĸ�����init 	@PostConstruct ���Զ�����
	@PostConstruct
	public void init(){
		System.out.println("����init����������");
	}
	
	//public void destroy() throws Exception{
		//���ǿ��Թر��������ӣ�socket���ļ������ͷŸ�bean����Դ
	//}
	
	//�������ٷ���     ��ʹ��ע��@PreDestroy
	@PreDestroy
	public void mydestroy(){
		System.out.println("�ͷŸ�����Դ");//���������������ִ�д˷���
	}
}
