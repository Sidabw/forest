<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "<span style="font-family:'Courier New';color:#3f7f5f;font-size: 10.5pt; mso-spacerun: 'yes';">
<a target="_blank" href="http://www.w3.org/TR/html4/loose.dtd">http://www.w3.org/TR/html4/loose.dtd</a>
</span>
">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Client</title>

<script type="text/javascript"
	src="${pageContext.request.contextPath }/dwr/util.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath }/dwr/engine.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath }/dwr/interface/SendMsg.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.9.1.js"></script>
	
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/notice_pop.js"></script>

<script type="text/javascript">
	$(function() {

		dwr.engine.setActiveReverseAjax(true);

	});

	/*
	 * 后台推送消息调用函数
	 */

	function show(msg) {

		//$("#message").text(msg);
		alert("CCCCCCCCCCCCCCCCCCCCCC"+msg);
		pop_init("公告信息","<ul><li>"+msg+"</li><li>sss</li></ul>");  
	    $('#pop_div').fadeIn(400);  

	}
</script>

</head>

<body>

	<h1>消息接收端</h1>

	<div id="message"
		style="width: 300px; height: 100px; border: 1px solid #CDCDCD; text-align: left; padding: 5px;"></div>

</body>

</html>
