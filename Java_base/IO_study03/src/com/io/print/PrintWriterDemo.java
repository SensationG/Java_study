package com.io.print;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * PrintWriter
 * 	打印流的特有功能：
 * 			自动换行:println
 * 			自动刷新
 * 	注意：创建FileWriter对象时的boolean参是是是否追加
 * 		而创建打印流对象的boolean类型参数是是否自动刷新
 */
public class PrintWriterDemo {
	public static void main(String[] args) throws IOException {
		//testprintln(); 自动换行方法测试
		//以下是自动刷新测试
		PrintWriter pWriter = new PrintWriter(new FileWriter("p2.txt"),true);
		
		pWriter.println("hello");
		pWriter.println("hhw");
		pWriter.println("good");
		
		//pWriter.close(); //释放资源会自动刷新 故要检测是否自动刷新 需注释
		
	}

	private static void testprintln() throws FileNotFoundException {
		//1.创建打印流对象
		PrintWriter pWriter = new PrintWriter("p1.txt");
		//2.写入
		pWriter.println("hello");
		pWriter.println("hhw");
		pWriter.println("good");
		//3.释放资源
		pWriter.close();
	}
}
