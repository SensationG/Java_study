package com.hsp.constructor;

public class Employee {
	private String name;
	private int age;
	//���캯���޲� ��֤�޲�ʱ�������У�����Ҫдһ���޲εĹ��캯��
	public Employee(){
	}
	//�в�
	public Employee(String name, int age) {
		System.out.println("Employee(String name, int age)������");
		this.name = name;
		this.age = age;
	}
	public Employee(String name){
		System.out.println("Employee(String name)������");
		this.name=name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
