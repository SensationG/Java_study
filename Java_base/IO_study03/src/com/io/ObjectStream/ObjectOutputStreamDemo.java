package com.io.ObjectStream;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * 	����������� �������ڶ�д�������͵Ķ���
 * 		ObjectOutputStream �����
 * 		ObjectInputStream ������
 * 
 * 	ע�⣺	
 * 		1. ʹ�ö���������������ֻ��ʹ�ö�����������ȡ����
 * 		2.ֻ��֧��java.io.Serializable�ӿڵĶ������д������
 */
public class ObjectOutputStreamDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//out1();//�����
		//����Ϊ������
		//1.���������������Ķ���
		ObjectInputStream ojStream = new ObjectInputStream(new FileInputStream("o1.txt"));
		//2.��ȡ����
//		Object obj = ojStream.readObject();
//		System.out.println(obj);
//		
//		Object obj2 = ojStream.readObject();
//		System.out.println(obj2);
//		
//		Object obj3 = ojStream.readObject();
//		System.out.println(obj3);
		try {
			while(true) {
				Object obj = ojStream.readObject();
				System.out.println(obj);
			}
		} catch (EOFException e) {
			System.out.println("�ļ�ĩβ");
		}

		//3.�ͷ���Դ
		ojStream.close();
	}

	private static void out1() throws FileNotFoundException, IOException {
		//1.��������������Ķ���
		FileOutputStream fosStream = new FileOutputStream("o1.txt");
		ObjectOutputStream ooStream = new ObjectOutputStream(fosStream);
		//2.����ѧ������
		Student s1 = new Student("hhw", 29);
		Student s2 = new Student("ymd", 20);
		//3.д��ѧ������
		ooStream.writeObject(s1);//д��ѧ������������ʵ�����л��ӿ�
		ooStream.writeObject(s2);
		//4.�ͷ���Դ
		ooStream.close();
		fosStream.close();
	}
}
