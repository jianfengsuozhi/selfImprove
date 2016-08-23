package com.xml.analyze;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/**
 * 标签:<language></language>
 * document根据标签名得到节点集合
 * (如bookstore,book,name)
 * 优点：结构清晰 
 * 缺点：内存消耗大
 * @author Edward
 *
 */
public class DomTest02 {
	public static void main(String[] args)throws Exception {
		Document document = DocumentBuilderFactory.newInstance().
				newDocumentBuilder().parse(new File("books.xml"));
		NodeList bookstores = document.getElementsByTagName("bookstore");
		for (int i = 0; i < bookstores.getLength(); i++) {
			Node item = bookstores.item(i);
			System.out.println(item.getNodeName());
		}
		
		NodeList books = document.getElementsByTagName("book");
		for (int i = 0; i < books.getLength(); i++) {
			Node book = books.item(i);
			System.out.println(book.getNodeName());
		}
		
		NodeList names = document.getElementsByTagName("name");
		for(int i=0;i<names.getLength();i++){
			Node name = names.item(i);
			System.out.println(name.getNodeName());
		}
	}

}
