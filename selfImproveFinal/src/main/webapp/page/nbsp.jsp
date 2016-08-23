<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>¿Õ¸ñ</title>
  </head>
  <body>
  <div>
        <a>&nbsp;1&nbsp;</a><br>
  		<a>&nbsp;&nbsp;1&nbsp;</a>
  </div>
   <div>
    <a href="">1</a>&nbsp;&nbsp;
    <a href="">2</a>
   </div>
  </body>
</html>
