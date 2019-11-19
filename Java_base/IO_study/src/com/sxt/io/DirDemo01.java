package com.sxt.io;

import java.io.File;

/*
 * 
 * IOTEST �ļ��еĴ���
 * 1.mkdir() ȷ���ϼ�Ŀ¼���ڣ������ڴ���ʧ��
 * 2.mkdirs() ���������Զ������ϼ�Ŀ¼
 * 3.�г���һ�� 1. list() �г��¼�����  
 * x			2. listFiles() �г��¼�File����
 * 
 */
public class DirDemo01 {
	public static void main(String[] args) {
		File dir = new File("D:/Javcaworkspace/IO_study/dir");
		boolean flag = dir.mkdir(); //��һ��
		System.out.println(flag);
		dir = new File("D:/Javcaworkspace/IO_study/dir/test1");
		flag = dir.mkdirs(); //�ڶ���
		System.out.println(flag);
		
		//�г���һ��Ŀ¼������
		File dir3 = new File("D:/Javcaworkspace/IO_study");
		String[] menu = dir3.list();
		for(String s:menu) {
			System.out.println(s);
		}
		//�г���һ������
		File[] subFiles = dir3.listFiles();
		for(File s:subFiles) {
			System.out.println(s);
		}
	}
}
