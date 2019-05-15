package com.Java.bak.middle.Day02.src.com.zpark.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.zpark.entity.User;
import com.zpark.serviceimpl.UserServiceImpl;

public class ActionFirst extends ActionSupport implements ServletRequestAware{
	HttpServletRequest request =null;
	private User user=new User();
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String execute() throws Exception{
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		boolean flag =userServiceImpl.adduser(user);
		if (flag) {
			List<User> queryAll = userServiceImpl.queryAll();
			if(queryAll!=null&&queryAll.size()!=0){
				request.setAttribute("list", queryAll);
			}
		}else{
			
		}
		return super.execute();
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
}
