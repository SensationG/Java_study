package com.io.filewriterandreader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * -文件复制 一次读写一个字符
 * 
   *  需求：
 * 	把项目路径下的FileWriterDemo.java中的内容复制到项目路径下的Copy.java中
 * 
 * 数据源：
 * 		FileWriterDemo.java --读数据--FileReader
 * 目的地：
 * 		Copy.java--写数据---FileWriter
 */
public class CopyFileDemo {
	public static void main(String[] args) throws IOException {
		FileReader fReader = new FileReader("src/com/io/filewrite/FileWriterDemo.java");
		FileWriter fWriter = new FileWriter("Copy.txt");
		int temp = 0;
		while((temp=fReader.read())!=-1) {
			fWriter.write(temp);
		}
		fReader.close();
		fWriter.close();
	}

}
