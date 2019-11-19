package com.io.print;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * 
 * 	打印流：
 * 	
 * 		PrintWriter
 * 	特点：
 * 		1.可以自动换行println 
 * 		2.不能输出字节，到那时可以输出其他任意类型
 * 		3.通过某些配置，可以实现自动刷新（只有在调用println，printf或format才有用）
 * 		4.也是包装流，不具备写出功能
 * 		5.可以把字节输出流转换成字符输出流
 * 	
 * 	注意：打印流只能输出 不能输入
 * 
 */
public class PrintStream {

	public static void main(String[] args) throws IOException {
		//1.创建打印流对象
		PrintWriter pWriter = new PrintWriter("b.txt");
		
		//2.写出数据
		pWriter.write("hello");
		pWriter.write("hhw");
		pWriter.write("yes");
		
		//3.释放资源
		pWriter.close();
	}

}
