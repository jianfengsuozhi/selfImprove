package com.xml.analyze;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.NodeType;

/**
 * 文本节点与元素节点的分布
 *  元素节点(名：标签名，值：null) 文本节点（名:#text,值:具体值）
 *  	1 元素节点的值:null,文本节点才有值
 *  	2 元素节点的名:标签名,文本节点#text
 *  3 子节点 
 *     文档节点：文档节点的子节点只有一个元素节点如bookstore
 *     元素节点: 个数==1 只有文本节点
 *            个数>1 文本节点与元素节点交替出现如文本节点 元素节点 文本节点
 *     文本节点：文本节点没有子节点
 * @author Edward
 *
 */
public class DomTest01 {
	public static void main(String[] args) throws Exception{
		Document document = DocumentBuilderFactory.newInstance().
			newDocumentBuilder().parse(new File("books.xml"));
//		System.out.println("文档节点的子节点:");
		NodeList childNodes = document.getChildNodes();
		for(int i=0; i<childNodes.getLength(); i++){
			Node item = childNodes.item(i);
			//bookstore,null,元素节点
//			System.out.println(item.getNodeName()+","+item.getNodeValue()+","+DomTest01.getNodeTypeName(item.getNodeType())+"|||");
			NodeList bookstore = item.getChildNodes();
//			System.out.println("bookstore的子节点");
			for(int j=0;j<bookstore.getLength(); j++){
				Node book = bookstore.item(j);
//				System.out.println(book.getNodeName()+","+book.getNodeValue()+","+DomTest01.getNodeTypeName(book.getNodeType())+"|||");
//				System.out.println("book的子节点");
				NodeList childNodes2 = book.getChildNodes();
				for(int k=0;k<childNodes2.getLength();k++){
					Node item2 = childNodes2.item(k);
					System.out.println(item2.getNodeName()+","+item2.getNodeValue()+","+DomTest01.getNodeTypeName(item2.getNodeType())+"|||");
					System.out.print("最后子节点:");
					NodeList childNodes3 = item2.getChildNodes();
					System.out.print(childNodes3.getLength());
					for(int l=0; l<childNodes3.getLength(); l++){
						Node item3 = childNodes3.item(l);
						System.out.println(item3.getNodeName()+","+item3.getNodeValue()+","+DomTest01.getNodeTypeName(item3.getNodeType())+"|||");
					}
					System.out.println();
				}
			}
		}
		
	}
	public static String getNodeTypeName(short nodeType){
		String nodeTypeName = "";
		switch (nodeType) {
		case 1:
			nodeTypeName ="元素节点";
			break;
		case 2:
			nodeTypeName ="属性节点";
			break;
		case 3:
			nodeTypeName ="文本节点";
			break;

		default:
			nodeTypeName = "其他节点";
			break;
		}
		return nodeTypeName;
	}
}
