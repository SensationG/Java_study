package com.sxt.io;

import java.io.File;

/*
 * 
 * IOTEST
    * ���ƻ�·��
 * getName()
 * getPath()
 * getAbsolutePath()
 * getParent()
 * 
 */
public class FileDemo03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File src = new File("D:/Javcaworkspace/IO_study/src/IOtest.png");
		
		System.out.println("���� "+src.getName());
		System.out.println("·�� "+src.getPath());//����·�����ͣ���Ի���ԣ�ȡ����newʱ��·��
		System.out.println("����·�� "+src.getAbsolutePath());
		System.out.println("��·�� "+src.getParent());//ֻ�ǽ�new�����Ƶ���һ���ó������newʱû����һ�㣬�򷵻ؿ�
	}

}
