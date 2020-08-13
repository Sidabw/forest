package com.Java.bak.middle.ssmBak.SSM.src.com.zpark.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zpark.service.IUserService;
import com.zpark.web.pojo.Student;
import com.zpark.web.pojo.User;

@Controller
public class UserController {
	/**
	 * 练习使用参数封装
	 * */
	@Resource(name="us")
	private IUserService ius;
	
	@RequestMapping("/user/list.do")
	public ModelAndView list(User u){
		System.out.println(u);
		ModelAndView modelAndView = new ModelAndView();
		Student student = ius.findById(u.getId());
		modelAndView.addObject("stu", student);
		modelAndView.setViewName("hello");
		return modelAndView;
	}
	@RequestMapping("/user/list2.do")
	public String list2(User u,Model model){
		Integer id = u.getId();
		String name = u.getName();
		String tel = u.getTel();
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		model.addAttribute("tel", tel);
		return"hello";
	}
	/**
	 * 解决前台传值可能为空的情况.required true 或者false 前台都可以不传参到后台（也可以传参不带值到后台）
	 * */
	@RequestMapping("/user/list3.do")
	public String list3(@RequestParam(value="id",required=true,defaultValue="1")Integer id,Model model){
		System.out.println(id);
		return "hello";
	}
	/**
	 * 可以直接使用原生HttpServletRequest		HttpServletResponse
	 * */
	@RequestMapping("/user/list4.do")
	public String list4(HttpServletRequest request,HttpServletResponse response,Model model){
		String id = request.getParameter("id");
		//id为null时会报错	NumberFormatException
		System.out.println(Integer.parseInt(id));
		return "hello";
	}
}
