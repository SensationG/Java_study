package com.sxt.io;

import java.io.File;

/*
 * 
 * w 文件状态获取
 * IOTEST
 * 
 * 
 * 
 */
public class FileDemo04 {

	public static void main(String[] args) {
		//文件状态 1.不存在 2.存在 （文件isFile） 文件夹（isDirectory）
		File src = new File("IOtest.png");
		System.out.println("是否存在 "+src.exists());
		System.out.println("是否文件 "+src.isFile());
		System.out.println("是否文件夹 "+src.isDirectory());
		
		File src2 = new File("D:/Javcaworkspace/IO_study");
		System.out.println("是否存在 "+src2.exists());
		System.out.println("是否文件 "+src2.isFile());
		System.out.println("是否文件夹 "+src2.isDirectory());
		
		//文件状态判断模板
		src = new File("xxx");
		if(null == src || !src.exists()) {
			System.out.println("文件不存在");
		}
		else {
			if(src.isFile()){
				System.out.println("文件操作");
			}
			else {
				System.out.println("文件夹操作");
			}
		}
		
	}

}
