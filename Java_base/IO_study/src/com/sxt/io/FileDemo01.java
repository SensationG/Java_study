package com.sxt.io;

import java.io.File;

/*
 *I/O���� 
 * ����File����
 * 
 * 
 */
public class FileDemo01 {

	public static void main(String[] args) {
		String path = "D:/Javcaworkspace/IO_study/src/IOtest.png";
		//1.����File���� ����1 
		File src = new File(path);
		System.out.println(src.length());//�ļ�����
		//2.����File���� ����2
		File src2 = new File("D:/Javcaworkspace/IO_study/src", "IOtest.png");
		System.out.println(src2.length());
		//3.����File���� ����3
		File src3 = new File(new File("D:/Javcaworkspace/IO_study/src"),"IOtest.png");
		System.out.println(src3.length());
	}

}
