package com.xml.analyze;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.lang.ObjectUtils.Null;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParseService extends DefaultHandler{
	private List<Entity> entitys = null;
	private Entity entity = null;
	private String preTag = null;
	
	/**
	 * 获取实体集
	 * @param stream
	 * @return
	 * @throws Exception
	 * @throws SAXException
	 */
	public List<Entity> getEntitys(InputStream stream) throws Exception, SAXException{
		SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
		SaxParseService saxParseService = new SaxParseService();
		//开始调用
		saxParser.parse(stream, saxParseService);
		return saxParseService.getEntitys();
	}
	public List<Entity> getEntitys() {
		return entitys;
	}
	
	//读入<?xml version="1.0" encoding="UTF-8"?>调用
	@Override
	public void startDocument() throws SAXException {
		System.out.println("文档解析开始");
		entitys = new ArrayList<Entity>();
	}
	
	//遇到<book>(开始标签) 调用
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		//uri 空,localName 空,qName 元素节点名 
		if("book".equals(qName)){
			entity = new Entity();
		}
		preTag = qName;
		//属性名与属性值
		for (int i = 0; i < attributes.getLength(); i++) {
			String attribute = attributes.getQName(i);
			String value = attributes.getValue(i);
			if("id".equals(attribute)){
				entity.setId(value);
			}
			if("name".equals(attribute)){
				entity.setName(value);
			}
			if("language".equals(attribute)){
				entity.setLanguage(value);
			}
		}
		
	}
	//文本节点调用
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
//		System.out.println(new String(ch, start, length)+"-----");
		if(preTag != null){
			String content = new String(ch, start, length);
			if("name".equals(preTag)){
				entity.setName(content);
			}else if("author".equals(preTag)){
				entity.setAuthor(content);
			}else if("year".equals(preTag)){
				entity.setYear(content);
			}else if("price".equals(preTag)){
				entity.setPrice(content);
			}else if("language".equals(preTag)){
				entity.setLanguage(content);
			}
		}
	}
	//</name>(结束标签)调用
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		
		if("book".equals(qName)){
			entitys.add(entity);
			entity = null;
		}
		preTag = null;
	}
	//解析根元素之后调用
	@Override
	public void endDocument() throws SAXException {
		System.out.println("文档解析结束");
	}
	

}
