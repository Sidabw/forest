<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	This is my First Hello JSp<br>
	${name}<br>
	${Uname }<br>
	${sessionUname }<br>
	${applicationUname }<br>
	${HttpServletRuqestFromServletActionContext }<br>
	${HttpServletRequestFromServletRequestAware }<br>
	
	<c:forEach items="${listUser }" var="each">
		<tr>
			<td>${each.id }</td>
			<td>${each.uname }</td>
			<td>${each.realname }</td>
			<td>${each.pwd }</td>
			<td>${each.tel }</td>
			<td>${each.power }</td>
		</tr>
		<br>
	</c:forEach>	 
		
</body>
</html>