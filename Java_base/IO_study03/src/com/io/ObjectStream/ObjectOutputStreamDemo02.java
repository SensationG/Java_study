package com.io.ObjectStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*
 * 
 * 	���������������ȡ��������쳣������
 * 
 */
public class ObjectOutputStreamDemo02 {
	public static void main(String[] args) throws IOException, IOException, ClassNotFoundException {
		//out1(); �����
		//����Ϊ��������������ȡ��
		//1.���������������Ķ���
		ObjectInputStream oisStream = new ObjectInputStream(new FileInputStream("p3.txt"));
		//2.��ȡ����
		Object obj = oisStream.readObject();
		//	����ת�ͣ���ȡ������������  ����֮ǰ����Ǽ��� ���Կ���һ�ζ�ȡ��ȫ
		ArrayList<Student> list2 = (ArrayList<Student>) obj;
		//	����list
		for(Student a:list2) {
			System.out.println(a);
		}
		//3.�ͷ���Դ
		oisStream.close();
	}

	private static void out1() throws IOException, FileNotFoundException {
		//1.��������������Ķ��󣨴��룩
		ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream("p3.txt"));
		//2.�������϶���
		ArrayList<Student> list = new ArrayList<Student>();
		//3.���ѧ������
		list.add(new Student("HHW",23));
		list.add(new Student("lili", 84));
		//4.д�����϶���
		ooStream.writeObject(list); 
		//5.�ͷ���Դ
		ooStream.close();
	}
}
