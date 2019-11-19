package com.sxt.io;

import java.io.File;

/*
 * 
 * IOTEST
    * 名称或路径
 * getName()
 * getPath()
 * getAbsolutePath()
 * getParent()
 * 
 */
public class FileDemo03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File src = new File("D:/Javcaworkspace/IO_study/src/IOtest.png");
		
		System.out.println("名称 "+src.getName());
		System.out.println("路径 "+src.getPath());//返回路径类型（相对或绝对）取决于new时的路径
		System.out.println("绝对路径 "+src.getAbsolutePath());
		System.out.println("父路径 "+src.getParent());//只是将new中名称的上一层拿出，如果new时没有上一层，则返回空
	}

}
