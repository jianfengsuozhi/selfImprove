package com.allDelete;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.dao.Test;
import com.common.dao.TestDao;

public class Test01 extends HttpServlet{
	public  void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
        String str = uri.substring(
       		 uri.lastIndexOf("/"), 
       		 uri.lastIndexOf("."));
        if(str.equals("/delete")){
        	String ids = request.getParameter("ids");
        	String[] split = ids.split(",");
        	TestDao testDao = null;
        	for (String item : split) {
        		testDao = new TestDao();
        		try {
					testDao.deleteTest(item);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
//       	response.sendRedirect("list.delete");
        }else if(str.equals("/list")){
        	TestDao testDao = new TestDao();
        	List<Test> list = null;
        	try {
				list = testDao.list();
				request.setAttribute("list", list);
				//  /allDelete/allDelete.jsp 一层 
				request.getRequestDispatcher("/allDelete/allDelete.jsp").
	                 forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
        	
        }
	}
}
