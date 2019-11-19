package com.io.filewrite;

import java.io.FileWriter;
import java.io.IOException;

/*
 * a.实现数据的换行
 * 		\n可以实现换行，但是windows系统自带记事本打开没有换行，因为windows识别的是\r\n
 * b.实现数据的追加写入
 * 		FileWriter(String fileName, boolean append) 
 * 
 */
public class FileWriterDemo3 {

	public static void main(String[] args) throws IOException {
		//FileWriter fW = new FileWriter("c.txt");
		
		FileWriter fW = new FileWriter("c.txt",true);//表追加写入 默认false 
		for(int i=0;i<10;i++) {
			fW.write("hello "+i);
			fW.write("\r\n");
		}
		fW.close();
	}

}
