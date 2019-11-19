package cn.sxt.collection;

import java.util.Properties;
import java.util.Set;

/*
 * Properties:表示一个持久的属性集，属性列表中每一个键值及其对应的值都是一个字符串
 * 			实现了Map接口
 * 	构造方法：
 * 		Properties() 
 * 	
 * 
 */
public class TestProperties {

	public static void main(String[] args) {
		//1.创建属性列表对象
		Properties pp = new Properties();
		//2.添加映射关系
		pp.put("zb201", "zhanghuang");
		pp.put("zb202", "yuhang");
		pp.put("zb203", "sunce");
		//3.遍历属性列表 
		//	获取所有的key，通过key获取value
		Set<Object> keys = pp.keySet();
		for(Object key:keys) {
			System.out.println(pp.get(key)+" "+key);
		}
	}

}
