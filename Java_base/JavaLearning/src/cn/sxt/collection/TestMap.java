package cn.sxt.collection;

import java.util.HashMap;
import java.util.Map;

/*
 * 
 * HashMap ��ʹ�ý�ѧ
 * 2019.06.30
 *	  ��������
 */
public class TestMap {
	public static void main(String[] args) {
		//Map��ʹ�� <Integer,String> ��һ��ΪKey�����ͣ��ڶ���ΪValue����
		Map<Integer,String> m1 = new HashMap<>();
		//����ֵ
		m1.put(1, "hhw");
		m1.put(2, "ymd");
		m1.put(3, "hmd");
		//ȡ��ֵ
		System.out.println(m1.get(1));
		//���÷���
		System.out.println(m1.size());
		System.out.println(m1.isEmpty());
		System.out.println(m1.containsKey(2));
		System.out.println(m1.containsValue("hhw"));
		
		Map<Integer, String> m2 = new HashMap<>();
		m2.put(2, "��");
		m2.put(5, "five");
		
		m1.putAll(m2);//����ArrayList��addAll
		//���m2��Key��m1�е�key�ظ���
		//��ôm2��Key��m1�ظ��ģ�m2��Value�Ḳ��m1��
		System.out.println(m1);
		
	}
	
	
}
