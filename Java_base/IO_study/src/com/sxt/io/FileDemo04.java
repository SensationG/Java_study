package com.sxt.io;

import java.io.File;

/*
 * 
 * w �ļ�״̬��ȡ
 * IOTEST
 * 
 * 
 * 
 */
public class FileDemo04 {

	public static void main(String[] args) {
		//�ļ�״̬ 1.������ 2.���� ���ļ�isFile�� �ļ��У�isDirectory��
		File src = new File("IOtest.png");
		System.out.println("�Ƿ���� "+src.exists());
		System.out.println("�Ƿ��ļ� "+src.isFile());
		System.out.println("�Ƿ��ļ��� "+src.isDirectory());
		
		File src2 = new File("D:/Javcaworkspace/IO_study");
		System.out.println("�Ƿ���� "+src2.exists());
		System.out.println("�Ƿ��ļ� "+src2.isFile());
		System.out.println("�Ƿ��ļ��� "+src2.isDirectory());
		
		//�ļ�״̬�ж�ģ��
		src = new File("xxx");
		if(null == src || !src.exists()) {
			System.out.println("�ļ�������");
		}
		else {
			if(src.isFile()){
				System.out.println("�ļ�����");
			}
			else {
				System.out.println("�ļ��в���");
			}
		}
		
	}

}
