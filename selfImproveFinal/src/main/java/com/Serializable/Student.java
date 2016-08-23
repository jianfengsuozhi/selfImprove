package com.Serializable;

import java.io.Serializable;
/**
 * 实现Serializable接口  <==> 序列化和反序列化
 * 对象<==>二进制
 * @author weideliang
 *
 */
public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
