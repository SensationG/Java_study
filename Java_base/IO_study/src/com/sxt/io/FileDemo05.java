package com.sxt.io;

import java.io.File;

/*
 * 
 * 
 * IOTEST 
 *  other 其他信息
 *  length（）：文件字节数 若是文件夹/无此文件 则返回0
 * 
 */
public class FileDemo05 {

	public static void main(String[] args) {
		 File src = new File("D:/Javcaworkspace/IO_study/IOtest.png");//文件
		 System.out.println("长度："+ src.length());
		 File src2 = new File("D:/Javcaworkspace/IO_study/");//文件夹
		 System.out.println("长度："+ src2.length());
		 File src3 = new File("D:/Javcaworkspace/IO_study/IOtes1t.png");//无此文件
		 System.out.println("长度："+ src3.length());
	}

}
