package com.io.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 
 * 	使用字节流复制文本文件
 * 	数据源：	bw.txt
 * 	目的地： 	d:\\a\\bw.txt
 * 
 */
public class FileCopyDemo {
	public static void main(String[] args) throws IOException {
		//1.创建字节输入流对象
		FileInputStream  fisStream = new FileInputStream("bw2.txt");
		//2.创建字节输出流对象
		FileOutputStream fosStream = new FileOutputStream("d:\\a\\bw.txt");
		//3.复制 
		//	1方法  一次读写一个字节
		//		int by;
		//		while((by = fisStream.read())!=-1) {
		//			fosStream.write(by);
		//		}
		//	2方法 一次读写一个字符数组
		int len;
		byte[] by1 = new byte[1024];
		while((len = fisStream.read(by1))!=-1) {
			fosStream.write(by1,0,len);
		}
		//4.释放资源
		fosStream.close();
		fisStream.close();
	}
}
