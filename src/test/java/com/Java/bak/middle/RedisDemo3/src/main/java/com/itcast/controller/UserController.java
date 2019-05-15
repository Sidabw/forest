package com.Java.bak.middle.RedisDemo3.src.main.java.com.itcast.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itcast.mybatis.TbUser;
import com.itcast.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	//根据名称userService注入
	@Resource
	private IUserService userService;
	
	//http://localhost:8080/ssmTemplate/user/detail.action?id=7
	@RequestMapping("/detail.action")
	public String detail(HttpServletRequest request,Model model){
		int userId = Integer.parseInt(request.getParameter("id"));
		TbUser user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		return "list"; 
	}
}
