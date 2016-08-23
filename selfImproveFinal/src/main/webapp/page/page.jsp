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
    <title>分页技术</title>
  </head>
  <body>
  <table border="1"  width="50%">
  <tr><th>ID</th><th>姓名</th></tr>
  <c:forEach items="${pageObject.page.list}" var="test" >
  		<tr>
  			<td>${test.id }</td><!-- 调用getId()方法 -->
  			<td>${test.name }</td>
  		</tr>
  </c:forEach>
  </table>
  ${ pageObject.pageModel}
  </body>
</html>
