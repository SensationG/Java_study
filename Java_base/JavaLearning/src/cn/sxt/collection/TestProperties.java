package cn.sxt.collection;

import java.util.Properties;
import java.util.Set;

/*
 * Properties:��ʾһ���־õ����Լ��������б���ÿһ����ֵ�����Ӧ��ֵ����һ���ַ���
 * 			ʵ����Map�ӿ�
 * 	���췽����
 * 		Properties() 
 * 	
 * 
 */
public class TestProperties {

	public static void main(String[] args) {
		//1.���������б����
		Properties pp = new Properties();
		//2.���ӳ���ϵ
		pp.put("zb201", "zhanghuang");
		pp.put("zb202", "yuhang");
		pp.put("zb203", "sunce");
		//3.���������б� 
		//	��ȡ���е�key��ͨ��key��ȡvalue
		Set<Object> keys = pp.keySet();
		for(Object key:keys) {
			System.out.println(pp.get(key)+" "+key);
		}
	}

}
