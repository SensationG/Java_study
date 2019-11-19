package com.io.ObjectStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*
 * 
 * 	解决对象输入流读取对象出现异常的问题
 * 
 */
public class ObjectOutputStreamDemo02 {
	public static void main(String[] args) throws IOException, IOException, ClassNotFoundException {
		//out1(); 输出流
		//以下为对象输入流（读取）
		//1.创建对象输入流的对象
		ObjectInputStream oisStream = new ObjectInputStream(new FileInputStream("p3.txt"));
		//2.读取数据
		Object obj = oisStream.readObject();
		//	向下转型，获取具体的子类对象  由于之前存的是集合 所以可以一次读取完全
		ArrayList<Student> list2 = (ArrayList<Student>) obj;
		//	遍历list
		for(Student a:list2) {
			System.out.println(a);
		}
		//3.释放资源
		oisStream.close();
	}

	private static void out1() throws IOException, FileNotFoundException {
		//1.创建对象输出流的对象（存入）
		ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream("p3.txt"));
		//2.创建集合对象
		ArrayList<Student> list = new ArrayList<Student>();
		//3.添加学生对象
		list.add(new Student("HHW",23));
		list.add(new Student("lili", 84));
		//4.写出集合对象
		ooStream.writeObject(list); 
		//5.释放资源
		ooStream.close();
	}
}
