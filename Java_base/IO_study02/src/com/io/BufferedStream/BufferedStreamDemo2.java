package com.io.BufferedStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 缓冲流的特殊功能
 * BufferedWriter
 * 		void newLine(); 写一个换行符，这个换行符由系统决定 （前面有提到3种系统换行符都不同）
 * BufferedReader
 * 		String readLine(); 一次读取一行数据，但是不读取换行符
 * 
 */
public class BufferedStreamDemo2 {

	public static void main(String[] args) throws IOException {
		/*BufferedWriter bWriter = new BufferedWriter(new FileWriter("bw2.txt"));
		for(int i=0;i<10;i++) {
			bWriter.write("hello "+i);
			bWriter.newLine(); //使用newLine替代\r\n换行
			bWriter.flush();
		}
		bWriter.close();
		*/
		BufferedReader bReader = new BufferedReader(new FileReader("d.txt"));
		String line;
		while((line=bReader.readLine())!=null) {
			System.out.println(line); //readLine不读取换行，故手动换行
		}
		bReader.close();
		
	}

}
