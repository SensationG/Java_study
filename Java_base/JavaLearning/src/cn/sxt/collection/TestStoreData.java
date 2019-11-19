package cn.sxt.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/*
 * 
 * ���Ա�����ݵĴ洢
 * ÿһ������ʹ��һ��Map
 * �������ʹ��һ��List
 * 
 */
public class TestStoreData {
	public static void main(String[] args) {
		Map<String, Object> row1 = new HashMap<>();
		row1.put("id", 10001);
		row1.put("����", "hui");
		row1.put("нˮ", 1560);
		
		Map<String, Object> row2 = new HashMap<>();
		row2.put("id", 10002);
		row2.put("����", "qwe");
		row2.put("нˮ", 15602);
		
		Map<String, Object> row3 = new HashMap<>();
		row3.put("id", 10003);
		row3.put("����", "wei");
		row3.put("нˮ", 1589);
		
		List<Map<String, Object>> table = new ArrayList<>();
		table.add(row1);
		table.add(row2);
		table.add(row3);
		
		for(Map<String, Object> row:table)
		{
			Set<String> keySet =  row.keySet();//��ȡÿ��map��Keyֵ��map1-3��
			for(String key:keySet) 
			{
				System.out.print(key+":"+row.get(key)+"\t");
			}
			System.out.println();
		}
	
	}
}
