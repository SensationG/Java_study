package cn.sxt.collection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;
/*
 * 
 * 
 * 	容器list
 * 	测试Collection接口中的方法
 */
public class TestList {
	public static void main(String[] args) {
		//test02();
		test03();
	}
	//list相关方法1
	public static void test01() {

	Collection<String> collection = new ArrayList<>();	
		System.out.println(collection.size());
		//检查是否为空
		System.out.println(collection.isEmpty());
		
		collection.add("hhw1");
		collection.add("hhw2");
		//print
		System.out.println(collection);
		//长度
		System.out.println(collection.size());
		//测试是否包含某个元素
		System.out.println("是否包含某个元素(返回true or false) "+collection.contains("hhw1"));
		
		//移除 不是删除 对象没有被删除
		collection.remove("hhw1");
		System.out.println(collection);
		//移除所有元素
		collection.clear();
	}
	//list相关方法2  多个List之间的操作
	public static void test02() {

		List<String> l1 = new ArrayList<>();
		l1.add("aa");
		l1.add("bb");
		l1.add("cc");
		List<String> l2 = new ArrayList<>();
		l2.add("aa");
		l2.add("dd");
		l2.add("ee");
		
		System.out.println("list01 "+l1);
		
		//l1.addAll(l2);//在l1后添加l2中的元素
		//l1.removeAll(l2);//删除与l2重复的元素
		l1.retainAll(l2);
		System.out.println("list01 "+l1);
		//检测01容器是否包含了02的所有内容
		System.out.println(l1.containsAll(l2));
		
	}
	//List相关方法3 有关List的3个实现类
	public static void test03() {
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		System.out.println(list);
		
		list.add(2,"hhw"); //2为位置，内容
		System.out.println(list);
		
		list.remove(2); //移除
		System.out.println(list);
		
		list.set(2, "高哦老");//设置 覆盖原有值
		System.out.println(list);
		
		System.out.println(list.get(2));//提取位置为2的内容
		
		list.add("C");
		list.add("B");
		list.add("A");
		System.out.println(list);
		
		System.out.println(list.indexOf("B"));//查找元素（第一次出现的位置）
		System.out.println(list.lastIndexOf("B")); //查找元素（最后一次出现的位置）
		
	}
	//Vector实现
	public void test04() {
		List<String> list2 = new Vector<>();
	}
	
}
