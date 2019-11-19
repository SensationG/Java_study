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
 * ����������List/Set/Map
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
		//forѭ��
		for(int i=0;i<list.size();i++) {
			String temp= list.get(i);
			System.out.println(temp);
		}
		//ʹ�õ���������List
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
		
		//ʹ�õ���������set
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
		
		//ʹ�õ���������map
		//��һ�ֱ���Map�ķ�ʽ
		Set<Entry<Integer,String>> ss = map1.entrySet();
		for(Iterator<Entry<Integer,String>> iter = ss.iterator();iter.hasNext();)
		{
			Entry<Integer,String> temp = iter.next();
			System.out.println(temp);
		}
		//�ڶ��ֱ���Map�ķ�ʽ 
		Set<Integer> keySet = map1.keySet();//���Key�ļ���
		for(Iterator<Integer> iter = keySet.iterator();iter.hasNext();)
		{
			Integer key = iter.next();
			System.out.println(key+"--"+map1.get(key));
		}
	}
}
