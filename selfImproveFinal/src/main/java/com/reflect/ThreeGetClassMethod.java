package com.reflect;
/**
 * 三种生成类的方法和获取对象
 * @author Edward
 *
 */
public class ThreeGetClassMethod {
	public static void main(String[] args) throws Exception {
		//Class,类名,对象
		Class<?> class1 = Class.forName("java.lang.String");
		
		Class class2 = String.class;
		
		String str = "aa";
		Class<? extends String> class3 = str.getClass();
		
		System.out.println(class1.getName());//java.lang.String
		System.out.println(class2);//class java.lang.String
		System.out.println(class3.equals(class2));//true
		
		//创建对象
		String newInstance = class3.newInstance();
	}

}
