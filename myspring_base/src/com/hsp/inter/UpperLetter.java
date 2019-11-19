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
		// 把小写转成大写
		return str.toUpperCase();

	}

}
