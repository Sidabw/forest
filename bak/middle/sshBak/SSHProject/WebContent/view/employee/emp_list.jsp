<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>查询员工信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {font-size: 12px}
.STYLE3 {font-size: 12px; font-weight: bold; }
.STYLE4 {
	color: #03515d;
	font-size: 12px;
}

	a{
	text-decoration: none;
	color: #033d61;
	font-size: 12px;
}

A:hover {
	COLOR: #f60; TEXT-DECORATION: underline
}

-->
</style>

<script>
var  highlightcolor='#c1ebff';
//此处clickcolor只能用win系统颜色代码才能成功,如果用#xxxxxx的代码就不行,还没搞清楚为什么:(
var  clickcolor='#51b2f6';
function  changeto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=highlightcolor;
}
}

function  changeback(){
if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
return
if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
//source.style.backgroundColor=originalcolor
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}

function  clickto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=clickcolor&&source.id!="nc")
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=clickcolor;
}
else
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}
</script>

  </head>
  
  <body>
  
  
  	<form  action="${pageContext.request.contextPath }/user/userAction_findAllUser.action" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	  <tr>
    <td height="30" background="${pageContext.request.contextPath }/resource/images/tab_05.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="30"><img src="${pageContext.request.contextPath }/resource/images/tab_03.gif" width="12" height="30" /></td>
                <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="STYLE4" align="center">&nbsp;&nbsp;请输入查询内容：<input type="text" id="queryContent" name="queryVO.queryContent" style="width: 290px"/></td>
            <td class="STYLE4">&nbsp;&nbsp;请选择查询方式：<select name="queryVO.queryWay" id="queryWay" style="width: 100px">
            <!-- 确保在条件查询的基础下，分页浏览数据时queryWay的值的不变性 -->
      					<option  value="1"  <c:if test="${queryVO.queryWay=='1' }">selected</c:if>>员工姓名</option>
     				 	<option  value="2"  <c:if test="${queryVO.queryWay=='2' }">selected</c:if>>部门名称</option>
     				 	<option  value="3"  <c:if test="${queryVO.queryWay=='3' }">selected</c:if>> 角色名称</option>
     				 	<option  value="4"  <c:if test="${queryVO.queryWay=='4' }">selected</c:if>> 员工学历</option>
   				 </select>            
   				</td>
            <td class="STYLE4">&nbsp;&nbsp;<input  type="submit" value="查询" style="width:50px"/></td>            
          </tr>
        </table></td>
        <td width="16"><img src="${pageContext.request.contextPath }/resource/images/tab_07.gif" width="16" height="30" /></td>
      </tr>
    </table></td>
  </tr>


  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="8" background="${pageContext.request.contextPath }/resource/images/tab_12.gif">&nbsp;</td>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
          <tr>
            <td height="22" background="${pageContext.request.contextPath }/resource/images/bg2.gif" bgcolor="#FFFFFF" style="width: 3%"><div align="center"><span class="STYLE1">序号</span></div></td>
            <td height="22" background="${pageContext.request.contextPath }/resource/images/bg2.gif" bgcolor="#FFFFFF" style="width: 5%"><div align="center"><span class="STYLE1">姓名</span></div></td>
            <td height="22" background="${pageContext.request.contextPath }/resource/images/bg2.gif" bgcolor="#FFFFFF" style="width: 3%"><div align="center"><span class="STYLE1">性别</span></div></td>
            <td height="22" background="${pageContext.request.contextPath }/resource/images/bg2.gif" bgcolor="#FFFFFF" style="width:3%"><div align="center"><span class="STYLE1">年龄</span></div></td>
	    	<td height="22" background="${pageContext.request.contextPath }/resource/images/bg2.gif" bgcolor="#FFFFFF" style="width:3%"><div align="center"><span class="STYLE1">民族</span></div></td>
            <td height="22" background="${pageContext.request.contextPath }/resource/images/bg2.gif" bgcolor="#FFFFFF" style="width: 5%"><div align="center"><span class="STYLE1">部门</span></div></td> 
	    	<td height="22" background="${pageContext.request.contextPath }/resource/images/bg2.gif" bgcolor="#FFFFFF" style="width: 5%"><div align="center"><span class="STYLE1">角色</span></div></td>
	    	<td height="22" background="${pageContext.request.contextPath }/resource/images/bg2.gif" bgcolor="#FFFFFF" style="width: 5%"><div align="center"><span class="STYLE1">学历</span></div></td>
            <td height="22" background="${pageContext.request.contextPath }/resource/images/bg2.gif" bgcolor="#FFFFFF" style="width: 5%"><div align="center"><span class="STYLE1">婚姻</span></div></td>
            <td height="22" background="${pageContext.request.contextPath }/resource/images/bg2.gif" bgcolor="#FFFFFF" style="width: 15%"><div align="center"><span class="STYLE1">家庭地址</span></div></td>
            <td height="22" background="${pageContext.request.contextPath }/resource/images/bg2.gif" bgcolor="#FFFFFF" style="width: 10%"><div align="center"><span class="STYLE1">手机</span></div></td>
            <td height="22" background="${pageContext.request.contextPath }/resource/images/bg2.gif" bgcolor="#FFFFFF" style="width: 9%"><div align="center"><span class="STYLE1">电话</span></div></td>
            <td height="22" background="${pageContext.request.contextPath }/resource/images/bg2.gif" bgcolor="#FFFFFF" style="width: 15%"><div align="center"><span class="STYLE1">邮箱</span></div></td>      
            <td height="22" background="${pageContext.request.contextPath }/resource/images/bg2.gif" bgcolor="#FFFFFF" class="STYLE1" style="width: 14%"><div align="center">基本操作</div></td>
          </tr>
          
          
          <c:forEach items="${pageBean.list }" var="each">
          <tr>
            <td height="20" bgcolor="#FFFFFF" style="width: 3%"><div align="center" class="STYLE1"><div align="center">${each.user_id }</div></div></td>
            <td height="20" bgcolor="#FFFFFF" style="width: 5%"><div align="center"><span class="STYLE1">${each.user_name }</span></div></td>
            <td height="20" bgcolor="#FFFFFF" style="width: 3%"><div align="center"><span class="STYLE1">${each.user_sex } </span></div></td>
            <td height="20" bgcolor="#FFFFFF" style="width: 3%"><div align="center"><span class="STYLE1">${each.user_age }</span></div></td>
	    	<td height="20" bgcolor="#FFFFFF" style="width: 3%"><div align="center"><span class="STYLE1">${each.user_nation } </span></div></td>
	  	  	<td height="20" bgcolor="#FFFFFF" style="width: 5%"><div align="center"><span class="STYLE1">${each.dept.department_name } </span></div></td>
	    	<td height="20" bgcolor="#FFFFFF" style="width: 5%"><div align="center"><span class="STYLE1">${each.role.role_name } </span></div></td>
            <td height="20" bgcolor="#FFFFFF" style="width: 5%"><div align="center"><span class="STYLE1">${each.user_diploma } </span></div></td>
            <td height="20" bgcolor="#FFFFFF" style="width: 5%"><div align="center"><span class="STYLE1">${each.is_married }</span></div></td>
	    	<td height="20" bgcolor="#FFFFFF" style="width: 15%"><div align="center"><span class="STYLE1">${each.user_address }</span></div></td>
   	    	<td height="20" bgcolor="#FFFFFF" style="width: 10%"><div align="center"><span class="STYLE1">${each.user_mobile } </span></div></td>
            <td height="20" bgcolor="#FFFFFF" style="width: 9%"><div align="center"><span class="STYLE1">${each.user_tel }</span></div></td>
            <td height="20" bgcolor="#FFFFFF" style="width:1 5%"><div align="center"><span class="STYLE1">${each.user_email }</span></div></td>
            <td height="20" bgcolor="#FFFFFF" style="width: 14%"><div align="center"><span class="STYLE4"><img        src="${pageContext.request.contextPath }/resource/images/edt.gif" width="16" height="16" />
            <a       href="${pageContext.request.contextPath }/user/userAction_empEdit?user_id=${each.user_id }">编辑</a>&nbsp;<img src="${pageContext.request.contextPath }/resource/images/edt.gif" width="16" height="16" />
            <a href="${pageContext.request.contextPath }/user/userAction_userInfoDetail?user_id=${each.user_id }" >详情</a>&nbsp;<img     src="${pageContext.request.contextPath }/resource/images/del.gif" width="16" height="16" />
            <a      href="${pageContext.request.contextPath }/user/userAction_userInfoDelete?user_id=${each.user_id }">删除</a></span></div></td>
          </tr>
          </c:forEach>          
          </table></td>
        <td width="8" background="${pageContext.request.contextPath }resource/images/tab_15.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="35" background="${pageContext.request.contextPath }/resource/images/tab_19.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="35"><img src="${pageContext.request.contextPath }/resource/images/tab_18.gif" width="12" height="35" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="STYLE4">&nbsp;&nbsp;共有 ${pageBean.rowCount } 条记录，当前第 ${pageBean.currentPage }/${pageBean.pageCount } 页</td>
            <td><table border="0" align="right" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="40"><a href="${pageContext.request.contextPath }/user/userAction_findAllUser.action?pageBean.currentPage=1&queryVO.queryContent=${queryVO.queryContent}&queryVO.queryWay=${queryVO.queryWay}" >首页</a></td>
                  <td width="45"><a href="${pageContext.request.contextPath }/user/userAction_findAllUser.action?pageBean.currentPage=${pageBean.currentPage-1}&queryVO.queryContent=${queryVO.queryContent}&queryVO.queryWay=${queryVO.queryWay}" >上一页</a></td>
                  <td width="45"><a href="${pageContext.request.contextPath }/user/userAction_findAllUser.action?pageBean.currentPage=${pageBean.currentPage+1}&queryVO.queryContent=${queryVO.queryContent}&queryVO.queryWay=${queryVO.queryWay}" >下一页</a></td>
                  <td width="40"><a href="${pageContext.request.contextPath }/user/userAction_findAllUser.action?pageBean.currentPage=${PageBean.pageCount}&queryVO.queryContent=${queryVO.queryContent}&queryVO.queryWay=${queryVO.queryWay}" >尾页</a></td>
                  <td width="100"><div align="center"><span class="STYLE1">转到第
                    <input id="goPage" name="textfield" type="text" size="4" style="height:12px; width:20px; border:1px solid #999999;" /> 
                    页 </span></div></td>
                  <td width="40"><img onclick="go()" src="${pageContext.request.contextPath }/resource/images/go.gif" width="37" height="15" /></td>
                </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="16"><img src="${pageContext.request.contextPath }/resource/images/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
</body>
<script type="text/javascript">
	function go(){
		var goPage=document.getElementById("goPage").value;
		//确保在已经条件查询的结果的前提下正确分页
		var queryContent=document.getElementById("queryContent").value;
		var queryWay=document.getElementById("queryWay").value;
		window.location.href="${pageContext.request.contextPath }/user/userAction_findAllUser.action?"+
				"pageBean.currentPage="+goPage+"&queryVO.queryContent="+queryContent+"&queryWay"+queryWay;
	}
</script>
</html>
