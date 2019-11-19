package com.io.BufferedStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 使用缓冲流特殊功能复制文件
 * 
 * 需求：把项目路径下的Copy.txt中的内容复制到项目路径下的Copy4.java中
 * 
 * 数据源：Copy.txt -- 读数据 --高效读数据方式（BufferedReader）
 * 
 * 目的地：Copy4.java -- 写数据 -- 高效写数据方式（BufferedWriter）
 */
public class CopyFile2 {

	public static void main(String[] args) throws IOException {
		//1.创建输入缓冲流对象
		BufferedReader bReader = new BufferedReader(new FileReader("Copy.txt"));
		//2.创建输出缓冲流对象
		BufferedWriter bWriter = new BufferedWriter(new FileWriter("Copy4.java"));
		//3.readLine并newLine
		String temp;
		while((temp=bReader.readLine())!=null) {
			bWriter.write(temp);
			bWriter.newLine();
			bWriter.flush();
		}
		//4.释放资源
		bWriter.close();
		bReader.close();
	}

}
