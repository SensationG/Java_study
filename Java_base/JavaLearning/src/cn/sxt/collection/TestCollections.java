package cn.sxt.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 
 * Collections�������ʹ��
 * �ǽӿ�
 * 
 */
public class TestCollections {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		for(int i=0;i<10;i++) {
			list.add("hhw"+i);
		}
		System.out.println(list);
		
		Collections.shuffle(list);//�������List������
		System.out.println(list);

		Collections.reverse(list);//�������У�����List�±��ж�˳�򣬷Ǵ�С��
		System.out.println(list);
		
		Collections.sort(list);//�������ִ�С������ʽ����
		System.out.println(list);
		
		System.out.println(Collections.binarySearch(list, "hhw3"));//���ַ�����
	}
}
