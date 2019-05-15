<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 	my json jsp
 	<!-- 访问servlet除了要继承HttpServlet 还要在web.xml内配置 
 		 除此之外，在eclipse中url上要加入${pageContext.request.contextPath}
 	 -->
 	<form action="${pageContext.request.contextPath}/JsonDemo">
 		<input type="submit" value="submit"/>
 	</form>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.9.1.js"></script>
<script type="text/javascript">
	$(function(){
		var jsonData='{"id":1,"name":"sida","tel":"234567"}';
		$.ajax({
			url:"${pageContext.request.contextPath}/JsonDemo",
			data:jsonData,
			type:"post",
			dataType:"json",
			success:function(data){
				alert(data.name);
			}
		});
	});
</script>
</html>