package com.page;
/**
 * 三元表达式 注意点
 * @author Edward
 *
 */
public class SanYunExpresion {
	public static void main(String[] args) {
		int viewPageCount = 2;
		int currentPage = 3;
		int startPage1 = currentPage - 
				(viewPageCount%2==0?(viewPageCount/2 - 1) : viewPageCount/2);//3
		int startPage2 = currentPage - 
				viewPageCount%2==0?(viewPageCount/2 - 1) : viewPageCount/2;//1
	    int startPage3 = (currentPage - 
						viewPageCount%2)==0?(viewPageCount/2 - 1) : viewPageCount/2;//1
		System.out.println("startPage1="+startPage1+",startPage2="+startPage2+",startPage3="+startPage3);
	}

}
