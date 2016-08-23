package com.xml.analyze;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
/**
 * Dom 生成xml文件
 * 注意顺序如document最开始创建,最后一个添加子节点
 * @author Edward
 *
 */
public class DOMXmlGenerateExample {
	public static void main(String[] args)throws Exception {
		List<Entity> list = new ArrayList<Entity>();
		list.add(new Entity("1","book1", "魏德亮", "2014", "89"));
		list.add(new Entity("2","book2", "2004", "77", "English"));
		
		Document document = 
				DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		Element bookstore = document.createElement("bookstore");
		for(int i=0; i<2; i++){
			Entity entity = list.get(i);
			Element book = document.createElement("book"+(i+1));
			book.setAttribute("id", entity.getId());
			Element name = document.createElement("name");
			name.setTextContent(entity.getName());
			Element author = document.createElement("author");
			author.setTextContent(entity.getAuthor());
			Element year = document.createElement("year");
			year.setTextContent(entity.getYear());
			Element price = document.createElement("price");
			price.setTextContent(entity.getPrice());
			book.appendChild(name);
			book.appendChild(author);
			book.appendChild(year);
			book.appendChild(price);
			bookstore.appendChild(book);
		}
		document.appendChild(bookstore);
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		DOMSource domSource = new DOMSource(document);
		StreamResult result = new StreamResult(new File("F:\\improve workspace\\self\\src\\main\\resources\\createDomxml.xml"));
		transformer.transform(domSource, result);
		
	}
}
