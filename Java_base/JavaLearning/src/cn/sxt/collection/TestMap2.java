package cn.sxt.collection;

import java.util.HashMap;
import java.util.Map;

/*
 * 
 *  Map教学2
 *         	稍微复杂的部分
 *         
 */
public class TestMap2 {
	public static void main(String[] args) {
		Employee e1 = new Employee(1001, "hhw", 50000);
		Employee e2 = new Employee(1002, "小明", 10000);
		Employee e3 = new Employee(1003, "小红", 30000);
		//使用Map存储对象
		Map<Integer, Employee> map1 = new HashMap<>();
		map1.put(1001, e1);
		map1.put(1002, e2);
		map1.put(1003, e3);
		//取值
		Employee emp = map1.get(1001);
		System.out.println(emp.getEname());
		System.out.println(map1.toString());
	}
}

class Employee{
	private int id;
	private String ename;
	private double salary;
	
	public Employee(int id, String ename, double salary) {
		super();
		this.id = id;
		this.ename = ename;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id "+id+"name "+ename+"salary "+salary;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
}