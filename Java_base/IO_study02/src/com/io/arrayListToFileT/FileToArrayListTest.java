package com.io.arrayListToFileT;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * 
 * 需求：从文本文件中读取数据到ArrayList集合中，并遍历集合
 * 每一行数据作为一个字符串元素
 * 
 * 分析：
 * 		1.创建输入缓冲流对象
 * 		2.创建集合对象
 * 		3.读取数据，每次读取一行数据，每行数据作为一个元素存储到集合中
 * 		4.释放资源
 * 		5.遍历集合
 * 
 */
public class FileToArrayListTest {

	public static void main(String[] args) throws IOException {
		//1.创建输入缓冲流对象
		BufferedReader br = new BufferedReader(new FileReader("Array.txt"));
		//2.创建集合对象
		ArrayList<String> list = new ArrayList<>();
		//3.读取数据
		String temp;
		while((temp=br.readLine())!=null) {
			list.add(temp);
		}
		//4.释放资源
		br.close();
		//5.遍历集合
		for(String a:list) {
			System.out.println(a);
		}

	}

}
