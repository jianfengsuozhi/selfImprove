package com.generic;

public class Main {
	public static void main(String[] args) {
		Generics01<String> generics01 = new Generics01<String>();
		System.out.println(generics01.getValue());
		
//		Generics01<Integer> generics012 = new Generics01<>();
		
		System.out.println(generics01.getInteger(1));
		
		Generics01<String> a = new Generics01<String>(){};
	}
}
