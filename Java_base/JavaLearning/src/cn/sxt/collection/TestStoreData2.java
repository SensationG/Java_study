package cn.sxt.collection;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 * 每一行使用javabean对象存储
 * 多行使用List/map存储
 * 体会ORM思想
 * 
 */
public class TestStoreData2 {
	public static void main(String[] args) {
		User user1 = new User(1001, "张三",4646.2, "2018.5.5");
		User user2 = new User(1002, "王五",846.2, "2018.5.5");
		User user3 = new User(1003, "莉莉丝",48396.2, "2018.5.5");
		
		List<User> list = new ArrayList<>();
		list.add(user1);
		list.add(user2);
		list.add(user3);
		
		for(User u:list) {
			System.out.println(u);
		}
	}
}

class User{
	private int id;
	private String name;
	private Double salary;
	private String hireDate;
	
	//一个完整的javabean。需要有set和get方法，以及一个无参构造器
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(int id, String name, Double salary, String hireDate) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.hireDate = hireDate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id+" "+name+" "+salary+" "+hireDate;
	}
	
	
}
