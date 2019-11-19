package com.sxt.io;

import java.io.File;

/*
 * 
 * 1.递归查找文件 递归：方法自己调用自己 递归头：何时结束递归 递归体：重复调用
 * x 使用递归查找子孙级目录文件
 * 
 */
public class DirDemo03 {

	public static void main(String[] args) {
		File src = new File("D:/Javcaworkspace/IO_study");
		printFile(src);	
	}
	private static void printFile(File src) {
		
		System.out.println(src.getName());
		if(!src.exists() || null==src )
		{
			return;
		}else if (src.isDirectory()) { //目录
			for(File s:src.listFiles()) {
				printFile(s);
			}
		}
		
	}

}
