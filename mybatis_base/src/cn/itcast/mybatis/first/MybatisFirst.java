package cn.itcast.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.mybatis.po.User;


public class MybatisFirst {
	//根据id查询用户信息，得到一条记录的结果
	
	@Test
	public void findUserByIdTest()throws IOException{
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建会话工厂 ,向build传入mybatis文件的配置信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//创建工厂得到SqlSession
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//通过SqlSession操作数据库  通过映射文件映射成一个user对象 所以是user型 
		//第一个参数是映射文件User.xml中statement的id，等于=namespace的id+"."+statement的id
		//第二个参数是 指定和映射文件中所匹配的parameterType类型的参数 
		//sqlSession.selectOne结果是与映射文件中所匹配的resultType类型的对象 selectone表示查询一条记录
		User user = sqlSession.selectOne("test.findUserById",1);
		System.out.println(user);
		//释放资源
		sqlSession.close();
	}
	
	//根据用户名称模糊查询用户列表
	@Test
	public void findUserByNameTest()throws IOException{
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//list中的user和映射文件中resultType所指定的类型一致 
		List<User> user = sqlSession.selectList("test.findUserByName","小明");
		System.out.println(user);
		sqlSession.close();
	}
	
	//添加用户
	@Test
	public void insertUserTest()throws IOException{
		//mybatis配置文件(模板）
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//插入用户对象 因为id是自增的 所以日志id为0
		User user= new User();
		user.setUsername("王小军");
		user.setAddress("河南郑州");
		user.setBirthday(new Date());
		user.setSex("1");
		//没有返回值
		sqlSession.insert("test.insertUser",user);
		//手动提交
		sqlSession.commit();
		//获取用户主键
		System.out.println(user.getId());
		sqlSession.close();
	}
	
	//删除用户
	@Test
	public void deleteUserTest() throws IOException{
		//mybatis配置文件(模板）
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession=sqlSessionFactory.openSession();
		sqlSession.delete("test.deleteUser",37);
		sqlSession.commit();
		sqlSession.close();
	}
	
	//更新用户
	@Test
	public void updateUserTest()throws IOException{
		//mybatis配置文件(模板）
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//插入用户对象 因为id是自增的 所以日志id为0
		User user= new User();
		user.setId(34);
		user.setUsername("王大将军");
		user.setBirthday(new Date());
		user.setSex("2");
		//没有返回值
		sqlSession.insert("test.updateUser",user);
		sqlSession.commit();
		sqlSession.close();
	}
}
