package cn.itcast.mybatis.po;

import java.util.List;

//包装类型
public class UserQueryVo {
	
	//传入多个id
	private List<Integer> ids;
	
	//在这里包装所需要的查询条件
	
	//用户查询条件
	private UserCustomer userCustomer;
	
	public UserCustomer getUserCustomer() {
		return userCustomer;
	}

	public void setUserCustomer(UserCustomer userCustomer) {
		this.userCustomer = userCustomer;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	
	//包装所需要的查询条件
	
	
	
	
	
	
}
