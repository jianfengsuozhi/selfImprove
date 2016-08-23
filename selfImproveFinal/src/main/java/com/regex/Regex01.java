package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 * @author Edward
 *
 */
public class Regex01 {
	/**
	 *  1) . 任意字符(t.n ten,tin等)
	 *  2) [] 解决.范围过广 限定(a[en]b aen,abn)
	 *  3) | 解决字符单个 多个字符 a(e|n|oo)b aoob
	 */
	 public static void main(String[] args) {
//		 validateDot("//a");
//	     validateDot("a");
		 
//		 validateEmail("704692689qq.com");
		 validatePhone("1111111111");
	}
	 
	 /**
	  * 验证普通点
	  * @param email
	  */
	 public static void validateDot(String email){
		 /**
		  * \\. 表示 .
		  * //. 表示 //a ，//b
		  */
		 String regex = "^\\.$";
		 Pattern pattern = Pattern.compile(regex);
		 Matcher matcher = pattern.matcher(email);
		 if(matcher.matches()){
			 System.out.println("普通点正确");
		 }else{
			 System.out.println("普通点错误");
		 }
	 }	
	 
	 /**
	  * 验证email
	  */
	 public static void validateEmail(String email){
		 // ?有没有(0,1)，+(从1开始)
		 //以字符开头，内容含有@和.
		 String regex = "^[0-9a-zA-Z]+@[0-9a-zA-Z]+\\.[0-9a-zA-Z]+$";
		 Pattern pattern = Pattern.compile(regex);
		 Matcher matcher = pattern.matcher(email);
		 if(matcher.matches()){
			 System.out.println("邮箱格式正确");
		 }else{
			 System.out.println("邮箱格式错误");
		 }
	 }
	 
	 /**
	  * 验证电话长度
	  * @param email
	  */
	 public static void validatePhone(String email){
		 String regex = "^[^0]([0-9]{10})$";
		 Pattern pattern = Pattern.compile(regex);
		 Matcher matcher = pattern.matcher(email);
		 if(matcher.matches()){
			 System.out.println("电话格式正确");
		 }else{
			 System.out.println("电话格式错误");
		 }
	 }
	 


}
