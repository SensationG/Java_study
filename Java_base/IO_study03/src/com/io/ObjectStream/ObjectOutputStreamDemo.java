package com.io.ObjectStream;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * 	对象操作流： 可以用于读写任意类型的对象
 * 		ObjectOutputStream 输出流
 * 		ObjectInputStream 输入流
 * 
 * 	注意：	
 * 		1. 使用对象输出流输出对象只能使用对象输入流读取对象
 * 		2.只有支持java.io.Serializable接口的对象才能写入流中
 */
public class ObjectOutputStreamDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//out1();//输出流
		//以下为输入流
		//1.创建对象输入流的对象
		ObjectInputStream ojStream = new ObjectInputStream(new FileInputStream("o1.txt"));
		//2.读取对象
//		Object obj = ojStream.readObject();
//		System.out.println(obj);
//		
//		Object obj2 = ojStream.readObject();
//		System.out.println(obj2);
//		
//		Object obj3 = ojStream.readObject();
//		System.out.println(obj3);
		try {
			while(true) {
				Object obj = ojStream.readObject();
				System.out.println(obj);
			}
		} catch (EOFException e) {
			System.out.println("文件末尾");
		}

		//3.释放资源
		ojStream.close();
	}

	private static void out1() throws FileNotFoundException, IOException {
		//1.创建对象输出流的对象
		FileOutputStream fosStream = new FileOutputStream("o1.txt");
		ObjectOutputStream ooStream = new ObjectOutputStream(fosStream);
		//2.创建学生对象
		Student s1 = new Student("hhw", 29);
		Student s2 = new Student("ymd", 20);
		//3.写入学生对象
		ooStream.writeObject(s1);//写出学生对象的类必须实现序列化接口
		ooStream.writeObject(s2);
		//4.释放资源
		ooStream.close();
		fosStream.close();
	}
}
