<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="description" content="此代码内容为超萌的猫头鹰登录界面" />
<title>超萌的猫头鹰登录界面</title>

<link rel="stylesheet" href="../../css/jq22.css"  th:href="@{/css/jq22.css}"  />
</head>
<body>
<!-- begin -->
<div id="login">
    <div class="wrapper">
        <div class="login">
            <form action="#" method="post" class="container offset1 loginform">
                <div id="owl-login">
                    <div class="hand"></div>
                    <div class="hand hand-r"></div>
                    <div class="arms">
                        <div class="arm"></div>
                        <div class="arm arm-r"></div>
                    </div>
                </div>
                <div class="pad">
                    <input type="hidden" name="_csrf" value="9IAtUxV2CatyxHiK2LxzOsT6wtBE6h8BpzOmk="/>
                    <div class="control-group">
                        <div class="controls">
                            <label for="userName" class="control-label fa fa-envelope"></label>
                            <input id="userName" type="text" name="email" placeholder="Email" tabindex="1" autofocus="autofocus" class="form-control input-medium" />
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <label for="password" class="control-label fa fa-asterisk"></label>
                            <input id="password" type="password" name="password" placeholder="Password" tabindex="2" class="form-control input-medium" />
                        </div>
                    </div>
                </div>
                <div class="form-actions"><a href="#" tabindex="5" class="btn pull-left btn-link text-muted">Forgot password?</a><a href="#" tabindex="6" class="btn btn-link text-muted">Sign Up</a>
                    <button type="button" id="doLogin" tabindex="4" class="btn btn-primary">Login</button>
                </div>
            </form>
        </div>
    </div>
    <script src="../../js/jquery.min.js" th:src="@{/js/jquery.min.js}"></script>
    <script>
    $(function() {
        $('#login #password').focus(function() {
            $('#owl-login').addClass('password');
        }).blur(function() {
            $('#owl-login').removeClass('password');
        });

        //简单登录操作
        $("#doLogin").click(function (e) {
            $.ajax({
                type : "POST",
                url : "/user/loginTest",
                data : {
                    "userName" : $("#userName").val(),
                    "password" : $("#password").val()
                },
                dataType : "json",
                success : function(data) {
                	alert(1);
                    if (data.result == "1") {
                    	alert(2);
                        window.location.href ="/user/test";
                    } else {
                        alert("账号密码不能为空！");
                    }
                }
            });
        });
    });
    </script>
</div>
<!-- end -->
</body>
</html>