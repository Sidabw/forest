package com.beta.basic.controller;

import java.io.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
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

	@RequestMapping(value="/loginTest")
	@ResponseBody
	public Map<String,?> loginTest(String username, String password, String _csrf, HttpServletRequest request){
		logger.info("loginTest...INFO...LEVEL...Test");
		logger.warn("loginTest...WARN...LEVEL...Test");
		logger.error("loginTest...ERROR...LEVEL...Test");
		Map<String,Object> map =new HashMap<>();
        if(!username.equals("") && password!=""){
            LoginUser user =new LoginUser(username,password);
            request.getSession().setAttribute("user",username);
            map.put("result","1");
        }else{
            map.put("result","0");
        }
        return map;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
	public Object logout(){
	    return "logout success";
    }

	@RequestMapping(value="/formtest",method=RequestMethod.POST)
	public String codingtest(HttpServletRequest request,String username,String password) throws UnsupportedEncodingException{
		//request.setCharacterEncoding("utf-8");
		System.out.println("username"+username);
		System.out.println("password"+password);
		return "hello";
	}


	//测试基本的多文件上传
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public Object upload(MultipartFile[] uploadFile) throws IOException {
        String originalFilename = uploadFile[0].getOriginalFilename();
        String originalFilename2 = uploadFile[1].getOriginalFilename();
        System.out.println(originalFilename);
        System.out.println(originalFilename2);
        InputStream inputStream = uploadFile[0].getInputStream();
        return "11";
    }



    @RequestMapping(value = "/upload2", method = RequestMethod.POST)
    @ResponseBody
    public Object upload2(HttpServletRequest request) throws IOException {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
        Iterator<String> fileNames = multipartRequest.getFileNames();
        List<MultipartFile> files = multipartRequest.getFiles("uploadFile");
        for(MultipartFile file : files) {

            File fileUpload = new File("/Users/feiyi/Documents/feiyiGitProject/" + "upload_test" +  new Random().nextInt(10) +file.getOriginalFilename());

            file.transferTo(fileUpload);
        }
        System.out.println(files.size());
        while (fileNames.hasNext()) {
            System.out.println(fileNames.next());
        }
        return "11";
    }


    @RequestMapping(value = "/uploadStatus", method = RequestMethod.GET)
    @ResponseBody
    public Object getStatus(HttpServletRequest request){
	    return request.getSession().getAttribute("uploadStatus");
    }




}
