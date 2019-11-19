package com.io.filewrite;

import java.io.FileWriter;
import java.io.IOException;

/*
 * Write的几种方法
 * void write(String str):写一个字符串数据
 * void write(String str,int index,int len):写一个字符串中的一部分数据
 * void writw(int ch):写一个字符数据，这里写int类型的好处是即可一些char类型数据，也可以写char对应的int类型的值 （ASCII）
 * void write(char[] chs):写一个字符数组的数据
 * void write(char[] chs,int index,int len):写一个字符数组的一部分数据
 * 
 */
public class FileWriteDeno2 {

	public static void main(String[] args) throws IOException {
		//1.创建输出流对象
		FileWriter fW = new FileWriter("b.txt");
		//方法1：void write(String str):写一个字符串数据
		fW.write("abcde");
		
		//方法2：void write(String str,int index,int len):写一个字符串中的一部分数据
		fW.write("abcde", 2, 3);//从位置2开始索引，写入之后3位数
		
		//方法3：void writw(int ch) 写单个字符
		fW.write(97);
		fW.write('a');
		
		//方法4：void write(char[] chs)：写数组
		char[] chs= {'a','b','c','d'};
		fW.write(chs);
		
		//方法5：void write(char[] chs,int index,int len):写一个字符数组的一部分数据
		fW.write(chs, 1, 3);//从位置1开始索引，写入之后5位数
		
		
		//3.close
		fW.close();
	}

}
