package com.sxt.io;

import java.io.File;

/*
 * 
 * IO
 * *ͳ���ļ��д�С �õݹ�
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
		if(src.exists() && null!=src ) //ֻ�����ļ����д�С
		{
			if(src.isFile()) {
				length += src.length();
			}
			else  //���Ｖ
			 { //Ŀ¼
				for(File s:src.listFiles()) {
				COUNT(s);
				}
			}
		}
	}
}
