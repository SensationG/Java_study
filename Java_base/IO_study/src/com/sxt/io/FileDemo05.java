package com.sxt.io;

import java.io.File;

/*
 * 
 * 
 * IOTEST 
 *  other ������Ϣ
 *  length�������ļ��ֽ��� �����ļ���/�޴��ļ� �򷵻�0
 * 
 */
public class FileDemo05 {

	public static void main(String[] args) {
		 File src = new File("D:/Javcaworkspace/IO_study/IOtest.png");//�ļ�
		 System.out.println("���ȣ�"+ src.length());
		 File src2 = new File("D:/Javcaworkspace/IO_study/");//�ļ���
		 System.out.println("���ȣ�"+ src2.length());
		 File src3 = new File("D:/Javcaworkspace/IO_study/IOtes1t.png");//�޴��ļ�
		 System.out.println("���ȣ�"+ src3.length());
	}

}
