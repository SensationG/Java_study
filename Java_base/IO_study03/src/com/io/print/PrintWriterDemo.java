package com.io.print;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * PrintWriter
 * 	��ӡ�������й��ܣ�
 * 			�Զ�����:println
 * 			�Զ�ˢ��
 * 	ע�⣺����FileWriter����ʱ��boolean�������Ƿ�׷��
 * 		��������ӡ�������boolean���Ͳ������Ƿ��Զ�ˢ��
 */
public class PrintWriterDemo {
	public static void main(String[] args) throws IOException {
		//testprintln(); �Զ����з�������
		//�������Զ�ˢ�²���
		PrintWriter pWriter = new PrintWriter(new FileWriter("p2.txt"),true);
		
		pWriter.println("hello");
		pWriter.println("hhw");
		pWriter.println("good");
		
		//pWriter.close(); //�ͷ���Դ���Զ�ˢ�� ��Ҫ����Ƿ��Զ�ˢ�� ��ע��
		
	}

	private static void testprintln() throws FileNotFoundException {
		//1.������ӡ������
		PrintWriter pWriter = new PrintWriter("p1.txt");
		//2.д��
		pWriter.println("hello");
		pWriter.println("hhw");
		pWriter.println("good");
		//3.�ͷ���Դ
		pWriter.close();
	}
}
