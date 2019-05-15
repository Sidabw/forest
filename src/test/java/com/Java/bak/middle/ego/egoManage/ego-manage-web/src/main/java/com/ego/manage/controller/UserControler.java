package com.ego.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ego.manage.service.inter.IUserService;
import com.ego.pojo.PictrueResult;
import com.ego.pojo.TbUser;

@Controller
public class UserControler {

	@Autowired
	private IUserService us;
	@RequestMapping("/user/login.do")
	@ResponseBody
	public String login(TbUser user){
		System.out.println("-------------------------------------------------------------------"+user);
		boolean flag = us.login(user);
		if(flag){
			return "true";
		}else{
			return "false";
		}
	}
	@RequestMapping("/pic/upload.do")
	public void upload(@RequestParam MultipartFile uploadFile){
		PictrueResult result=us.uploadPic(uploadFile);
	}
}
