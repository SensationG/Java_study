package cn.sxt.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/*
 * 
 * 测试表格数据的存储
 * 每一行数据使用一个Map
 * 整个表格使用一个List
 * 
 */
public class TestStoreData {
	public static void main(String[] args) {
		Map<String, Object> row1 = new HashMap<>();
		row1.put("id", 10001);
		row1.put("姓名", "hui");
		row1.put("薪水", 1560);
		
		Map<String, Object> row2 = new HashMap<>();
		row2.put("id", 10002);
		row2.put("姓名", "qwe");
		row2.put("薪水", 15602);
		
		Map<String, Object> row3 = new HashMap<>();
		row3.put("id", 10003);
		row3.put("姓名", "wei");
		row3.put("薪水", 1589);
		
		List<Map<String, Object>> table = new ArrayList<>();
		table.add(row1);
		table.add(row2);
		table.add(row3);
		
		for(Map<String, Object> row:table)
		{
			Set<String> keySet =  row.keySet();//获取每个map的Key值（map1-3）
			for(String key:keySet) 
			{
				System.out.print(key+":"+row.get(key)+"\t");
			}
			System.out.println();
		}
	
	}
}
