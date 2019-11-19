package com.sxt.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/*
 * 
 * d IO基本操作步骤 标准步骤
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * 
 * 
 */
public class IOTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.创建源
		File src = new File("abc.txt");
		//2.选择流
		InputStream is = null;
		try {
			is = new FileInputStream(src);
			//3.操作（读取）标准化
			int temp = 0;
			while((temp = is.read())!=-1)// 当数据不为末尾时 while读取数据
			{
				System.out.println((char)temp);//读取全部数据
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//4.释放资源
			if(null!=is) { // 确保有资源才关 没用到不关
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
