<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/SSM/js/jquery-1.9.1.js"></script>
</head>
<body>
	<script type="text/javascript">
		$(function(){
			//var jsonData="{'id':1,'name':'Sida','tel':'23456789'}";
			var jsonData='{"id":1,"name":"sida","tel":"456789"}';
			$.ajax({
				url:"${pageContext.request.contextPath}/stu2/jsonTest.do",
				contentType:"application/json;charset=utf-8",
				data:jsonData,
				type:"post",
				dataType:"json",
				success:function(data){
					alert(data.name);
					alert(data.list[1]);
				}
			});
		});
	</script>
</body>
</html>