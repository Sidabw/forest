package com.beta.basic.controller;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
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

    @RequestMapping(value="/logintest2")
    @ResponseBody
    public Map<String,?> loginTest2(String username, String password, String _csrf,
                                    HttpServletRequest request, HttpServletResponse response){
        logger.error("loginTest...ERROR...LEVEL...Test");
        Map<String,Object> map =new HashMap<>();
        map.put("result","1");
        response.setStatus(401);
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
    public Object upload2(MultipartFile uploadFile, String userIdtime) throws IOException {
//        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
//        Iterator<String> fileNames = uploadFile.getFileNames();
//        ServletInputStream inputStream = uploadFile.getInputStream();
//        List<MultipartFile> files = uploadFile.getFiles("uploadFile");
//        for(MultipartFile file : files) {
        InputStream inputStream = uploadFile.getInputStream();
//        String fileMd5 = DigestUtils.md5Hex(inputStream);
//        InputStream inputStream1 = uploadFile.getInputStream();
//        System.out.println(inputStream == inputStream1);
//        System.out.println(fileMd5);
//        System.out.println(userIdtime);
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost("http://weedfs-filer.zenki.cn/a/b");
            httpPost.setHeader(new BasicHeader("Accept-Language", "zh-cn"));
            HttpEntity reqEntity = MultipartEntityBuilder.create()
                    .setCharset(Charset.forName("UTF-8"))
                    .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                    .addBinaryBody("b", inputStream)
                    .build();
//
            // 发起请求并返回请求的响应
            httpPost.setEntity(reqEntity);
            CloseableHttpResponse response = httpClient.execute(httpPost);
            System.out.println(response.getStatusLine());
//            File fileUpload = new File("/Users/feiyi/Documents/feiyiGitProject/" + "upload_test/" +  new Random().nextInt(10) +uploadFile.getOriginalFilename());
//
//        uploadFile.transferTo(fileUpload);
//        }
//        System.out.println(files.size());
//        while (fileNames.hasNext()) {
//            System.out.println(fileNames.next());
//        }
        return "11";
    }


    @RequestMapping(value = "/uploadStatus", method = RequestMethod.GET)
    @ResponseBody
    public Object getStatus(HttpServletRequest request){
	    return request.getSession().getAttribute("uploadStatus");
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public Object getTest(HttpServletRequest request){
        System.out.println(11);
        return "aaa";
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    @ResponseBody
    public Object getTest2(HttpServletRequest request){
        System.out.println(22);
        return "aaa22";
    }

    //在mysql中使用blob存储二进制图片数据
    @RequestMapping(value = "/binaryImageDbStorage", method = RequestMethod.POST)
    @ResponseBody
    public boolean binaryImageDbStorage(MultipartFile multipartFile) throws IOException {
        String filename = multipartFile.getOriginalFilename();
        InputStream fileInputStream = multipartFile.getInputStream();
        return userService.binaryImageDbStorage(filename, fileInputStream);
    }

    //在mysql中使用blob存储二进制图片数据
    @RequestMapping(value = "/binaryImageDbRead", method = RequestMethod.GET)
    @ResponseBody
    public boolean binaryImageDbRead(String id) {
        return userService.binaryImageDbRead(id);
    }


}
