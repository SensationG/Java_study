package com.hsp.collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


public class Department {
	
	private String name;
	private String [] empName;
	private List<Employee> empList;
	private Set<Employee> empsets;
	private Map<String,Employee> empMaps;
	private Properties pp;//properties 结合的注入
	
	public Properties getPp() {
		return pp;
	}
	public void setPp(Properties pp) {
		this.pp = pp;
	}
	public Map<String, Employee> getEmpMaps() {
		return empMaps;
	}
	public void setEmpMaps(Map<String, Employee> empMaps) {
		this.empMaps = empMaps;
	}
	
	public Set<Employee> getEmpsets() {
		return empsets;
	}
	public void setEmpsets(Set<Employee> empsets) {
		this.empsets = empsets;
	}
	
	public List<Employee> getEmpList() {
		return empList;
	}
	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getEmpName() {
		return empName;
	}
	public void setEmpName(String[] empName) {
		this.empName = empName;
	}
	
}
