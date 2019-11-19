package com.io.print;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * 
 * 	ʹ�ô�ӡ�������ı��ļ�
 * 
 * 	����Դ�� SystemInOutDemo.java  ʹ�ø�Ч������   BufferedReader
 * 			
 * 	Ŀ�ĵأ�d:\\SystemInOutDemo.java	ʹ�ô�ӡ����� PrintWriter
 * 
 */
public class PrintWriterDemo02 {
	public static void main(String[] args) throws IOException {
		//1.��������������
		BufferedReader bReader = new BufferedReader(new FileReader("SystemInOutDemo.java"));
		//2.�������������ӡ�������� �����Զ�ˢ��
		PrintWriter pWriter = new PrintWriter(new FileWriter("d:\\SystemInOutDemo.java"),true);
		//3.��д�ļ�
		String line;
		while((line = bReader.readLine())!=null) {
			pWriter.println(line);
		}
		//4.�ͷ���Դ
		pWriter.close();
		bReader.close();
	}
}
