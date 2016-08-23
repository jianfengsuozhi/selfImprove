package com.ajax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
/**
 * 局部刷新
 * @author Edward
 *
 */
public class Ajax01  extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
        String str = uri.substring(
       		 uri.lastIndexOf("/"), 
       		 uri.lastIndexOf("."));
        response.setContentType("text/html;charset=utf-8");
        if(str.equals("/object")){
        	//总结 都是fromObject  JsonArray(数组,集合) JsonObject(对象,map)
        	
        	//对象转化为json
//        	Team team = new Team("1","英语");
//        	JSONObject fromObject = JSONObject.fromObject(team);
//        	System.out.println(fromObject); //报错 jar缺少  {"id":"1","name":"英语"}
        	
        	//map转化为json对象
//        	Map<String,Object> map = new HashMap<>();
//        	map.put("id", 1);
//        	map.put("name", "魏德亮");
//        	JSONObject fromObject = JSONObject.fromObject(map);
//        	System.out.println(fromObject);
        	//{"name":"魏德亮","id":1}
        	
        	//数组转化为json
//        	String[] arr = {"arr1","arr2","arr3"};
//        	JSONArray jsonArray = JSONArray.fromObject(arr);
//        	System.out.println(jsonArray); 
//        	//["arr1","arr2","arr3"]
        	
        	//list转化为json
//        	List<Team> teamList = new ArrayList<>();
//        	teamList.add(new Team("1", "英语1"));
//        	teamList.add(new Team("2", "英语2"));
//        	teamList.add(new Team("3", "英语3"));
//        	JSONArray fromObject = JSONArray.fromObject(teamList);
//        	System.out.println(fromObject);
//        	 //[{"id":"1","name":"英语1"},{"id":"2","name":"英语2"},{"id":"3","name":"英语3"}]
        }else if(str.equals("/test01")){
        	List<Team> list = new ArrayList<>();
        	list.add(new Team("1","英语"));
        	list.add(new Team("2", "语文"));
        	list.add(new Team("3", "数学"));
        	JSONArray fromObject = JSONArray.fromObject(list);
        	response.getWriter().write(fromObject.toString());
        }else if(str.equals("/test02a")){
        	List<Team> list = new ArrayList<>();
        	list.add(new Team("1","英语"));
        	list.add(new Team("2", "语文"));
        	list.add(new Team("3", "数学"));
        	JSONArray fromObject = JSONArray.fromObject(list);
        	response.getWriter().write(fromObject.toString());
        }else if(str.equals("/test02b")){
        	List<Scholarship> list = new ArrayList<>();
        	list.add(new Scholarship(80, "一等奖学金"));
        	list.add(new Scholarship(60, "二等奖学金"));
        	list.add(new Scholarship(55, "三等奖学金"));
        	JSONArray fromObject = JSONArray.fromObject(list);
        	response.getWriter().write(fromObject.toString());
        	
         }
	}

}
