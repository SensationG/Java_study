package com.sxt.io;

import java.io.File;

/*
 * 
 * 1.�ݹ�����ļ� �ݹ飺�����Լ������Լ� �ݹ�ͷ����ʱ�����ݹ� �ݹ��壺�ظ�����
 * x ʹ�õݹ�������ＶĿ¼�ļ�
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
		}else if (src.isDirectory()) { //Ŀ¼
			for(File s:src.listFiles()) {
				printFile(s);
			}
		}
		
	}

}
