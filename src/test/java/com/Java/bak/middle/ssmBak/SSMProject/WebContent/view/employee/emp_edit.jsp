<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="http://localhost:8080/crm/">

		<title>修改员工信息</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<LINK href="http://localhost:8080/crm/resource/css/admin.css" type=text/css
			rel=stylesheet>
			<script type="text/javascript"
			src="http://localhost:8080/crm/resource/js/CheckForm.js"></script>
		<script type="text/javascript"
			src="http://localhost:8080/crm/resource/js/My97DatePicker/WdatePicker.js"></script>
			<script language="JavaScript" type="text/javascript" src="http://localhost:8080/crm/resource/js/FormValid.js"></script>

	</head>

	<body>
		<form action="${pageContext.request.contextPath }/user/userAction_userInfoUpdate.action" method="post" name="form2" onsubmit="return validator(this)" 
>
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						请修改用户的详细信息
 			<input type="hidden" name="user_pw" value="${user.user_pw }"/>	
			<input type="hidden" name="user_num" value="${user.user_num }"/>	
			<input type="hidden" name="is_used" value="${user.is_used }"/>	 
			<input type="hidden" name="user_id" value="${user.user_id }" />
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							姓名：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style="width: 145px" name="user_name"  value="${user.user_name}"
							readonly="readonly">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							年龄：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text"  style="width: 145px" name="user_age" maxlength="2"  valid="required|isNumber"  errmsg="员工年龄不能为空!|请输入正确的年龄!" value="${user.user_age}">
						&nbsp;
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0" style="height: 21px">
						<div align="center">
							性别：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF" style="height: 21px">
						<input type="radio" name="user_sex"
						<c:if test="${user.user_sex=='男' }">checked="checked"</c:if>
							 value="男" />
						男
						<input type="radio" name="user_sex"
						<c:if test="${user.user_sex=='女' }">checked="checked"</c:if>
							 value="女" />
						女
						<br />
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							民族：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text"  style="width: 145px" name="user_nation"
							value="${user.user_nation }">
						&nbsp;
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							学历：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<select name="user_diploma" style="width: 145px">
							<option 
							<c:if test="${user.user_diploma=='初中' }">selected="selected"</c:if>
							>
								初中
							</option>
							<option 
							<c:if test="${user.user_diploma=='高中' }">selected="selected"</c:if>
							>
								高中
							</option>
							<option 
							<c:if test="${user.user_diploma=='本科' }">selected="selected"</c:if>
								 >
								本科
							</option>
							<option 
							<c:if test="${user.user_diploma=='博士' }">selected="selected"</c:if>
							>
								博士
							</option>
							<option 
							<c:if test="${user.user_diploma=='硕士' }">selected="selected"</c:if>
							>
								硕士
							</option>
						</select>
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							婚姻：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<select name="is_married" style="width: 145px">
							<option 
							<c:if test="${user.is_married=='已婚' }">selected="selected"</c:if>	
								selected="selected" >
								已婚
							</option>
							<option 
							<c:if test="${user.is_married=='未婚' }">selected="selected"</c:if>
							>	
								未婚
							</option
							>
							<option 
							<c:if test="${user.is_married=='离异' }">selected="selected"</c:if>
							>
								离异
							</option>
						</select>
						&nbsp;
					</td>
				</tr>


				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							部门：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<select name="department_id" style="width: 145px">
							
							<option value="1"
							<c:if test="${user.dept.department_id=='1' }">selected="selected"</c:if>	
								selected="selected" >财务部</option>
							
							<option value="3"
							<c:if test="${user.dept.department_id=='3' }">selected="selected"</c:if>	
								>销售部</option>
							
						</select>
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							角色：
						</div>
					</td>

					<td colspan="3" bgcolor="#FFFFFF">
						<select name="role_id"  style="width: 145px">

							
							<option value="1"
								<c:if test="${user.role.role_id=='1' }">selected="selected"</c:if>
								 >管理员</option>
							
							<option value="2"
							<c:if test="${user.role.role_id=='2' }">selected="selected"</c:if>
								>员工</option>
							
							<option value="3"
							<c:if test="${user.role_id=='3' }">selected="selected"</c:if>
								>老板</option>
							
						</select>
					</td>

	
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							座机：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text"  style="width: 145px"     valid="isPhone"   errmsg="请输入正确的座机号码!" name="user_tel" value="${user.user_tel }">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							爱好：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text"  style="width: 145px"  maxlength="50"  name="user_intest"
							value="${user.user_intest }">
						&nbsp;
					</td>
				</tr>
			
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							工资卡号：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style="width: 145px"  valid="isNumber"   errmsg="请输入正确的工资卡号!"  maxlength="20"   name="user_bankcard"
							value="${user.user_bankcard }">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							手机：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text"  style="width: 145px" valid="regexp"  regexp="^1[3|4|5|8][0-9]\d{8}$"   errmsg="请输入正确的手机号码!" name="user_mobile"
							value="${user.user_mobile }">
						&nbsp;
					</td>

				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							身份证：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text"  style="width: 145px"  valid="isIdCard"   errmsg="请输入正确的身份证号码!" name="user_idnum" value="${user.user_idnum }">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							添加时间：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text"  style="width: 145px" name="user_addtime"
							disabled="disabled" value="${user.user_addtime }">
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							添加人：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text"  style="width: 145px"  maxlength="10" name="user_addman"
							 value="${user.user_addman }">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							修改人：
						</div>
						<input type="hidden"   value="${user.user_changetime }" name="user_changetime">
					
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" name="userChangeman"
							style="width: 145px"    maxlength="20"value="未修改">
						&nbsp;
					</td>
				</tr>

				<tr>

					<td bgcolor="#FFFDF0">
						<div align="center">
							E_mail：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style="width: 145px"  maxlength="50" name="user_email" value="${user.user_email }">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							地址：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style="width: 145px"  maxlength="50"  name="user_address"
							value="${user.user_address }">
						&nbsp;
					</td>
				</tr>

			</table>
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr bgcolor="#ECF3FD">
					<td width="36%"></td>
					<td width="17%"><input type="submit" name="submit"  value="提交"></td>
					<td width="4%"><input type="button" name="button"  onClick="history.back() "  value="返回"></td>
					<td width="43%"></td>
				</tr>
			</table>

		</form>

	</body>
</html>
