package com.page;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
/**
 * 404 不存在
 * a.page 404：请求是否正确，tomcat是否加载此项目，web.xml的问题
 * a.jsp 404 ：地址所对应的页面是否存在
 * @author Edward
 *
 */
public class Status404  extends HttpServlet{
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String currentPage = request.getParameter("currentPage");
		
		request.getRequestDispatcher("a.jsp").forward(request, response);
	}
}
