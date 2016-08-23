package com.Serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 对象读写成功：实现Serializable接口 文件serialVersionUID==类serialVersionUID
 * 
 * @author weideliang
 *
 */
public class SerializableTest {
	public static final String filePath = "E:\\selfWorkspace\\selfImprove\\src\\main\\resources\\test.txt";
	public static void main(String[] args) throws Exception {
//		Student student = new Student();
//		student.setName("魏得良");
//		SerializableTest test = new SerializableTest();
//		test.save(student);
		
		SerializableTest.read(filePath);
	}
	
	public static void save(Student student) throws Exception{
		FileOutputStream fs = new FileOutputStream(filePath);
		ObjectOutputStream oos = new ObjectOutputStream(fs);
		oos.writeObject(student);
		oos.flush();
		oos.close();
		System.out.println("写入结束");
	}
	
	public static void read(String fileName)throws Exception{
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Student student = (Student)ois.readObject();
		System.out.println(student.getName());
		ois.close();
	}
}
