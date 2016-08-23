package com.xml.analyze;
/**
 * 设置快捷键
 * 1 setters/getters  ctrl + shift + s
 * 2 运行 ctrl+r
 * 3 展开(extend) alt+e  
 * 4 收缩 （callapse） alt+c
 * 5 内容协助 esc
 * 6 extract local name esc
 * 关闭快捷键
 * 1 ctrl + shift + L
 * @author Edward
 *
 */
public class KeysSettings {
	public static void main(String[] args) {
		System.out.println(1);
	}
	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
