package com.xml.analyze;

import java.io.File;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.helpers.AttributesImpl;

/**
 * sax生成xml文件
 * @author Edward
 *
 */
public class SAXGenerateExample {
	public static void main(String[] args)throws Exception {
		SAXTransformerFactory saxTransformerFactory = 
				(SAXTransformerFactory)SAXTransformerFactory.newInstance();
		TransformerHandler handler = saxTransformerFactory.newTransformerHandler();
		//创建src/main/rescources 使用绝对路径
		StreamResult streamResult = new StreamResult(new File("F:\\improve workspace\\self\\src\\main\\resources\\createSAX.xml"));
		handler.setResult(streamResult);
		//从源树到目标树
		Transformer transformer = handler.getTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");//设置字符编码
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");//设置是否缩进
		handler.startDocument();
		AttributesImpl attrs = new AttributesImpl();
		handler.startElement("", "", "bookstore", attrs);
		//设置属性
		attrs.clear();
		attrs.addAttribute("", "", "id", "", "1");
		handler.startElement("", "", "book1", attrs);
		attrs.clear();
		
		handler.startElement("", "", "name", attrs);
		//设置文本节点值
		handler.characters("book1".toCharArray(), 0, "book1".length());
		handler.endElement("", "", "name");
		handler.startElement("", "", "author", attrs);
		handler.characters("魏德亮".toCharArray(), 0, "魏德亮".length());
		handler.endElement("", "", "author");
		handler.startElement("", "", "year", attrs);
		handler.characters("2014".toCharArray(), 0, "2014".length());
		handler.endElement("", "", "year");
		handler.startElement("", "", "price", attrs);
		handler.characters("89".toCharArray(), 0, "89".length());
		handler.endElement("", "", "price");
		
		handler.endElement("", "", "book1");
		
		attrs.clear();
		attrs.addAttribute("", "", "id", "", "2");
		handler.startElement("", "", "book2", attrs);
		attrs.clear();
		
		handler.startElement("", "", "name", attrs);
		handler.characters("book2".toCharArray(), 0, "book2".length());
		handler.endElement("", "", "name");
		handler.startElement("", "", "author", attrs);
		handler.characters("2004".toCharArray(), 0, "2004".length());
		handler.endElement("", "", "author");
		handler.startElement("", "", "year", attrs);
		handler.characters("77".toCharArray(), 0, "77".length());
		handler.endElement("", "", "year");
		handler.startElement("", "", "price", attrs);
		handler.characters("English".toCharArray(), 0, "English".length());
		handler.endElement("", "", "price");
		
		handler.endElement("", "", "book2");
		handler.endElement("", "", "bookstore");
		handler.endDocument();
		System.out.println("使用sax创建结束");
	}

}
