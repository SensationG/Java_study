package com.io.print;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * 
 * 	��ӡ����
 * 	
 * 		PrintWriter
 * 	�ص㣺
 * 		1.�����Զ�����println 
 * 		2.��������ֽڣ�����ʱ�������������������
 * 		3.ͨ��ĳЩ���ã�����ʵ���Զ�ˢ�£�ֻ���ڵ���println��printf��format�����ã�
 * 		4.Ҳ�ǰ�װ�������߱�д������
 * 		5.���԰��ֽ������ת�����ַ������
 * 	
 * 	ע�⣺��ӡ��ֻ����� ��������
 * 
 */
public class PrintStream {

	public static void main(String[] args) throws IOException {
		//1.������ӡ������
		PrintWriter pWriter = new PrintWriter("b.txt");
		
		//2.д������
		pWriter.write("hello");
		pWriter.write("hhw");
		pWriter.write("yes");
		
		//3.�ͷ���Դ
		pWriter.close();
	}

}
