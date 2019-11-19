package com.sxt.io;

import java.io.File;

/*
 * 
 * IOTEST 文件夹的创建
 * 1.mkdir() 确保上级目录存在，不存在创建失败
 * 2.mkdirs() 若不存在自动创建上级目录
 * 3.列出下一级 1. list() 列出下级名称  
 * x			2. listFiles() 列出下级File对象
 * 
 */
public class DirDemo01 {
	public static void main(String[] args) {
		File dir = new File("D:/Javcaworkspace/IO_study/dir");
		boolean flag = dir.mkdir(); //第一种
		System.out.println(flag);
		dir = new File("D:/Javcaworkspace/IO_study/dir/test1");
		flag = dir.mkdirs(); //第二种
		System.out.println(flag);
		
		//列出下一级目录的名称
		File dir3 = new File("D:/Javcaworkspace/IO_study");
		String[] menu = dir3.list();
		for(String s:menu) {
			System.out.println(s);
		}
		//列出下一级对象
		File[] subFiles = dir3.listFiles();
		for(File s:subFiles) {
			System.out.println(s);
		}
	}
}
