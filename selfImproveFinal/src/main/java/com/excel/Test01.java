package com.excel;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.Buffer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test01 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
        String str = uri.substring(
       		 uri.lastIndexOf("/"), 
       		 uri.lastIndexOf("."));
        if(str.equals("/export")){
        	System.out.println("导出成功");
        	ImportExcel.importE();
        	this.download("F://mark.xls", response);
        }
	}
	
	public void download(String path,HttpServletResponse response) throws IOException{
		//文件到流(读 input) 流到文件(写 output) (相对于流)
		File file = new File(path);
		String filename = file.getName();
		InputStream inStream = new BufferedInputStream(new FileInputStream(file));
		byte[] buffer = new byte[inStream.available()];
		inStream.read(buffer);
		inStream.close();
		
		response.reset();
		response.addHeader("Content-Disposition", "attachment;filename="  
                + new String(filename.getBytes()));
		response.addHeader("Content-Length", "" + file.length());
		
		OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		toClient.write(buffer);
		toClient.flush();
		toClient.close();
		System.out.println("下载成功");
	}

}
