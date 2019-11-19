package com.sxt.io;

import java.io.File;

/*
 * 
 * 面向对象思想统计文件夹个数 JavaBean思想
 * 
 * 
 */
public class DirCount {
	private long length; //大小
	private String path; //文件夹路径
	private int fileSize; //文件个数
	private int dirSize; //文件夹个数
	private File src; //源
	public DirCount(String path) {
		this.path=path;
		this.src=new File(path);
		COUNT(src);
	}
	
	private  void COUNT(File src) {
		if(src.exists() && null!=src ) //只有是文件才有大小
		{
			if(src.isFile()) {
				length += src.length();
			}
			else  //子孙级
			 { //目录
				for(File s:src.listFiles()) {
				COUNT(s);
				}
			}
		}
	}
	
	public long getLength() {
		return length;
	}

	public void setLength(long length) {
		this.length = length;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public int getDirSize() {
		return dirSize;
	}

	public void setDirSize(int dirSize) {
		this.dirSize = dirSize;
	}

	public File getSrc() {
		return src;
	}

	public void setSrc(File src) {
		this.src = src;
	}

	public static void main(String[] args) {
		DirCount dir = new DirCount("D:/Javcaworkspace/IO_study");
		System.out.println(dir.getLength());
	}
}
