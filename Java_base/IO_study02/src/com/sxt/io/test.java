package com.sxt.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class test {
	public static void main(String[] args) {
		File src = new File("abc.txt");
		InputStream iS = null;
		try {
			iS = new FileInputStream(src);
			int temp = 0;
			while((temp = iS.read())!=-1) {
				System.out.println((char)temp);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(null!=iS) {
			try {
				iS.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
