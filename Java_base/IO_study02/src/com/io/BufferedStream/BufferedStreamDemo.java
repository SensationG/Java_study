package com.io.BufferedStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 
 * BufferedWriter 将文本写入字符 输出 流，缓冲字符，以提供单个字符，数组和字符串的高效写入。 
 * BufferedReader 从字符输入流 读取 文本，缓冲字符，以提供字符，数组和行的高效读取。 
 * 
 */
public class BufferedStreamDemo {
	public static void main(String[] args) throws IOException {
		//创建输出缓冲流对象
//		BufferedWriter bWriter = new BufferedWriter(new FileWriter("buffer.txt"));
//		bWriter.write("this is bufferedWriter test");
//		bWriter.close();
		
		//创建输入流缓冲对象
		BufferedReader bReader = new BufferedReader(new FileReader("FileReaderDemo.java"));
		int temp;
		//一次读写一个字符
//		while((temp = bReader.read())!=-1){
//			System.out.print((char)temp);
//		}
//		bReader.close();
		
		//一次读写一个字符串
		char[] ch = new char[1024];
		int len;
		while((len=bReader.read(ch))!=-1) {
			System.out.print(new String(ch,0,len));
		}
		bReader.close();
	}
}
