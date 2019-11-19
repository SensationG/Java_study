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
		System.out.println("PersonService函数被调用");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("setname函数");
		this.name = name;
	}

	public void sayHi() {
		System.out.println("hi " + name);
	}

	// 该方法可以给arg0表示正在被实例化的bean id
	@Override
	public void setBeanName(String arg0) {
		// TODO Auto-generated method stub
		System.out.println("正在setBeanName id " + arg0);
	}

	// 该方法可以传递beanFactory
	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("setBeanFactory " + arg0);
	}

	// 上下文接口传递ApplicationContext
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
		System.out.println("afterPropertiesSet()被調用");
	}
	
	//也可以用注解的方式来配置哪个方法init 	@PostConstruct 会自动引包
	@PostConstruct
	public void init(){
		System.out.println("自身init方法被调用");
	}
	
	//public void destroy() throws Exception{
		//我们可以关闭数据连接，socket，文件流，释放该bean的资源
	//}
	
	//定制销毁方法     或使用注解@PreDestroy
	@PreDestroy
	public void mydestroy(){
		System.out.println("释放各种资源");//看不见输出，但会执行此方法
	}
}
