package com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 分析对象的内容
 * @author Edward
 *
 */
public class AnalyzeObject{
	public static void main(String[] args) {
		A a = new A();
		//类名A,方法名setA,字段名 str,字段类型名 String,参数类型名 parametersType,修饰符(多个)
		AnalyzeObject.printFields(a);
		AnalyzeObject.printConstructors(a);
		AnalyzeObject.printMethod(a);
	}
	/**
	 * 打印字段信息
	 * @param obj
	 */
	private static void printFields(Object obj){
		Class<? extends Object> class1 = obj.getClass();
		Field[] fields = class1.getDeclaredFields();
		try {
			for (Field field : fields) {
				//私有可访问
				field.setAccessible(true);
				//获取多个修饰符 
				System.out.print(Modifier.toString(field.getModifiers())+" ");
				
				String typeName = field.getType().getName();
				System.out.print(typeName+" ");
				System.out.print(field.getName()+"=");
				
				System.out.print(field.get(obj));
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 打印构造器
	 * @param obj
	 */
	public static void printConstructors(Object obj){
		Class<? extends Object> class1 = obj.getClass();
		Constructor<?>[] declaredConstructors = class1.getDeclaredConstructors();
		try {
			for (Constructor<?> constructor : declaredConstructors) {
				System.out.print(Modifier.toString(constructor.getModifiers())+" ");
				//A
				System.out.print(class1.getSimpleName()+"(");
				Class<?>[] parameterTypes = constructor.getParameterTypes();
				for (int i = 0; i < parameterTypes.length; i++) {
					Class<?> class2 = parameterTypes[i];
					//File int
					System.out.print(class2.getSimpleName());
					if(i != parameterTypes.length-1){
						System.out.print(",");
					}
				}
				System.out.print(")");
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 打印方法
	 * @param obj
	 */
	public static void printMethod(Object obj){
		Class<? extends Object> class1 = obj.getClass();
		Method[] methods = class1.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			System.out.print(Modifier.toString(method.getModifiers())+" ");
			System.out.print(method.getReturnType().getSimpleName()+" ");
			System.out.print(method.getName()+"(");
			Class<?>[] parameterTypes = method.getParameterTypes();
			for (int j = 0; j < parameterTypes.length; j++) {
				Class<?> class2 = parameterTypes[j];
				//File int
				System.out.print(class2.getSimpleName());
				if(j != parameterTypes.length-1){
					System.out.print(",");
				}
			}
			System.out.println(")");
			
		}
	}
	
}
