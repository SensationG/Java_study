package com.hsp.autowire;

public class Master {
	private String name;
	private Dog dog1;
	
	public  Master(Dog dog1){
		this.dog1=dog1;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Dog getDog1() {
		return dog1;
	}
	public void setDog1(Dog dog1) {
		this.dog1 = dog1;
	}
	
	
}
