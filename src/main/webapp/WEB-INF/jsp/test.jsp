<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="../../beautyTemplate1/js/jquery-1.8.2.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/sida/phantomjstest" method="post">
		<input type="text" name="username" id = "uid1"/><br>
	<!-- 	<input type="text" name="username" id = "uid"/><br> -->
		<input type="text" name="tel"/><br>
		<input type="button" id = "but" value ="button" onclick="test();"/>
		请输入日期：<input type="text" name = "timetest"/><br>
		yyyy-MM<br>
        yyyy-MM-dd<br>
        yyyy-MM-dd hh:mm<br>
        yyyy-MM-dd hh:mm:ss<br>
		<input type="submit" name="submit" value="submit"/><br><br><br><br>
		<input type="button" id = "dubboClick" name="dubboClick" value = "dubbo click" onclick="dubboz();"/>
	</form>

</body>
<script type="text/javascript">
	//alert(1);
	function dubboz(){
	  //  alert(1);
        $.ajax({
           url:"/user/logintest",
			type: "POST",
			data: {"userName":"zhangsan","password":"lwsiis"},
           //async:true,
           success:function(data){
               console.log(data);
           }
       });

      $.ajax({
          url:"/user/logintest",
          type:"POST",
          data: {"userName":"zhangsan","password":"lwsiis"},
          // async:true,
           success:function(data){
               console.log(data);
           }
       });
	}
	function test(){
		/* $("#but").attr("value","buttom");
		$("#uid1").attr("name","username1"); */
		$.ajax({
			url:"/jwt/logintest",
			async:true,
			success:function(data){
				console.log(data);
			}
		}); 
	}
	/*  $.ajax({
		url:"/sida/phantomjstest",
		async:true,
		success:function(data){
			var dataArr = new Array();
			dataArr = data.split('#TRS#');
			var temp =JSON.parse(dataArr[1]);
			console.log(temp.gender);
		}
	}); 
	 console.log(1); */
</script>
</html>