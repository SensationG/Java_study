package cn.itcast.mybatis.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.po.Orders;
import cn.itcast.mybatis.po.OrdersCustom;

public class OrdersMapperCustomTest {

	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp() throws Exception {
		////创建sqlSessionFactory
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory  = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindOrderUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建代理对象
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		//调用mapper的方法
		List<OrdersCustom> list = ordersMapperCustom.findOrderUser();
		System.out.println(list);
		sqlSession.close();
	}

	@Test
	public void testFindOrderUserResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建代理对象 xml路径读取
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		//调用mapper的方法
		List<Orders> list = ordersMapperCustom.findOrderUserResultMap();
		System.out.println(list);
		sqlSession.close();
	}
}
