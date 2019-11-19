package com.io.filereader;
/*
 * 需求：从文件中读取数据并显示到控制台
 * 
 * FileReader：
 * 		FileReader(String filename):传递文件名称
 * 读取文件步骤：
 * 	a.读取输入流对象
 *  b.调用输入流对象的读数据方法
 *  c.释放资源
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader frF = new FileReader("FileReaderDemo.java");//文件必须存在
		int temp = 0;
		while((temp=frF.read())!=-1) {
			System.out.print((char)temp);
		}
		frF.close();
	}

}
