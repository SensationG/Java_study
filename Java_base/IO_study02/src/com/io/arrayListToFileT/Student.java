package com.io.arrayListToFileT;

//标准学生类 含无参构造和带参构造
public class Student {
	private String num;
	private String name;
	private String age;
	private String city;
	
	public Student() {
		
	}
	
	
	public Student(String num, String name, String age, String city) {
		this.num = num;
		this.name = name;
		this.age = age;
		this.city = city;
	}

	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
