<%@ page import="java.util.*" 
	pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#select").change(function(){
			var value = $("#select option:selected").val();
			if(value == 1){
				$("#div1").empty();
				$("#div1").append("<input type='text'/>");
			}
			if(value == 2){
				$("#div1").empty();
				$("#div1").append("<input type='text'/>----");
				$("#div1").append("<input type='text'/>");
			}
		});
	});

</script>
</head>
	<body >
			<select id="select">
			  <option value="-1">---请选择---</option>
			  <option value="1">户型</option>
			  <option value="2">面积</option>
			</select>
			<div id="div1">
			</div>
			
	</body>
</html>