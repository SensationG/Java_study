package cn.sxt.collection;

import java.util.HashSet;
import java.util.Set;

/*
 * 
 * HashSet��ϰ
 * @Sensation
 * 
 * 
 */
public class TestHashSet {
	public static void main(String[] args) {
		Set<String> set1 = new HashSet<>();
		
		//��set������Ԫ��
		set1.add("aa");
		set1.add("bb");
		set1.add("aa");//���ڲ���������ظ�Ԫ��
		System.out.println(set1);
		
		Set<Integer> set2 = new HashSet<>();
		set2.add(222);
		System.out.println(set2);
		
		Set<Integer> set3 = new HashSet<>();
		for(int i=0;i<10;i++)
		{
			set3.add(i);
		}
		System.out.println(set3);
		set3.add(10);
		set3.addAll(set2);
		System.out.println(set3);
	}

}
