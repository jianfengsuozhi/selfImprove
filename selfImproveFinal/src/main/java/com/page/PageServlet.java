package com.page;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.dao.Test;
import com.common.dao.TestDao;

public class PageServlet extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String currentPage = request.getParameter("page");
		if(currentPage == null){
			currentPage = "1";
		}
		int cp = Integer.parseInt(currentPage);
		TestDao testDao = new TestDao();

		try {
			Integer count = testDao.count();
			Page<Test> page = new Page<Test>(count, cp);
			List<Test> list = new TestDao().onePageInfo(page.getStart(), page.getEnd());
			page.setList(list);
			PageModel<Test> pageModel = new PageModel<Test>(PageModel.TEXT_MODEL, "b.page", page);
			request.setAttribute("pageObject", pageModel);
			request.getRequestDispatcher("/page/page.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
