package com.sxt.io;

import java.io.File;

/*
 * 
 * I/O����
 * path��ʽ
 * 
 */
public class PathDemo01 {
	public static void main(String[] args) {
		String path="D:/Javcaworkspace/IO_study/src/IOtest.png";//ͼƬ·��
		System.out.println(File.separatorChar);
		//����·�����뷽ʽ
		//1.ʹ�� / ƴ��
		path = "D:/Javcaworkspace/IO_study/src/IOtest.png";
		//2.����ƴ�� �����File.separator����һ�� /
		path = "D:"+File.separator+"Javcaworkspace";
	}
}
