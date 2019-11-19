package cn.itcast.mybatis.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.po.User;

public class UserDaoImplTest {
	private SqlSessionFactory sqlSessionFactory;
	//此方法在执行 testFindUserDao()前执行
	@Before
	public void setUp() throws Exception {
		//创建sqlSessionFactory
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory  = new SqlSessionFactoryBuilder().build(inputStream);
	}
	@Test
	public void testFindUserDao() throws Exception {
		//创建UserDao的对象 接口对象实例化 左边位接口 右边为实现接口的类
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		//调用UserDao的方法 通过接口调取方法 
		User user = userDao.findUserDao(1);
		System.out.println(user);
	}
	@Test
	public void testdeleteUserDao() throws Exception {
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		//调用UserDao的方法 通过接口调取方法 
		userDao.deleteUser(39);
	}
}
