package com.io.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 
 *	�ֱ�ʹ���ַ������ֽ�������ͼƬ
 *	�����飬ͼƬ�����޷�ʹ���ַ�������ʹ���ֽ���
 *
 *	�������ļ�ֻ��ʹ���ֽ������и��ƣ�����ж϶������ļ���ʹ��windows�Դ����±��򿪶������ģ�
 *	�ı��ļ���txt���ĸ��Ƽ���ʹ���ַ�����Ҳ����ʹ���ֽ���
 *	����֪��ʹ��ʲô����Ĭ��ʹ���ֽ���
 * 
 */
public class CopyImage {
	public static void main(String[] args) throws IOException {
		//method01();//�ַ�������
		method02(); //�ֽ�������
	}

	private static void method01() throws FileNotFoundException, IOException {
		//1.�����ַ�����������
		FileReader fReader = new FileReader("hhw1.png");
		//2.�����ַ����������
		FileWriter fWriter = new FileWriter("d:\\hhw1.png");
		//3.���� һ�ζ�дһ���ַ����鷽ʽ
		int len;
		char[] ch = new char[1024];
		while((len = fReader.read(ch))!=-1) {
			fWriter.write(ch,0,len);
		}
		//4.�ͷ���Դ
		fWriter.close();
		fReader.close();
	}
	
	private static void method02() throws IOException {
		//1.�����ֽ�����������
		FileInputStream fisStream = new FileInputStream("hhw1.png");
		//2.�����ֽ����������
		FileOutputStream fopStream = new FileOutputStream("d:\\hhw1.png");
		//3.���� һ�ζ�дһ���ַ���
		int len;
		byte[] by = new byte[1024];//1ʹ���ֽ���������
		while((len = fisStream.read(by))!=-1) {
			fopStream.write(by,0,len);
		}
		//4.�ͷ���Դ
		fopStream.close();
		fisStream.close();
		
	}
}
