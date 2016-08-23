package com.reflect;

import java.lang.reflect.Field;

/**
 * 声明与未声明的区别
 * @author Edward
 *
 */
public class DeclareFiled {
	public static void main(String[] args) {
		A a = new A();
		Class<? extends Object> class1 = a.getClass();
		//all
		Field[] fields = class1.getDeclaredFields();
		System.out.println(fields.length);//3
		//public 接口
		Field[] fields1 = class1.getFields();
		System.out.println(fields1.length);//0
	}
}
