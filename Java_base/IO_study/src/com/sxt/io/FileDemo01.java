package com.sxt.io;

import java.io.File;

/*
 *I/O测试 
 * 构建File对象
 * 
 * 
 */
public class FileDemo01 {

	public static void main(String[] args) {
		String path = "D:/Javcaworkspace/IO_study/src/IOtest.png";
		//1.构建File对象 方法1 
		File src = new File(path);
		System.out.println(src.length());//文件长度
		//2.构建File对象 方法2
		File src2 = new File("D:/Javcaworkspace/IO_study/src", "IOtest.png");
		System.out.println(src2.length());
		//3.构建File对象 方法3
		File src3 = new File(new File("D:/Javcaworkspace/IO_study/src"),"IOtest.png");
		System.out.println(src3.length());
	}

}
