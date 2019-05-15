package com.Java.bak.middle.springbootBak.springboot2.src.main.java.com.beta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.beta.pojo.LoginUser;
import com.beta.pojo.User;


@Controller
@RequestMapping("/user")
public class ControllerMy {
	
	private Logger logger = Logger.getLogger(ControllerMy.class);  

	@RequestMapping("/test")
	public ModelAndView test(){
		User user = new User();
		ArrayList<User> arrayList = new ArrayList<User>();
		for(int i =0; i<10;i++){
			arrayList.add(this.setUserColumn(user));
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("arrayList",arrayList);
		modelAndView.setViewName("/index");
		return modelAndView;
	}
	@RequestMapping("/loginTest")
	@ResponseBody
	public Map<String,?> loginTest(HttpServletRequest request){
		logger.info("loginTest...INFO...LEVEL...Test");
		logger.warn("loginTest...WARN...LEVEL...Test");
		logger.error("loginTest...ERROR...LEVEL...Test");
		Map<String,Object> map =new HashMap<String,Object>();
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        if(!userName.equals("") && password!=""){
            LoginUser user =new LoginUser(userName,password);
            request.getSession().setAttribute("user",user);
            map.put("result","1");
        }else{
            map.put("result","0");
        }
        return map;
	}
	
	
	
	public User setUserColumn(User user){
		int nextInt = new Random().nextInt(10);
		user.setName("brew"+nextInt);
		user.setGender("man");
		user.setHobby("sida");
		return user;
	}
}
