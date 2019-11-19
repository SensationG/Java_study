package com.sxt.io;

import java.io.File;

/*
 * 
 * �������˼��ͳ���ļ��и��� JavaBean˼��
 * 
 * 
 */
public class DirCount {
	private long length; //��С
	private String path; //�ļ���·��
	private int fileSize; //�ļ�����
	private int dirSize; //�ļ��и���
	private File src; //Դ
	public DirCount(String path) {
		this.path=path;
		this.src=new File(path);
		COUNT(src);
	}
	
	private  void COUNT(File src) {
		if(src.exists() && null!=src ) //ֻ�����ļ����д�С
		{
			if(src.isFile()) {
				length += src.length();
			}
			else  //���Ｖ
			 { //Ŀ¼
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
