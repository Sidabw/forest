<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>left.html</title>
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

.STYLE1 {
	font-size: 12px;
	color: #FFFFFF;
}

.STYLE3 {
	font-size: 12px;
	color: #033d61;
}
-->
</style>
		<style type="text/css">
.menu_title SPAN {
	FONT-WEIGHT: bold;
	LEFT: 3px;
	COLOR: #ffffff;
	POSITION: relative;
	TOP: 2px
}

.menu_title2 SPAN {
	FONT-WEIGHT: bold;
	LEFT: 3px;
	COLOR: #FFCC00;
	POSITION: relative;
	TOP: 2px
}

.style1 {
	font-size: 12px;
}

a {
	text-decoration: none;
	color: #033d61;
}
}
</style>
		<script>
var he=document.body.clientHeight-105
document.write("<div id=tt style=height:"+he+";overflow:hidden>")
</script>

	</head>

	<body>
			
		<table width="165" height="100%" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="28"
					background="${pageContext.request.contextPath}/resource/images/main_40.gif">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="19%">
								&nbsp;
							</td>
							<td width="81%" height="20">
								<span class="STYLE1">管理菜单</span>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td valign="top">
					<table width="151" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="23"
											background="${pageContext.request.contextPath}/resource/images/main_47.gif"
											id="imgmenu1" class="menu_title"
											onMouseOver="this.className='menu_title2';"
											onClick="showsubmenu(1)"
											onMouseOut="this.className='menu_title';"
											style="cursor: hand">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td width="18%">
														&nbsp;
													</td>
													<td width="82%" class="STYLE1">
														客户相关
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td background="${pageContext.request.contextPath}/resource/images/main_51.gif"
											id="submenu1">
											<div class="sec_menu">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td>
															<table width="90%" border="0" align="center"
																cellpadding="0" cellspacing="0">
																<tr>
																	<td width="16%" height="25">
																		<div align="center">
																			<img src="${pageContext.request.contextPath}/resource/images/left.gif"
																				width="10" height="10" />
																		</div>
																	</td>
																	<td width="84%" height="23">
																		<table width="95%" border="0" cellspacing="0"
																			cellpadding="0">
																			<tr>
																				<td height="20" style="cursor: hand"
																					onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "
																					onmouseout="this.style.borderStyle='none'">
																					<span class="STYLE3"><a 
																						href="../customer/customer_list.jsp"
																						target="mainFrame">客户信息</a> </span>
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr>
																<tr    >
																	<td height="23">
																		<div align="center">
																			<img src="${pageContext.request.contextPath}/resource/images/left.gif"
																				width="10" height="10" />
																		</div>
																	</td>
																	<td height="23"   >
																		<table width="95%" border="0" cellspacing="0"
																			cellpadding="0">
																			<tr  >
																				<td height="20" style="cursor: hand"
																					onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "
																					onmouseout="this.style.borderStyle='none'">
																					<span class="STYLE3"> <a
																						href="../customer/customer_distribute_list.html"
																						target="mainFrame">客户分配</a> </span>
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr>
												
																<tr>
																	<td height="23">
																		<div align="center">
																			<img src="${pageContext.request.contextPath}/resource/images/left.gif"
																				width="10" height="10" />
																		</div>
																	</td>
																	<td height="23">
																		<table width="95%" border="0" cellspacing="0"
																			cellpadding="0">
																			<tr>
																				<td height="20" style="cursor: hand"
																					onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "
																					onmouseout="this.style.borderStyle='none'">
																					<span class="STYLE3"><a
																						href="../customer/customer_care_list.html"
																						target="mainFrame">客户关怀</a> </span>
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr>
																<tr>
																	<td height="23">
																		<div align="center">
																			<img src="${pageContext.request.contextPath}/resource/images/left.gif"
																				width="10" height="10" />
																		</div>
																	</td>
																	<td height="23">
																		<table width="95%" border="0" cellspacing="0"
																			cellpadding="0">
																			<tr>
																				<td height="20" style="cursor: hand"
																					onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "
																					onmouseout="this.style.borderStyle='none'">
																					<span class="STYLE3"> <a
																						href="../customer/customer_type_list.html" target="mainFrame">客户类型</a>
																					</span>
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr>
																<tr>
																	<td height="23">
																		<div align="center">
																			<img src="${pageContext.request.contextPath}/resource/images/left.gif"
																				width="10" height="10" />
																		</div>
																	</td>
																	<td height="23">
																		<table width="95%" border="0" cellspacing="0"
																			cellpadding="0">
																			<tr>
																				<td height="20" style="cursor: hand"
																					onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "
																					onmouseout="this.style.borderStyle='none'">
																					<span class="STYLE3"> <a
																						href="../customer/customer_state_list.html"
																						target="mainFrame">客户状态</a> </span>
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr>
																<tr>
																	<td height="23">
																		<div align="center">
																			<img src="${pageContext.request.contextPath}/resource/images/left.gif"
																				width="10" height="10" />
																		</div>
																	</td>
																	<td height="23">
																		<table width="95%" border="0" cellspacing="0"
																			cellpadding="0">
																			<tr>
																				<td height="20" style="cursor: hand"
																					onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "
																					onmouseout="this.style.borderStyle='none'">
																					<span class="STYLE3"> <a
																						href="../customer/customer_source_list.html" target="mainFrame">客户来源</a>
																					</span>
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr>
																<!-- <tr>
																	<td height="23">
																		<div align="center">
																			<img src="${pageContext.request.contextPath}/resource/images/left.gif"
																				width="10" height="10" />
																		</div>
																	</td>
																	<td height="23">
																		<table width="95%" border="0" cellspacing="0"
																			cellpadding="0">
																			<tr>
																				<td height="20" style="cursor: hand"
																					onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "
																					onmouseout="this.style.borderStyle='none'">
																					<span class="STYLE3"><a
																						href="servlet/LinkRecordQueryServlet"
																						target="mainFrame">联系记录</a> </span>
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr> -->
																<!-- <tr>
																	<td height="23">
																		<div align="center">
																			<img src="${pageContext.request.contextPath}/resource/images/left.gif"
																				width="10" height="10" />
																		</div>
																	</td>
																	<td height="23">
																		<table width="95%" border="0" cellspacing="0"
																			cellpadding="0">
																			<tr>
																				<td height="20" style="cursor: hand"
																					onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "
																					onmouseout="this.style.borderStyle='none'">
																					<span class="STYLE3"><a
																						href="servlet/LinkManQueryServlet"
																						target="mainFrame">联系人</a> </span>
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr> -->

															</table>
														</td>
													</tr>
													<tr>
														<td height="5">
															<img src="${pageContext.request.contextPath}/resource/images/main_52.gif"
																width="151" height="5" />
														</td>
													</tr>
												</table>
											</div>
										</td>
									</tr>

								</table>
							</td>
						</tr>





						<tr>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="23"
											background="${pageContext.request.contextPath}/resource/images/main_47.gif"
											id="imgmenu3" class="menu_title"
											onmouseover="this.className='menu_title2';"
											onclick="showsubmenu(3)"
											onmouseout="this.className='menu_title';"
											style="cursor: hand">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td width="18%">
														&nbsp;
													</td>
													<td width="82%" class="STYLE1">
														员工相关
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td background="${pageContext.request.contextPath}/resource/images/main_51.gif"
											id="submenu3">
											<div class="sec_menu">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td>
															<table width="90%" border="0" align="center"
																cellpadding="0" cellspacing="0">
																<tr>
																	<td width="16%" height="25">
																		<div align="center">
																			<img src="${pageContext.request.contextPath}/resource/images/left.gif"
																				width="10" height="10" />
																		</div>
																	</td>
																	<td width="84%" height="23">
																		<table width="95%" border="0" cellspacing="0"
																			cellpadding="0">
																			<tr>
																				<td height="20" style="cursor: hand"
																					onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "
																					onmouseout="this.style.borderStyle='none'">
																					<span class="STYLE3"><a
																						href="${pageContext.request.contextPath}/user/userList.do" target="mainFrame">员工信息</a>
																					</span>
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr>									
																<tr>
																	<td height="23">
																		<div align="center">
																			<img src="${pageContext.request.contextPath}/resource/images/left.gif"
																				width="10" height="10" />
																		</div>
																	</td>
																	<td height="23">
																		<table width="95%" border="0" cellspacing="0"
																			cellpadding="0">
																			<tr>
																				<td height="20" style="cursor: hand"
																					onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "
																					onmouseout="this.style.borderStyle='none'">
																					<span class="STYLE3"> <a
																						href=../employee/house_list.html target="mainFrame">房屋信息</a>
																					</span>
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr>
																<tr>
																	<td height="23">
																		<div align="center">
																			<img src="${pageContext.request.contextPath}/resource/images/left.gif"
																				width="10" height="10" />
																		</div>
																	</td>
																	<td height="23">
																		<table width="95%" border="0" cellspacing="0"
																			cellpadding="0">
																			<tr>
																				<td height="20" style="cursor: hand"
																					onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "
																					onmouseout="this.style.borderStyle='none'">
																					<span class="STYLE3"> <a
																						href="../employee/house_type_list.html" target="mainFrame">房屋类型</a>
																					</span>
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr>
																<tr>
																	<td height="23">
																		<div align="center">
																			<img src="${pageContext.request.contextPath}/resource/images/left.gif"
																				width="10" height="10" />
																		</div>
																	</td>
																	<td height="23">
																		<table width="95%" border="0" cellspacing="0"
																			cellpadding="0">
																			<tr>
																				<td height="20" style="cursor: hand"
																					onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "
																					onmouseout="this.style.borderStyle='none'">
																					<span class="STYLE3"> <a
																						href="../employee/dept_list.html"
																						target="mainFrame">部门信息</a> </span>
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr>

																<tr>
																	<td height="23">
																		<div align="center">
																			<img src="${pageContext.request.contextPath}/resource/images/left.gif"
																				width="10" height="10" />
																		</div>
																	</td>
																	<td height="23">
																		<table width="95%" border="0" cellspacing="0"
																			cellpadding="0">
																			<tr>
																				<td height="20" style="cursor: hand"
																					onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "
																					onmouseout="this.style.borderStyle='none'">
																					<span class="STYLE3"> <a
																						href="../employee/notice_list.html"
																						target="mainFrame">公&nbsp;&nbsp;&nbsp;&nbsp;告</a>
																					</span>
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr>
															</table>
														</td>
													</tr>

													<tr>
														<td height="5">
															<img src="${pageContext.request.contextPath}/resource/images/main_52.gif"
																width="151" height="5" />
														</td>
													</tr>
												</table>
											</div>
										</td>
									</tr>
								</table>
							</td>
						</tr>



						<!-- <tr>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="23"
											background="${pageContext.request.contextPath}/resource/images/main_47.gif"
											id="imgmenu2" class="menu_title"
											onMouseOver="this.className='menu_title2';"
											onClick="showsubmenu(2)"
											onMouseOut="this.className='menu_title';"
											style="cursor: hand">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td width="18%">
														&nbsp;
													</td>
													<td width="82%" class="STYLE1">
														邮件相关
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td background="${pageContext.request.contextPath}/resource/images/main_51.gif"
											id="submenu2">
											<div class="sec_menu">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td>
															<table width="90%" border="0" align="center"
																cellpadding="0" cellspacing="0">
																<tr>
																	<td width="16%" height="25">
																		<div align="center">
																			<img src="${pageContext.request.contextPath}/resource/images/left.gif"
																				width="10" height="10" />
																		</div>
																	</td>
																	<td width="84%" height="23">
																		<table width="95%" border="0" cellspacing="0"
																			cellpadding="0">
																			<tr>
																				<td height="20" style="cursor: hand"
																					onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "
																					onmouseout="this.style.borderStyle='none'">
																					<span class="STYLE3"><a
																						href="servlet/EmailQueryManServlet" target="mainFrame">写邮件</a>
																					</span>
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr>
																<tr>
																	<td height="23">
																		<div align="center">
																			<img src="${pageContext.request.contextPath}/resource/images/left.gif"
																				width="10" height="10" />
																		</div>
																	</td>
																	<td height="23">
																		<table width="95%" border="0" cellspacing="0"
																			cellpadding="0">
																			<tr>
																				<td height="20" style="cursor: hand"
																					onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "
																					onmouseout="this.style.borderStyle='none'">
																					<span class="STYLE3"> <a
																						href="servlet/EmailQueryServlet" target="mainFrame">发件箱</a>
																					</span>
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr>
																<tr>
																	<td height="23">
																		<div align="center">
																			<img src="${pageContext.request.contextPath}/resource/images/left.gif"
																				width="10" height="10" />
																		</div>
																	</td>
																	<td height="23">
																		<table width="95%" border="0" cellspacing="0"
																			cellpadding="0">
																			<tr>
																				<td height="20" style="cursor: hand"
																					onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "
																					onmouseout="this.style.borderStyle='none'">
																					<span class="STYLE3"><a
																						href="servlet/EmailQueryNoSendServlet" target="mainFrame">草稿箱</a>
																					</span>
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr>
															</table>
														</td>
													</tr>
													<tr>
														<td height="5">
															<img src="${pageContext.request.contextPath}/resource/images/main_52.gif"
																width="151" height="5" />
														</td>
													</tr>
												</table>
											</div>
										</td>
									</tr>

								</table>
							</td>
						</tr>

 -->

						<tr      >
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="23"
											background="${pageContext.request.contextPath}/resource/images/main_47.gif"
											id="imgmenu4" class="menu_title"
											onmouseover="this.className='menu_title2';"
											onclick="showsubmenu(4)"
											onmouseout="this.className='menu_title';"
											style="cursor: hand">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td width="18%">
														&nbsp;
													</td>
													<td width="82%" class="STYLE1">
														管理员
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td background="${pageContext.request.contextPath}/resource/images/main_51.gif"
											id="submenu4" style="DISPLAY: none">
											<div class="sec_menu">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td>
															<table width="90%" border="0" align="center"
																cellpadding="0" cellspacing="0">
																<tr>
																	<td width="16%" height="25">
																		<div align="center">
																			<img src="${pageContext.request.contextPath}/resource/images/left.gif"
																				width="10" height="10" />
																		</div>
																	</td>
																	<td width="84%" height="23">
																		<table width="95%" border="0" cellspacing="0"
																			cellpadding="0">
																			<tr>
																				<td height="20" style="cursor: hand"
																					onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "
																					onmouseout="this.style.borderStyle='none'">
																					<span class="STYLE3"><a
																						href="../admin/emp_add.jsp" target="mainFrame">添加员工</a>
																					</span>
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr>
																<tr>
																	<td height="23">
																		<div align="center">
																			<img src="${pageContext.request.contextPath}/resource/images/left.gif"
																				width="10" height="10" />
																		</div>
																	</td>
																	<td height="23">
																		<table width="95%" border="0" cellspacing="0"
																			cellpadding="0">
																			<tr>
																				<td height="20" style="cursor: hand"
																					onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "
																					onmouseout="this.style.borderStyle='none'">
																					<span class="STYLE3"> <a
																						href="../admin/dept_add.jsp"
																						target="mainFrame">添加部门</a> </span>
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr>
																<tr>
																	<td height="23">
																		<div align="center">
																			<img src="${pageContext.request.contextPath}/resource/images/left.gif"
																				width="10" height="10" />
																		</div>
																	</td>
																	<td height="23">
																		<table width="95%" border="0" cellspacing="0"
																			cellpadding="0">
																			<tr>
																				<td height="20" style="cursor: hand"
																					onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "
																					onmouseout="this.style.borderStyle='none'">
																					<span class="STYLE3"> <a
																						href="../admin/role_add.jsp" target="mainFrame">添加角色</a>
																					</span>
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr>
															</table>
														</td>
													</tr>
													<tr>
														<td height="5">
															<img src="${pageContext.request.contextPath}/resource/images/main_52.gif"
																width="151" height="5" />
														</td>
													</tr>
												</table>
											</div>
										</td>
									</tr>
									
								</table>
							</td>
						</tr>
					</table>
				</td>
				
			</tr>
			<tr>
				<td height="18"
					background="${pageContext.request.contextPath}/resource/images/main_58.gif">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="18" valign="bottom">
								<div align="center" class="STYLE3">
									版本：20013V1.0
								</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>

	</body>
	<script>

function showsubmenu(sid)
{
whichEl = eval("submenu" + sid);
imgmenu = eval("imgmenu" + sid);
if (whichEl.style.display == "none")
{
eval("submenu" + sid + ".style.display=\"\";");
imgmenu.background="${pageContext.request.contextPath}/resource/images/main_47.gif";
}
else
{
eval("submenu" + sid + ".style.display=\"none\";");
imgmenu.background="${pageContext.request.contextPath}/resource/images/main_48.gif";
}
}

</script>
</html>
