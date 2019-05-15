package com.Java.bak.middle.ssmBak.SSMProject.src.com.zpark.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zpark.pojo.DepartmentInfo;
import com.zpark.pojo.UserInfo;
import com.zpark.pojo.UserRole;
import com.zpark.service.IUserInfoService;

@Controller
public class AdminController {

	@Resource(name="us")
	private IUserInfoService us;
	
	@RequestMapping("/admin/empAdd.do")
	public void empAdd(UserInfo user,HttpServletRequest request,HttpServletResponse response){
		us.empAdd(user);
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script type='text/javascript'>"+
						//"alert('��ӳɹ�');"
						 "window.top.location.href='/SSMProject/view/frame/main.jsp'"+
						"</script>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/admin/deptAdd.do")
	public void deptAdd(DepartmentInfo dept,HttpServletRequest request,HttpServletResponse response){
		/**
		 * deparment_id ���ݿ���Ϊ��������̨��null����
		 * is_used	���ݿ���defaultValueΪ1����̨��null����
		 * */
		us.deptAdd(dept);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			out.print("<script type='text/javascript'>"+
					"alert('������ӳɹ�');"+
					"top.location.href='/SSMProject/view/frame/main.jsp';"+
					"</script>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/admin/roleAdd.do")
	public void roleAdd(HttpServletRequest request,HttpServletResponse response,UserRole userRole){
		us.roleAdd(userRole);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			out.print("<script type='text/javascript'>"+
					"alert('��ɫ��ӳɹ�');"+
					"top.location.href='/SSMProject/view/frame/main.jsp';"+
					"</script>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/user/empAdd2.do")
	public void empAdd2(Date date){
		System.out.println(date);
	}
}
