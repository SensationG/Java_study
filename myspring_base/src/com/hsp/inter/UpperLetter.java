package com.hsp.inter;

public class UpperLetter implements ChangeLetter {
	public String str;
	
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public String change() {
		// ��Сдת�ɴ�д
		return str.toUpperCase();

	}

}
