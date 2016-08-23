<%@ page import="java.util.*" 
	pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	 	$('#select').change(function(){
	 		var value = $("#select option:selected").val();
	 		if(value == 1){
				$.ajax({
					type:"get",
					url:"/selfImprove/test02a.do",
					dataType:"json",
					success:function(data){
						$("#aim").empty();
						for(var i=0;data.length;i++){
							var team = data[i];
							$("#aim").append("<option value="+team.id+" >"+team.name+"</option>");
						}
					}
				}); 
	 		}
	 		if(value == 2){
				$.ajax({
					type:"get",
					url:"/selfImprove/test02b.do",
					dataType:"json",
					success:function(data){
						$("#aim").empty();
						for(var i=0;data.length;i++){
							var scholarship = data[i];
							$("#aim").append("<option value="+scholarship.mark+" >"+scholarship.name+"</option>");
						}
					}
				}); 
	 		}

	 	});
	});

</script>
</head>
	<body >
			<select id="select">
			    <option value="-1">----请选择---</option>
				<option value="1">课程</option>
				<option value="2">奖学金</option>
			</select>
			<select id="aim"></select>
	</body>
</html>