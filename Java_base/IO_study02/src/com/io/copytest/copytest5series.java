package com.io.copytest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 复制文本方式（5种）
 * 
 * 数据源：Copy.txt
 * 
 * 目的地：Copytest5
 * 
 */
public class copytest5series {

	public static void main(String[] args) throws IOException {
		/*method1("FileReaderDemo.java","Copytest5.java");
		method2("FileReaderDemo.java","Copytest5.java");
		method3("FileReaderDemo.java","Copytest5.java");
		method4("FileReaderDemo.java","Copytest5.java");
		method5("FileReaderDemo.java","Copytest5.java");
		*/
		String srcFileName = "Copy4.java";
		String destFileName = "Copytest5.java";
		
		//method1(srcFileName,destFileName);
		//method2(srcFileName,destFileName);
		//method3(srcFileName,destFileName);
		//method4(srcFileName,destFileName);
		method5(srcFileName,destFileName);
	}

	//基本流 一次读写一个字符
	private static void method1(String srcFileName,String destFileName) throws IOException{
		//创建输出流对象
		FileWriter fw = new FileWriter(destFileName);
		//创建输入流对象
		FileReader fr = new FileReader(srcFileName);
		
		//一次读写一个字符
		int temp;
		while((temp=fr.read())!=-1) {
			fw.write(temp);
		}
		
		//释放资源
		fw.close();
		fr.close();
	}
	
	//基本流 一次读写一个字符数组
	private static void method2(String srcFileName, String destFileName) throws IOException {
		//创建输出流对象
		FileWriter fw = new FileWriter(destFileName);
		//创建输入流对象
		FileReader fr = new FileReader(srcFileName);
				
		//一次读写一个字符数组
		char[] ch = new char[1024];
		int len;
		while((len=fr.read(ch))!=-1) {
			fw.write(ch,0,len);
		}
	
		//释放资源
		fw.close();
		fr.close();
	}
	
	//缓冲流 一次读取一个字符
	private static void method3(String srcFileName, String destFileName) throws IOException {
		//创建输入缓冲流对象
		BufferedReader br = new BufferedReader(new FileReader(srcFileName));
		//创建输出缓冲流对象
		BufferedWriter bw = new BufferedWriter(new FileWriter(destFileName));
		
		//一次读写一个字符
		int temp;
		while((temp=br.read())!=-1) {
			bw.write(temp);
		}
		
		//释放资源
		br.close();
		bw.close();
	}
	
	//缓冲流 一次读写一个字符数组
	private static void method4(String srcFileName, String destFileName) throws IOException {
		//创建输入缓冲流对象
		BufferedReader br = new BufferedReader(new FileReader(srcFileName));
		//创建输出缓冲流对象
		BufferedWriter bw = new BufferedWriter(new FileWriter(destFileName));
		
		//一次读写一个字符
		char[] ch = new char[1024];
		int len;
		while((len=br.read(ch))!=-1) {
			bw.write(ch,0,len);
		}
		
		//释放资源
		br.close();
		bw.close();
	}
	
	//缓冲流的特殊功能 
	private static void method5(String srcFileName, String destFileName) throws IOException {
		//创建输入缓冲流对象
		BufferedReader br = new BufferedReader(new FileReader(srcFileName));
		//创建输出缓冲流对象
		BufferedWriter bw = new BufferedWriter(new FileWriter(destFileName));
		
		//特殊功能 
		String temp;
		while((temp=br.readLine())!=null) {
			bw.write(temp);
			bw.newLine();
			bw.flush();
		}
		
		//释放资源
		br.close();
		bw.close();
	}
}

