package com.beta.basic.controller;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.beta.basic.mybatis.mapper.TbUser;
import com.beta.basic.pojo.LoginUser;
import com.beta.basic.service.AsyncTest;
import com.beta.basic.service.IUserService;


@Controller
@RequestMapping("/user")
public class ControllerMy {
	
	private Logger logger = Logger.getLogger(ControllerMy.class);  
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private AsyncTest asyncTest;
	
	@RequestMapping(value="/asynctest",method=RequestMethod.GET)
	@ResponseBody
	public String asyncTest() throws Exception{
		asyncTest.testt();
		logger.info("/asynctest请求到达");
		System.out.println("/asynctest请求到达");
		return "hello world async";
	}

	@RequestMapping(value="/dataList",method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView dataList(){

		long start = System.currentTimeMillis();
		List<TbUser> queryList = userService.queryList();
		logger.error("消耗时间" + (System.currentTimeMillis() - start));
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("arrayList",queryList);
		modelAndView.setViewName("/index");
		return modelAndView;
	}

	@RequestMapping(value="/loginTest",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,?> loginTest(String userName, String password, HttpServletRequest request){
		logger.info("loginTest...INFO...LEVEL...Test");
		logger.warn("loginTest...WARN...LEVEL...Test");
		logger.error("loginTest...ERROR...LEVEL...Test");
		Map<String,Object> map =new HashMap<>();
        if(!userName.equals("") && password!=""){
            LoginUser user =new LoginUser(userName,password);
            request.getSession().setAttribute("user",userName);
            map.put("result","1");
        }else{
            map.put("result","0");
        }
        return map;
	}
	
	@RequestMapping(value="/formtest",method=RequestMethod.POST)
	public String codingtest(HttpServletRequest request,String username,String password) throws UnsupportedEncodingException{
		//request.setCharacterEncoding("utf-8");
		System.out.println("username"+username);
		System.out.println("password"+password);
		return "hello";
	}


}
