package com.xml.analyze;

import java.io.InputStream;
import java.util.List;

import org.xml.sax.SAXException;

import junit.framework.TestCase;

/**
 * SAX 解析xml jdk 自带
 * sax 按顺序解析
 * @author Edward
 *
 */
public class SAXAnlizeExample extends TestCase{
	
	public void testSAX(){
		SaxParseService saxParseService = new SaxParseService();
		//src 文件下的books.xml
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("books.xml");
		List<Entity> list;
		try {
			list = saxParseService.getEntitys(inputStream);
			for (Entity entity : list) {
				System.out.println(entity.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
