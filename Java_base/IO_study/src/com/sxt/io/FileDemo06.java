package com.sxt.io;

import java.io.File;
import java.io.IOException;

/*
 * 
 * IOTEST
 * CREATE NEW FILE
 * DELETE 
 * 
 */
public class FileDemo06 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 File src = new File("D:/Javcaworkspace/IO_study/IO.txt");//�ļ�
		 if(src.createNewFile())
		 {
			 System.out.println("success");
		 }
		 else {
			System.out.println("false");
		}
		//ɾ���ļ�
		 if(src.delete())
		 {
			 System.out.println("delete ture");
		 }else {
			System.out.println("delete false");
		}
	}

}
