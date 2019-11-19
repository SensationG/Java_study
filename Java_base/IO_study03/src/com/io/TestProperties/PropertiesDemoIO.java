package com.io.TestProperties;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Set;

/*
 * 
 * 	Properties 与 IO流结合的功能：
 * 				void list(PrintWriter out) 
 * 				void load(Reader reader) 
 * 				void store(OutputStream out, String comments) 
 */
public class PropertiesDemoIO {
	public static void main(String[] args) throws IOException {
		//method1();//void list(PrintWriter out) 
		//method2();//void load(Reader reader) 
		//void store(OutputStream out, String comments)  以下是
		//1.创建属性列表
		Properties pp = new Properties();
		//2.添加映射关系
		pp.setProperty("zb201", "zhanghuang");
		pp.setProperty("zb202", "yuhang");
		pp.setProperty("zb203", "sunce");
		//3.创建输出流对象
		FileWriter fWriter = new FileWriter("e.txt");
		//4.void store(OutputStream out, String comments) 
		pp.store(fWriter, "HEllo");
		//5.释放资源
		fWriter.close();
	}

	private static void method2() throws FileNotFoundException, IOException {
		//void load(Reader reader)  以下是
		//1.创建属性列表对象
		Properties pp2 = new Properties();
		//2.创建一个输入流对象
		BufferedReader br = new BufferedReader(new FileReader("d.txt"));
		//3.读取数据 load方法
		pp2.load(br);
		//4.遍历集合
		Set<Object> s1 = pp2.keySet();
		for(Object s:s1) {
			System.out.println(pp2.get(s)+" "+s);
		}
		//5.释放资源
		br.close();
	}

	private static void method1() throws FileNotFoundException {
		//1.创建属性列表对象
		Properties pp = new Properties();
		//2.添加映射关系
		pp.setProperty("zb201", "zhanghuang");
		pp.setProperty("zb202", "yuhang");
		pp.setProperty("zb203", "sunce");
		//3.创建打印流对象
		PrintWriter pWriter = new PrintWriter("d.txt");
		//4.void list方法
		pp.list(pWriter);//将集合内容输出到文件
		//5.释放资源
		pWriter.close();
	}
}
