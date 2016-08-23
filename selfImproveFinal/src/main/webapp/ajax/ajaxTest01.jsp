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
	 	$('#button').click(function(){
			$.ajax({
				type:"get",
				url:"/selfImprove/test01.do",
				dataType:"json",
				success:function(data){
					for(var i=0;data.length;i++){
						var city = data[i];
						alert(city.id);
					}
				}
			}); 
	 	});
	});

</script>
</head>
	<body >
			<button  id="button">点击ajax事件</button>
	</body>
</html>