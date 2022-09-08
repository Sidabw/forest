package com.Java.bak.middle.Day01.src.com.zpark.a3scope;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class ActionContextDemo {
	public String execute(){
		//��ȡԭ��request
		Map<String, Object> requestScope=(Map<String, Object>)ActionContext.getContext().get("............");
		//�ŵ�ActionContext��������
		ActionContext.getContext().put("Uname", "Sida");
		//��ȡԭ��session
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("sessionUname", "Brew");
		//��ȡԭ��ServletContext,��application
		Map<String, Object> application = ActionContext.getContext().getApplication();
		application.put("applicationUname", "luobotou");
		return "success";
	}
}
