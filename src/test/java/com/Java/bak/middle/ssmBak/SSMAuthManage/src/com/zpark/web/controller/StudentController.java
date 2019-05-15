package com.Java.bak.middle.ssmBak.SSMAuthManage.src.com.zpark.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zpark.service.IUserService;
import com.zpark.web.pojo.Student;
import com.zpark.web.pojo.VO;

@Controller
public class StudentController {

	@Resource(name="us")
	private IUserService us;
	/**
	 * 查询所有员工
	 * */
	@RequestMapping("/stu/list.do")
	public String list(Model model){
		List<Student> list = us.list();
		model.addAttribute("list", list);
		return "list";
	}
	/**
	 * 携带带个员工信息到达编辑页面
	 * */
	@RequestMapping("/stu/toEdit.do")
	public String toEdit(Integer id,Model model){
		Student student = us.findById(id);
		model.addAttribute("stu", student);
		return "edit";
	}
	@RequestMapping("/stu/edit.do")
	public String edit(Student stu,Model model){
		System.out.println(stu);
		return "hello";
	}
	/**
	 * checkbox批量删除
	 * 请求转发和重定向	后面都跟全路径
	 * 重定向到页面：redirect后面必须跟jsp的全路径		/jsp/hello.jsp
	 * 请求转发到页面同上
	 * 区别StudentController2中的response....
	 * */
	@RequestMapping("/stu/batchDel.do")
	public String batchDel(VO vo){
		//us.batchDel(vo.getIds());
		//return "dispatcher:/stu/list.do";
		
		//正确4
		//return "forward:/stu/list.do";
		//正确3
		//return "forward:/jsp/hello.jsp";
		//正确2
		//return "redirect:/stu/list.do";
		//正确1
		return "redirect:/jsp/hello.jsp";
	}
	/**
	 * 前台传递list类型，需封装到对象中接受
	 * */
	@RequestMapping("/stu/batchEdit.do")
	public String batchEdit(VO vo){
		return "";
	}
}
