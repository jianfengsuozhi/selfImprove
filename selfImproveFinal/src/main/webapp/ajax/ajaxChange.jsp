<%@ page import="java.util.*" 
	pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#select").change(function(){
			$("#select1").append("<option >课程</option>");
		});
	});

</script>
</head>
	<body >
			<h1 id="h1"></h1>
			<select id="select">
			  <option >课程</option>
			  <option>奖学金</option>
			  <option></option>
			</select>
			<select id="select1"></select>
	</body>
</html>