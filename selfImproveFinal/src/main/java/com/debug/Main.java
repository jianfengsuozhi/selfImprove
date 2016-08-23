package com.debug;
public class Main {
	public static void main(String[] args) throws Exception {
		int a = 1;
		int b = 2;
		a++;
		f1(20);
		System.out.println(a);
		a++;
		System.out.println(b);
	}
	
	public static void f1(int count) throws Exception{
		System.out.println(count);
		int c = 3;
		int d1 = c+2;
		if(count % 2==0){
			throw new Exception("错误");
		}
		int d = 4;
		System.out.println(c);
		System.out.println(d);
	}

}
