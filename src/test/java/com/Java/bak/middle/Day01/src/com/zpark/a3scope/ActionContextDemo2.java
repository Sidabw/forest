package com.Java.bak.middle.Day01.src.com.zpark.a3scope;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ActionContextDemo2 extends ActionSupport {
	public String execute() throws Exception{
		//��ȡԭ��request
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("HttpServletRuqestFromServletActionContext", "THIS IS SO CUTE");
		//��ȡԭ��response
		HttpServletResponse response = ServletActionContext.getResponse();
		//��ȡԭ��session
		HttpSession session = request.getSession();
		//��ȡԭ����ServletContext
		ServletContext servletContext = request.getServletContext();
		return super.execute();
	}
}
