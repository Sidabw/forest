package com.Java.bak.middle.sshBak.SSH.src.com.zpark.web.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.zpark.service.IUserService;
import com.zpark.web.pojo.User;
@Controller("userActionSpring")
@Scope("prototype")
public class Demo extends ActionSupport {
	@Resource(name="userService")
	private IUserService userService;
	public String test(){
		System.out.println("ok...."+this.hashCode());
		return SUCCESS;
	}
	public String sava(){
		userService.sava(new User(null,"luoboluobotou","679546789"));
		return SUCCESS;
	}
	public String findByName(){
		userService.findByName();
		return SUCCESS;
	}
}
