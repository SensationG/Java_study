package com.io.filewrite;

import java.io.FileWriter;
import java.io.IOException;

/*
  *    需求：往文件中写数据
  *    写数据-输出流--FileWriter
 *  FileWriter:
 *  	FileWriter(String fileName):传递一个文件名称
 *  
 *  ex：输出流写数据的步骤：
 *  	A：创建输出流对象
 *  	B：调用输出流对象的写数据的方法
 *  	C：释放资源
 */
public class FileWriterDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//1.创建输出流对象
		FileWriter fW = new FileWriter("d:/a.txt");
		/*
		 * 创建输出流对象做了哪些事？
		 * A：调用系统资源创建了一个文件
		 * B：创建输出流对象
		 * C：把输出流对象指向文件
		 */
		//2.调用输出流对象的写数据方法 写一个字符串数据
		fW.write("Io流你好！！");
		//3.数据没有直接写到文件，其实写到了内存缓冲区 需要刷新
		fW.flush();
		//4.释放资源
		fW.close();
	}

}
