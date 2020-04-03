package com.ego.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ego.manage.service.TestS;
import com.ego.pojo.TbUser;

@Controller
public class TestC {
	@Autowired
	private TestS s;
	
	@RequestMapping("/hello.do")
	public String test(){
		s.tests();
		return "hello.jsp";
	}
	/*@RequestMapping("/login.do")
	public Boolean login(TbUser user){
		System.out.println(user);
		return false;
	}*/
}
