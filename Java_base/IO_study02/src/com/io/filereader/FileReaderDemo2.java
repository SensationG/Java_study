package com.io.filereader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * 
 * 输入流读数据成员方法2：
 * 		一次读一个数组的数据
 */
public class FileReaderDemo2 {
	public static void main(String[] args) throws IOException {
		FileReader fReader = new FileReader("d.txt");
		int len =0;
		char[] ch = new char[5];
		while((len=fReader.read(ch))!=-1) {
			//System.out.println(new String(ch,0,len));//不要使用println 会影响输出换行
			System.out.print(new String(ch,0,len));
		}
		fReader.close();
	}
}
