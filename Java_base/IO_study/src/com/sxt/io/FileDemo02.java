package com.sxt.io;

import java.io.File;

/*
 * 
 * 	IOtest
 *  	���·��/����·��
 * 
 */
public class FileDemo02 {
	public static void main(String[] args) {
		String path ="D:/Javcaworkspace/IO_study/src/IOtest.png";
		
		//����·�� �����̷�
		File src1 = new File(path);
		System.out.println(src1.getAbsolutePath());
		
		//���·�� ����ڵ�ǰ����
		File src2 = new File("IOtest.png");
		System.out.println(src1.getAbsolutePath());
	}
}
