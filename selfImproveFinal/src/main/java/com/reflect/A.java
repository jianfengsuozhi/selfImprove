package com.reflect;

import java.io.File;

public class A {
	private static String str="123";
	private File file=null;
	private int a = 1;
	public A() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public A(File file, int a) {
		super();
		this.file = file;
		this.a = a;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	/**
	 * 求和
	 * @param a
	 * @param b
	 * @return
	 */
	public int calculate(int a,int b){
		return a + b;
	}
}
