package com.sxt.io;

import java.io.File;

/*
 * 
 * 	IOtest
 *  	相对路径/绝对路径
 * 
 */
public class FileDemo02 {
	public static void main(String[] args) {
		String path ="D:/Javcaworkspace/IO_study/src/IOtest.png";
		
		//绝对路径 存在盘符
		File src1 = new File(path);
		System.out.println(src1.getAbsolutePath());
		
		//相对路径 相对于当前工程
		File src2 = new File("IOtest.png");
		System.out.println(src1.getAbsolutePath());
	}
}
