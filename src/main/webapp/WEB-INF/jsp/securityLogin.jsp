<%--
  Created by IntelliJ IDEA.
  User: think
  Date: 2018/8/21
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>sidabw</title>
</head>
<body>
<div class="loginPanel">
    <form method="post" action="login">
        <table>
            <tr>
                <td colspan="2" align="center" style="font-weight:bold">会员登录</td>
            </tr>
            <tr>
                <td>名称：</td>
                <td><input type="text" name="username"/></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><span class="error">${error}</span></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="登入"></td>
            </tr>
            <tr>
                <td align="center"><a href="registerPage">注册</a></td>
                <td align="center"><a href="forgotPage">忘记密码？</a></td>
            </tr>
        </table>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</div>
<div>
    <h1>sidabw</h1>
    <ul>
        <li>1</li>
        <li>2</li>
        <li>3</li>
    </ul>
</div>
</body>
</html>
