<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "<span style="font-family:'Courier New';color:#3f7f5f;font-size: 10.5pt; mso-spacerun: 'yes';">
<a target="_blank" href="http://www.w3.org/TR/html4/loose.dtd">http://www.w3.org/TR/html4/loose.dtd</a>
</span>
">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Manager</title>

<script type="text/javascript" src="${pageContext.request.contextPath }/dwr/util.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath }/dwr/engine.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath }/dwr/interface/SendMsg.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.9.1.js"></script>

<script type="text/javascript">
	$(function() {

		dwr.engine.setActiveReverseAjax(true);

		$("#send").click(function() {
			SendMsg.sendMsg($("#msg").val());
		});

	});
</script>

</head>

<body>

	<h1>消息发送端</h1>

	向客户端发送消息：

	<input type="text" name="msg" id="msg" />

	<input type="button" value="发送" id="send" />

</body>

</html>
