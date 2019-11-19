package com.io.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 
 *	分别使用字符流和字节流复制图片
 *	经检验，图片复制无法使用字符流，故使用字节流
 *
 *	二进制文件只能使用字节流进行复制（如何判断二进制文件？使用windows自带记事本打开读不懂的）
 *	文本文件（txt）的复制即可使用字符流，也可以使用字节流
 *	若不知到使用什么流，默认使用字节流
 * 
 */
public class CopyImage {
	public static void main(String[] args) throws IOException {
		//method01();//字符流方法
		method02(); //字节流方法
	}

	private static void method01() throws FileNotFoundException, IOException {
		//1.创建字符输入流对象
		FileReader fReader = new FileReader("hhw1.png");
		//2.创建字符输出流对象
		FileWriter fWriter = new FileWriter("d:\\hhw1.png");
		//3.复制 一次读写一个字符数组方式
		int len;
		char[] ch = new char[1024];
		while((len = fReader.read(ch))!=-1) {
			fWriter.write(ch,0,len);
		}
		//4.释放资源
		fWriter.close();
		fReader.close();
	}
	
	private static void method02() throws IOException {
		//1.创建字节输入流对象
		FileInputStream fisStream = new FileInputStream("hhw1.png");
		//2.创建字节输出流对象
		FileOutputStream fopStream = new FileOutputStream("d:\\hhw1.png");
		//3.复制 一次读写一个字符串
		int len;
		byte[] by = new byte[1024];//1使用字节类型数组
		while((len = fisStream.read(by))!=-1) {
			fopStream.write(by,0,len);
		}
		//4.释放资源
		fopStream.close();
		fisStream.close();
		
	}
}
