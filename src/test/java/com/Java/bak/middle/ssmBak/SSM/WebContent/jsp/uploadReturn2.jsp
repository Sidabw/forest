<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-1.9.1.js"></script>
</head>
<body>
      <p >指定文件名jia： <input type="text" id="tempp" name="filename" value= "123456"/></p >  
	<form id= "uploadForm">  
      <p >上传文件： <input type="file" name="picFile"/></ p>  
      <input type="button" value="上传" onclick="doUpload()" />  
	</form>
</body>
<script type="text/javascript">
	function doUpload() {
		var dataa=document.getElementById("tempp");
		alert(dataa);
		var formData = new FormData($("#uploadForm")[0]);
		formData.
		$.ajax({
			url : '/SSM/stu2/uploadTest.do',
			type : 'POST',
			data : [{formData},],
			async : false,
			cache : false,
			contentType : false,
			processData : false,
			success : function(returndata) {
				alert(returndata);
				document.getElementById("testt").innerHTML="<img src='/SSM/img/111.png'/>";
			},
			error : function(returndata) {
				alert(returndata);
			}
		});
	}
</script>
</html>