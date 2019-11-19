package com.io.arrayListToFileT;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
 * 需求： 把ArrayList集合种的字符串数据存储到文本文件
 * 每一个字符串元素作为文件中的一行数据
 * 
 * 分析：
 * 		1.创建集合对象
 * 		2.往集合中添加字符串元素
 * 		3.创建流对象 -这里选缓冲流（效率高）
 * 		4.遍历集合，得到每一个字符串元素，然后把该字符串元素作为数据写到文本文件
 * 		5.释放资源
 * 
 */
public class ArrayListToFileTest {

	public static void main(String[] args) throws IOException {
		//1.创建集合对象
		ArrayList<String> list = new ArrayList<>();
		//2.添加元素
		list.add("hello");
		list.add("world");
		list.add("hhw");
		//3.创建缓冲流输出对象
		BufferedWriter bw = new BufferedWriter(new FileWriter("Array.txt"));
		//4.遍历集合
		for(String a:list) {
			bw.write(a);
			bw.newLine();
			bw.flush();
		}
		//5.释放资源
		bw.close();

	}

}
