<%@ page import="java.util.*" 
	pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@taglib
     uri="http://java.sun.com/jsp/jstl/core"
     prefix="c"
 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table,tr,td{
	border:black solid 1px;
	height:35px;
	text-align:center;
	margin:0px;
	width:40px;
}
table{
	border-collapse:collapse;
	width:100px;
	margin:50px auto 0 auto;
}
</style>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
$(document).ready(function(){
 	$('#checkAll').click(function(){
 		if(this.checked == true){
 			$("input:checkbox").each(function(){
 				 this.checked = true;
 				}
 			);
 		}else{
 			$("input:checkbox").each(function(){
				 this.checked = false;
				}
			);
 		}
 	});
 	
 	$("#delete").click(function(){
 		var checkNum = $("input:checkbox:checked").length;
 		if(checkNum == 0){
 			alert("请至少选择一项");
			return;
 		}
 		
 		var list = "";
 		$("input:checkbox:checked").each(function(){
 			list = list + $(this).val()+",";
 		});
		$.ajax({
			type:"post",
			url:"/selfImprove/delete.delete",
			data:"ids="+list,  
			success:function(data){
			/* 	$("input:checkbox:checked").attr("checked", false);  */
				window.location.reload(); 
			}
		}); 
 	});
});

</script>
</head>
	<body >
	    	<table>
	    	   <tr >
	    	      <td >
	    	        <input type="checkbox" id="checkAll" value="-1"/>
	    	      </td>
	    	      <td >数字</td>
	    	   </tr>
	    	   <c:forEach items="${list}" var="item">
	    	   <tr >
	    	      <td >
	    	        <input type="checkbox" value="${item.id}"/>
	    	      </td>
	    	      <td >${item.name }</td>
	    	   </tr>
	    	   </c:forEach>
	    	</table>
	    	<input id="delete"  type="button" value="删除"/>
	</body>
</html>