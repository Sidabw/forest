<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加部门信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="http://localhost:8080/SSMProject/resource/js/CheckForm.js"></script>
	
<LINK href="http://localhost:8080/SSMProject/resource/css/admin.css" type=text/css
			rel=stylesheet>
	

<script type="text/javascript"
			src="http://localhost:8080/SSMProject/resource/js/CheckForm.js"></script>
		<script type="text/javascript"
			src="http://localhost:8080/SSMProject/resource/js/My97DatePicker/WdatePicker.js"></script>		
	 </head>
  
  <body>


<form action="http://localhost:8080/SSMProject/admin/deptAdd.do" method="post" name="form2" onsubmit="return checkForm('form2');">
<table class=editTable cellSpacing=1 cellPadding=0 width="100%" align=center border=0>
<tr class=editHeaderTr>
<td class=editHeaderTd colSpan=7>  请输入新部门的详细信息
</td>
</tr>  
  <tr>
    <td width="19%" bgcolor="#FFFDF0"><div align="center">部门名称：</div></td>
    <td colspan="3" bgcolor="#FFFFFF"><input type="text"  style=" width: 100%"  maxlength="20"  name="departmentName" check_str="部门名称">
      </td>
    </tr>
  <tr>
    <td bgcolor="#FFFDF0"><div align="center">部门描述：</div></td>
    <td colspan="5" bgcolor="#FFFFFF"><textarea  rows="10" name="departmentDesc"   style="width:100%; resize:none; "s></textarea>
      &nbsp;</td>
    </tr>
  
</table>
<table class=editTable cellSpacing=1 cellPadding=0 width="100%" align=center border=0>
  <tr bgcolor="#ECF3FD">
    		<td width="25%"></td>
					<td width="17%"><input type="submit" name="submit"  value="添加"></td>
					<td width="17%"><input type="reset" name="reset"  value="重置"></td>
					<td width="4%"><input type="button" name="button"  onClick="history.back() "  value="返回"></td>
					<td width="43%"></td>
  </tr>
</table>

</form>
</body>
</html>
