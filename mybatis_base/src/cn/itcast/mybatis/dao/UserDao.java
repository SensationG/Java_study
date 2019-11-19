package cn.itcast.mybatis.dao;

import cn.itcast.mybatis.po.User;

//dao接口 用户管理
public interface UserDao {
	
	//根据id查询用户信息
	public User findUserDao(int id)throws Exception;
	//添加用户信息
	public void insertUser(UserDao user) throws Exception;
	//删除用户信息
	public void deleteUser(int id) throws Exception;
	//
}
