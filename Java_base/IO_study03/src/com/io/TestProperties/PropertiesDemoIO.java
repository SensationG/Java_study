package com.io.TestProperties;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Set;

/*
 * 
 * 	Properties �� IO����ϵĹ��ܣ�
 * 				void list(PrintWriter out) 
 * 				void load(Reader reader) 
 * 				void store(OutputStream out, String comments) 
 */
public class PropertiesDemoIO {
	public static void main(String[] args) throws IOException {
		//method1();//void list(PrintWriter out) 
		//method2();//void load(Reader reader) 
		//void store(OutputStream out, String comments)  ������
		//1.���������б�
		Properties pp = new Properties();
		//2.���ӳ���ϵ
		pp.setProperty("zb201", "zhanghuang");
		pp.setProperty("zb202", "yuhang");
		pp.setProperty("zb203", "sunce");
		//3.�������������
		FileWriter fWriter = new FileWriter("e.txt");
		//4.void store(OutputStream out, String comments) 
		pp.store(fWriter, "HEllo");
		//5.�ͷ���Դ
		fWriter.close();
	}

	private static void method2() throws FileNotFoundException, IOException {
		//void load(Reader reader)  ������
		//1.���������б����
		Properties pp2 = new Properties();
		//2.����һ������������
		BufferedReader br = new BufferedReader(new FileReader("d.txt"));
		//3.��ȡ���� load����
		pp2.load(br);
		//4.��������
		Set<Object> s1 = pp2.keySet();
		for(Object s:s1) {
			System.out.println(pp2.get(s)+" "+s);
		}
		//5.�ͷ���Դ
		br.close();
	}

	private static void method1() throws FileNotFoundException {
		//1.���������б����
		Properties pp = new Properties();
		//2.���ӳ���ϵ
		pp.setProperty("zb201", "zhanghuang");
		pp.setProperty("zb202", "yuhang");
		pp.setProperty("zb203", "sunce");
		//3.������ӡ������
		PrintWriter pWriter = new PrintWriter("d.txt");
		//4.void list����
		pp.list(pWriter);//����������������ļ�
		//5.�ͷ���Դ
		pWriter.close();
	}
}
