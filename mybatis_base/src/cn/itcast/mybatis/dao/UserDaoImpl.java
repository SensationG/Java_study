package cn.itcast.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.itcast.mybatis.po.User;

public class UserDaoImpl implements UserDao {

	//需要向dao实现类注入SqlSessionFactory
	//通过构造函数注入
	private SqlSessionFactory sqlSessionFactory;
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public User findUserDao(int id) throws Exception {
		//因为线程不安全，所以sqlsession要定义在方法体内
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//return sqlSession.selectOne("test.findUserById", id); 因为还要释放资源 所以不能直接return
		User user = sqlSession.selectOne("test.findUserById", id);
		sqlSession.close();
		return user;
	}

	public void insertUser(UserDao user) throws Exception {
		// 插入对象从user引入 所以不需要再写
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("test.insertUser", user);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public void deleteUser(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("test.deleteUser", id);
		sqlSession.commit();
		sqlSession.close();
	}

}
