package com.sxt.io;

import java.io.File;

/*
 * 
 * IO
 * *统计文件夹大小 用递归
 * 
 */
public class DirDemo05 {
	private static long length = 0;
	public static void main(String[] args) {
		File src = new File("D:/Javcaworkspace/IO_study");
		COUNT(src);	
		System.out.println(length);
	}
	private static void COUNT(File src) {
		if(src.exists() && null!=src ) //只有是文件才有大小
		{
			if(src.isFile()) {
				length += src.length();
			}
			else  //子孙级
			 { //目录
				for(File s:src.listFiles()) {
				COUNT(s);
				}
			}
		}
	}
}
