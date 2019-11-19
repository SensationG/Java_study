package cn.sxt.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 
 * Collections辅助类的使用
 * 非接口
 * 
 */
public class TestCollections {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		for(int i=0;i<10;i++) {
			list.add("hhw"+i);
		}
		System.out.println(list);
		
		Collections.shuffle(list);//随机排列List种数据
		System.out.println(list);

		Collections.reverse(list);//逆序排列（根据List下标判定顺序，非大小）
		System.out.println(list);
		
		Collections.sort(list);//按照数字大小递增方式排列
		System.out.println(list);
		
		System.out.println(Collections.binarySearch(list, "hhw3"));//二分法查找
	}
}
