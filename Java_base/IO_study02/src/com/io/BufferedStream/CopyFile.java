package com.io.BufferedStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 使用缓冲流复制文件
 * 
 * 需求：把项目路径下的FileWriterDemo.java中的内容复制到项目路径下的Copy3.java中
 * 
 * 数据源：FileWriterDemo.java -- 读数据 --高效读数据方式（BufferedReader）
 * 
 * 目的地：Copy3.java -- 写数据 -- 高效写数据方式（BufferedWriter）
 * 
 */
public class CopyFile {

	public static void main(String[] args) throws IOException {
		//数据源
		BufferedReader bReader = new BufferedReader(new FileReader("src/com/io/filewrite/FileWriterDemo.java"));
		//目的地
		BufferedWriter bWriter = new BufferedWriter(new FileWriter("Copy3"));
		//方式一 ：一次读取一个字符
		/*int temp;
		while((temp=bReader.read())!=-1){
			bWriter.write(temp);
		}
	
		*/
		//方式二：一次读取一个数组
		char[] ch = new char[1024];
		int len;
		while((len=bReader.read(ch))!=-1) {
			bWriter.write(ch,0,len);
		}
		bReader.close();
		bWriter.close();
	}

}
