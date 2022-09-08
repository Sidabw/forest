<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/jquery-easyui-1.4.1/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/jquery-easyui-1.4.1/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/egou.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-easyui-1.4.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common.js"></script>

</head>
<body style="background-color: #F3F3F3">

    <div class="easyui-dialog" title="管理员登录" data-options="closable:false,draggable:false" style="width:400px;height:300px;padding:10px;">
		<form action="${pageContext.request.contextPath }/login" method="post" id="myform">
       	<div style="margin-left: 50px;margin-top: 50px;">
       		<div style="margin-bottom:20px;">
	            <div>
	            	用户名: <input name="username" class="easyui-textbox" data-options="required:true" style="width:200px;height:32px" value="admin"/>
	            </div>
	        </div>
	        <div style="margin-bottom:20px">
	            <div>
	            	密&nbsp;&nbsp;码: <input name="password" class="easyui-textbox" type="password" style="width:200px;height:32px" data-options="" value="admin"/>
	            </div>
	        </div>
	        <div>
	            <a id="login"  class="easyui-linkbutton" iconCls="icon-ok" style="width:100px;height:32px;margin-left: 50px">登录</a>
	        </div>
       	</div>
	  </form>  
    </div>
    
    <script type="text/javascript">
    	$("#login").click(function(){
    		// call 'submit' method of form plugin to submit the form    
    		/* $('#myform').form('submit', {    
    		    url:"${pageContext.request.contextPath }/login",    
    		    onSubmit: function(){    
    		        // do some check    
    		        // return false to prevent submit;    
    		    },    
    		    success:function(data){    
    		        alert(data)    
    		    }    
    		}); */
    		
    		//$('#myform').submit();
    		
    		$('#myform').form('submit', {    
    		    url:"${pageContext.request.contextPath }/user/login.do",    
    		    onSubmit: function(){    
    		        // do some check    
    		        // return false to prevent submit;    
    		        /* 	$('#myform').attr('action',"${pageContext.request.contextPath }/user/login.do");
    		        	alert("提交");
    		    		$('#myform').submit(); */
    		    },    
    		    success:function(data){  
    		    	if(data=='true'){
	    		    	window.location.href = "${pageContext.request.contextPath }/jsp/index.jsp";
    		    	}else{
    		    		window.location.href = "${pageContext.request.contextPath }/jsp/login.jsp";
    		    	}
    		        /* alert(data) 
    		        if(data=='true'){
    		        	// submit the form   
    		        	$('#myform').attr('action',"${pageContext.request.contextPath }/login");
    		        	alert("提交");
    		    		$('#myform').submit();
    		        }
    		        else return; */
    		    }    
    		});
    		
    		
    		// $("#myform").submit();
    		/* alert("ok");
    		var username = $("[name=username]").val();
    		var password = $("[name=password]").val();
    		
    		if(username!="admin" || password!="admin"){
    			$.messager.alert('错误',"用户名密码不正确！");
    			return ;
    		}
    		
    		window.location.href="${pageContext.request.contextPath }/jsp/index.jsp"; */
    	});
    </script>
</body>
</html>