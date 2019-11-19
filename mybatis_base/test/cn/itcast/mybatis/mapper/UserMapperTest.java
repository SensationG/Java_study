package cn.itcast.mybatis.mapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.po.User;

import cn.itcast.mybatis.po.UserCustomer;

import cn.itcast.mybatis.po.UserQueryVo;

public class UserMapperTest {
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp() throws Exception {
		////创建sqlSessionFactory
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory  = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindUserById() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建mapperUser对象 因为mapper代理没有实现类 要考虑如何创建对象
		//mybatis 自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//获取结果
		User user = userMapper.findUserById(1);
		System.out.println(user);
	}
	
	@Test
	public void testFindUserByResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建mapperUser对象 因为mapper代理没有实现类 要考虑如何创建对象
		//mybatis 自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//获取结果
		User user = userMapper.findUserByResultMap(29);
		System.out.println(user);
	}
	
	@Test
	public void testFindUserByName() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建mapperUser对象 因为mapper代理没有实现类 要考虑如何创建对象
		//mybatis 自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//获取结果 多个对象 使用list类型     
		List<User> list = userMapper.findUserByName("五");
		System.out.println(list);
	}
	
	//用户信息综合查询
	@Test
	public void testFindUserList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//创建包装对象，设置 查询条件
		UserCustomer userCustomer = new UserCustomer();
		UserQueryVo userQueryVo =  new UserQueryVo();
		//由于这里使用了动态sql，如果不设置某个值，条件不会拼接在sql中--》 因为映射文件中加了判断文件 所以传入为空时，条件不会拼接
		userCustomer.setSex("1");
		//userCustomer.setUsername("三");
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(10);
		ids.add(16);
		userQueryVo.setIds(ids);
		userQueryVo.setUserCustomer(userCustomer);
		//调用userMapper的方法 因为xml中输出类型是UserCustomer 所以这里生成的list表也应是该类型
		List<UserCustomer> list = userMapper.findUserList(userQueryVo); //传空 因为映射文件中加了判断文件 所以传入为空时，条件不会拼接
		System.out.println(list);
	}
	
	//用户信息综合查询总数（count） 出现问题 xml中已经被注释
	 @Test
	    public void testFindUserCount() throws Exception {

	        SqlSession sqlSession = sqlSessionFactory.openSession();
	        //创建UserMapper对象，mybatis自动生成mapper代理对象
	        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
	        //创建包装对象，设置查询条件
	        UserQueryVo userQueryVo1 = new UserQueryVo();
	        UserCustomer userCustom = new UserCustomer();
	        //由于这里使用动态sql，如果不设置某个值，条件不会拼接在sql中
	        //userCustom.setSex("1");
	        //userCustom.setUsername("小");
	        userQueryVo1.setUserCustomer(userCustom);
	        //调用userMapper的方法
	        int count = userMapper.findUserCount(userQueryVo1);
	        System.out.println(count);
	    }
	
}
