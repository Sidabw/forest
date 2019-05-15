<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/stu/edit.do" method="post">
		<input type="text" name="id" value="${stu.id }"/><br>
		<input type="text" name="name" value="哈哈哈哈哈"/><br>
		<input type="text" name="gender" value="${stu.gender }"/><br>
		<input type="text" name="clazz.addr" value="${stu.clazz.addr }"/><br>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>