package cn.sxt.collection;

import java.util.HashMap;
import java.util.Map;

/*
 * 
 * HashMap 的使用教学
 * 2019.06.30
 *	  基础部分
 */
public class TestMap {
	public static void main(String[] args) {
		//Map的使用 <Integer,String> 第一个为Key的类型，第二个为Value类型
		Map<Integer,String> m1 = new HashMap<>();
		//存入值
		m1.put(1, "hhw");
		m1.put(2, "ymd");
		m1.put(3, "hmd");
		//取出值
		System.out.println(m1.get(1));
		//常用方法
		System.out.println(m1.size());
		System.out.println(m1.isEmpty());
		System.out.println(m1.containsKey(2));
		System.out.println(m1.containsValue("hhw"));
		
		Map<Integer, String> m2 = new HashMap<>();
		m2.put(2, "四");
		m2.put(5, "five");
		
		m1.putAll(m2);//类似ArrayList的addAll
		//如果m2的Key与m1中的key重复，
		//那么m2中Key与m1重复的，m2的Value会覆盖m1的
		System.out.println(m1);
		
	}
	
	
}
