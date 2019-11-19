package com.io.print;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * 
 * 	使用打印流复制文本文件
 * 
 * 	数据源： SystemInOutDemo.java  使用高效缓冲流   BufferedReader
 * 			
 * 	目的地：d:\\SystemInOutDemo.java	使用打印流输出 PrintWriter
 * 
 */
public class PrintWriterDemo02 {
	public static void main(String[] args) throws IOException {
		//1.创建输入流对象
		BufferedReader bReader = new BufferedReader(new FileReader("SystemInOutDemo.java"));
		//2.创建输出流（打印流）对象 启动自动刷新
		PrintWriter pWriter = new PrintWriter(new FileWriter("d:\\SystemInOutDemo.java"),true);
		//3.读写文件
		String line;
		while((line = bReader.readLine())!=null) {
			pWriter.println(line);
		}
		//4.释放资源
		pWriter.close();
		bReader.close();
	}
}
