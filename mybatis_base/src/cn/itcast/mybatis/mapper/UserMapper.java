package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.po.User;
import cn.itcast.mybatis.po.UserCustomer;
import cn.itcast.mybatis.po.UserQueryVo;

//Mapper接口 相当于dao接口 用户管理
public interface UserMapper {

	//	根据id查询用户信息
	public User findUserById(int id)throws Exception;
	//	根据id查询用户信息 使用resultMap输出
	public User findUserByResultMap(int id)throws Exception;
	//  根据name查询用户信息 可能返回多条记录 所以用list
	public List<User> findUserByName(String name)throws Exception;
	//	添加用户信息
	public void insertUser(User user)throws Exception;
	//	删除用户信息
	public void deleteUser(int id)throws Exception;
	//  用户信息的综合查询
	public List<UserCustomer> findUserList(UserQueryVo userQueryVo) throws Exception;
	//	用户信息的综合查询总数
	public int findUserCount(UserQueryVo userQueryVo1) throws Exception;

}
