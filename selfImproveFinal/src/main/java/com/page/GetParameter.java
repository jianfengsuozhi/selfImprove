package com.page;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * parameter
 *  存在 有值 值，无值 ""
 *  不存在 null
 * @author Edward
 *
 */
public class GetParameter extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//currentPage=1 1
		//currentPage ""
		//不存在 null
		String currentPage = request.getParameter("currentPage");
		System.out.println(currentPage);
	}
}
