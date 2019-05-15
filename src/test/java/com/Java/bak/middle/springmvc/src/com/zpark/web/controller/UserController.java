package com.Java.bak.middle.springmvc.src.com.zpark.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zpark.web.pojo.User;

@Controller
public class UserController {

	@RequestMapping("/user/list.do")
	public ModelAndView list(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("us", new User(1,"sida","324567890"));
		modelAndView.setViewName("/hello.jsp");
		return modelAndView;
	}
}
