package com.sxt.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/*
 * 
 * d IO基本操作步骤 标准步骤 但是没有规范 规范见02
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * 
 * 
 */
public class IOTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.创建源
		File src = new File("abc.txt");
		//2.选择流
		try {
			InputStream is = new FileInputStream(src);
			//3.操作（读取）
			int data1 = is.read();//第一个数据s
			int data2 = is.read();//第二个数据空格
			int data3 = is.read();//第三个数据t
			int data4 = is.read();//文件末尾无数据
			System.out.println((char)data1);//需要强转才返回数据 否则返回ASC码
			System.out.println((char)data2);
			System.out.println((char)data3);
			System.out.println(data4);//末尾无数据返回-1
			//4.释放资源
			is.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
