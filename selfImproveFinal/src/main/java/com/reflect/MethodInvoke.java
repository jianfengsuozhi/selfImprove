package com.reflect;

import java.lang.reflect.Method;

/**
 * 方法的调用
 * @author Edward
 *
 */
public class MethodInvoke {
	public static void main(String[] args) {
		try {
			Class<?> class1 = Class.forName("com.reflect.A");
			Object newInstance = class1.newInstance();
			//有参数方法
			Method method = class1.getMethod("calculate", new Class[]{int.class,int.class});
			System.out.println(method.invoke(newInstance, 1,2));
			//无参数方法
			Method method2 = class1.getMethod("getStr", null);
			System.out.println(method2.invoke(newInstance, null));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
