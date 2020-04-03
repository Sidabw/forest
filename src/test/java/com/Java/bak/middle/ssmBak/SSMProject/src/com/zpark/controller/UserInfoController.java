package com.Java.bak.middle.ssmBak.SSMProject.src.com.zpark.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zpark.pageutil.PageBean;
import com.zpark.pojo.QueryVO;
import com.zpark.pojo.UserInfo;
import com.zpark.service.IUserInfoService;

@Controller
public class UserInfoController {
	@Resource(name="us")
	private IUserInfoService us;
	
	/**
	 * ��¼
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/user/login.do")
	public String login(UserInfo user,HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		String view = null;
		UserInfo u = us.login(user);
		if(u!=null){
			request.getSession().setAttribute("user", u);
			view = "frame/main";
		}else{
			view = "redirect:/login.jsp";
		}
		return view;
	}
	
	@RequestMapping("/user/userList.do")
	public ModelAndView userList(QueryVO queryVO,PageBean pageBean){
		ModelAndView modelAndView = new ModelAndView();
		List<UserInfo> list=us.userList(queryVO,pageBean);
		modelAndView.addObject("list",list);
		modelAndView.setViewName("employee/emp_list");
		return modelAndView;
	}
	@RequestMapping("/user/export.do")
	public void export(HttpServletResponse response){
		try {
			//获取相应输出流，
			ServletOutputStream out = response.getOutputStream();
			//获取文件名 获取字符串的字节码 再重新编码为utf-8
			String fileName=new String(("userInfo"+new SimpleDateFormat("yyyy-MM-dd").format(new Date())).getBytes(),"utf-8");
			//设置响应内容的打开方式：以附件方式打开
			response.setHeader("Content-disposition", "attachment;filename="+fileName+".xls");
			//设置相应内容格式
			response.setContentType("application/vnd.ms-excel;charset=gb2312");
			//设置表头信息
			String[] titles={"用户姓名","用户年龄","用户密码","用户部门"};
			//操作数据库操作下载和获取下载信息
			us.export(titles,out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
