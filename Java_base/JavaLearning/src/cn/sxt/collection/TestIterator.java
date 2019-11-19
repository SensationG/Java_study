package cn.sxt.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.text.html.parser.Entity;

/*
 * 
 * 迭代器遍历List/Set/Map
 * 
 * 
 * 
 */
public class TestIterator {
	public static void main(String[] args) {
		TestIterator();
//		TestIteratorSet();
//		TestIteratorMap();
	}
	//List
	public static void TestIterator() {
		List<String> list = new ArrayList<>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		//for循环
		for(int i=0;i<list.size();i++) {
			String temp= list.get(i);
			System.out.println(temp);
		}
		//使用迭代器遍历List
		for(Iterator<String> iter = list.iterator();iter.hasNext();)
		{
			String temp = iter.next();
			System.out.println(temp);
		}
	}
	//Set
	public static void TestIteratorSet() {
		Set<String> set = new HashSet<>();
		set.add("aaa");
		set.add("bbb");
		set.add("ccc");
		
		//使用迭代器遍历set
		for(Iterator<String> iter = set.iterator();iter.hasNext();)
		{
			String temp = iter.next();
			System.out.println(temp);
		}
	}
	//map
	public static void TestIteratorMap() {
		Map<Integer,String> map1 = new HashMap<>();
		map1.put(1,"mapaaa");
		map1.put(2,"mapbbb");
		map1.put(3,"mapccc");
		
		//使用迭代器遍历map
		//第一种遍历Map的方式
		Set<Entry<Integer,String>> ss = map1.entrySet();
		for(Iterator<Entry<Integer,String>> iter = ss.iterator();iter.hasNext();)
		{
			Entry<Integer,String> temp = iter.next();
			System.out.println(temp);
		}
		//第二种遍历Map的方式 
		Set<Integer> keySet = map1.keySet();//获得Key的集合
		for(Iterator<Integer> iter = keySet.iterator();iter.hasNext();)
		{
			Integer key = iter.next();
			System.out.println(key+"--"+map1.get(key));
		}
	}
}
