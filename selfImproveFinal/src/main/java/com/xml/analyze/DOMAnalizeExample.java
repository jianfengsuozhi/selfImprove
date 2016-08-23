package com.xml.analyze;

import java.io.File;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Dom 解析xml  jdk自带
 * @author Edward
 *
 */
public class DOMAnalizeExample {
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory documentBuilderFactory = 
				DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = 
				documentBuilderFactory.newDocumentBuilder();
		FilePath filePath = new FilePath();
		InputStream file = filePath.getFile("books.xml");
		Document document = documentBuilder.parse(file);
		NodeList books = document.getElementsByTagName("book");
		for(int i=0; i<books.getLength(); i++){
			Node node = books.item(i);
			NamedNodeMap attributes = node.getAttributes();
			for(int j=0; j<attributes.getLength(); j++){
				Node attribute = attributes.item(j);
				System.out.println("属性值:"+attribute.getNodeName()+","+attribute.getNodeValue());
			}
			NodeList childNodes = node.getChildNodes();
			for (int j = 0; j < childNodes.getLength(); j++) {
				Node item = childNodes.item(j);
				if(item.getNodeType() == Node.ELEMENT_NODE){
					System.out.println(item.getNodeName()+" "+item.getTextContent());
				}
			}
			System.out.println();
		}
		
	}
}
