<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加角色</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<LINK href="http://localhost:8080/SSMProject/resource/css/admin.css" type=text/css	rel=stylesheet>
 <script type="text/javascript"
			src="http://localhost:8080/SSMProject/resource/js/CheckForm.js"></script>
		<script type="text/javascript"
			src="http://localhost:8080/SSMProject/resource/js/My97DatePicker/WdatePicker.js"></script>
 <script type="text/javascript">
	function query(){  
			window.location="http://localhost:8080/SSMProject/servlet/RoleQueryServlet";
		}

</script>

  </head>
  
  <body>
    <form action="http://localhost:8080/SSMProject/admin/roleAdd.do" method="post"name="form2" onsubmit="return checkForm('form2');">
<table class=editTable cellSpacing=1 cellPadding=0 width="100%" align=center border=0>
<tr class=editHeaderTr>
<td class=editHeaderTd colSpan=7>  请输入新角色的详细信息
</td>
</tr>  
  <tr>
    <td width="19%" bgcolor="#FFFDF0"><div align="center">角色名称：</div></td>
    <td colspan="3" bgcolor="#FFFFFF"><input type="text"  maxlength="20"  check_str="角色名称" style="width: 138px" name="roleName" >
      &nbsp;</td>
    </tr>
  <tr>
    
      
      <td bgcolor="#FFFDF0">
						<div align="center">
							角色等级：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<select name="rolePower" style="width: 138px">
							<option  value="1">
								一星
							</option>
							<option  value="2">
								二星
							</option>
							<option  value="3">
								三星
							</option>
						</select>
						&nbsp;
					</td>
    </tr>
 
</table>
<table class=editTable cellSpacing=1 cellPadding=0 width="100%" align=center border=0>
  <tr bgcolor="#ECF3FD">
    <td width="10%">&nbsp;</td>
    <td width="12%"><input type="submit" name="Submit" value="提交" onclick="count()" ></td>
    <td width="65%"><input type="button" value="查看已有角色"    onclick="query()" ></td>
  </tr>
</table>

</form>
  </body>
</html>
