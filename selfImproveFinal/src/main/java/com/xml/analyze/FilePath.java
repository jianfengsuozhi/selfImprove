package com.xml.analyze;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

/**
 * 获取rescources下的内容
 * @author Edward
 *
 */
public class FilePath {
	public static void main(String[] args) throws IOException {
//		FilePath filePath = new FilePath();
//		String file = filePath.getFile("books.xml");
//		System.out.println(file);
	}
	public  InputStream getFile(String fileName) throws IOException{
		ClassLoader classLoader = this.getClass().getClassLoader();
		//文件内容
		InputStream resourceAsStream = classLoader.getResourceAsStream(fileName);
		System.out.println(classLoader.getResource(fileName).getPath());
		return resourceAsStream;
	}

}
