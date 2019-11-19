package com.sxt.io;

import java.io.File;

/*
 * 
 * I/O测试
 * path格式
 * 
 */
public class PathDemo01 {
	public static void main(String[] args) {
		String path="D:/Javcaworkspace/IO_study/src/IOtest.png";//图片路径
		System.out.println(File.separatorChar);
		//两种路径输入方式
		//1.使用 / 拼接
		path = "D:/Javcaworkspace/IO_study/src/IOtest.png";
		//2.常量拼接 这里的File.separator代表一个 /
		path = "D:"+File.separator+"Javcaworkspace";
	}
}
