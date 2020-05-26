package com.Java.bak.middle.ssmBak.SSM.src.com.zpark.web.controller;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zpark.service.IUserService;
import com.zpark.util.FtpUtil;
import com.zpark.web.pojo.JsonUser;
import com.zpark.web.pojo.VO;

@Controller
@RequestMapping("/stu2")
public class StudentController2 {
	
	@Resource(name="us")
	private IUserService us;

	@RequestMapping("/test1.do")
	public String test1(){
		return "hello";
	}
	@RequestMapping(value={"/test2.do","/test3.do"})
	public String test2(){
		return "hello";
	}
	/**
	 * 限定请求后台方式
	 * @throws Exception 
	 * @throws ServletException 
	 * */
	@RequestMapping(value="/test4.do",method=RequestMethod.GET)
	public void test4(HttpServletRequest request,HttpServletResponse response) throws ServletException, Exception{
		//正确
		//request.getRequestDispatcher("/jsp/hello.jsp").forward(request, response);
		//正确
		response.sendRedirect("/SSM/jsp/hello.jsp");
	}
	/**
	 * 
	 * */
	@RequestMapping("/jsonTest.do")
	public @ResponseBody JsonUser jsonTest(@RequestBody JsonUser user){
		System.out.println(user);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(4);
		user.setList(list);
		return user;
	}
	@RequestMapping("/uploadTest.do")
	@ResponseBody
	public String uploadTest(VO vo,MultipartFile picFile) throws Exception{
		System.out.println("++++++++++");
		System.out.println(picFile.getSize());
		System.out.println(picFile.getOriginalFilename());
		System.out.println(picFile.getBytes());
		System.out.println(picFile.getInputStream());
		//获取扩展名jpg png...
		//String extension = FilenameUtils.getExtension(picFile.getOriginalFilename());
		//采用UUID生成不重复的文件名
		//String uuid = UUID.randomUUID().toString();
		//InputStream inputStream = picFile.getInputStream();
		//FtpUtil.upload(inputStream, "/etc/vsftpd/");
		
		//FtpUtil.upload(inputStream, "");
		/*保存文件 路径要用反斜杠
		 * 直接将文件保存在用户的本地。类似下载，不过没有提示。
		 * */
		//picFile.transferTo(new File("E:/imgUpload/"+uuid+"."+extension));
		
		
		//将不重复的UUID文件名保存到数据库
		/*vo.setPic(uuid+"."+extension);
		us.update(vo);*/
		
		
		return "hello";
		
	}
}
