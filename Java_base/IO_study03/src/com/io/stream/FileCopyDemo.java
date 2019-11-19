package com.io.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 
 * 	ʹ���ֽ��������ı��ļ�
 * 	����Դ��	bw.txt
 * 	Ŀ�ĵأ� 	d:\\a\\bw.txt
 * 
 */
public class FileCopyDemo {
	public static void main(String[] args) throws IOException {
		//1.�����ֽ�����������
		FileInputStream  fisStream = new FileInputStream("bw2.txt");
		//2.�����ֽ����������
		FileOutputStream fosStream = new FileOutputStream("d:\\a\\bw.txt");
		//3.���� 
		//	1����  һ�ζ�дһ���ֽ�
		//		int by;
		//		while((by = fisStream.read())!=-1) {
		//			fosStream.write(by);
		//		}
		//	2���� һ�ζ�дһ���ַ�����
		int len;
		byte[] by1 = new byte[1024];
		while((len = fisStream.read(by1))!=-1) {
			fosStream.write(by1,0,len);
		}
		//4.�ͷ���Դ
		fosStream.close();
		fisStream.close();
	}
}
