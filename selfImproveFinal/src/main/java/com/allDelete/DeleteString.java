package com.allDelete;
/**
 * 去除指定字符的字符串
 * @author Edward
 *
 */
public class DeleteString {
	public static void main(String[] args) {
		String str = "abcab";
		str=str.replace("a", "");
		System.out.println(str);
	}

}
