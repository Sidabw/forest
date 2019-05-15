<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/stu/batchDel.do">
<%-- <form action="${pageContext.request.contextPath }/stu/batchDel.do"> --%>
	<c:forEach items="${list }" var="each" varStatus="i">
	<!-- 已数组形式向后台提交数据时 必须在后台将数组或者集合放到对象中，用对象来接受  -->
		<input type="checkbox" name="ids" value="${each.id }"/>
		<input type="text" name="stus[${i.index }].id" value="${each.id }"/>
		<input type="text" name="stus[${i.index }].name" value="${each.name }"/>
		<input type="text" name="stus[${i.index }].gender" value="${each.gender }"/>
		<input type="text" name="stus[${i.index }].clazz.addr" value="${each.clazz.addr }"/>
		<a href="${pageContext.request.contextPath }/stu/toEdit.do?id=${each.id}">编辑</a>
		<br>
	</c:forEach>
	<input type="submit" value="批量删除"/>
</form>
</body>
</html>