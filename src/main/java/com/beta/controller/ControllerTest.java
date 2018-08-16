
package com.beta.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import com.beta.pojo.User;


@Controller
@RequestMapping("/sida")
public class ControllerTest {
	
	@Value("")
	String path;

	@RequestMapping(value="/brew",method=RequestMethod.POST)
	@ResponseBody
	public String testt(@RequestParam(name="username") String username,String password,String tel){
		System.out.println("username:"+username);
		System.out.println("password:"+password);
		System.out.println("tel:"+tel);
		return "------------------------------------------------------------\r\n"+
				"username:"+username+"password:"+password+"tel:"+tel+
				"\r\n------------------------------------------------------------";
	}

	@RequestMapping(value="/iptest",method=RequestMethod.GET)
	@ResponseBody
	public String testIp(HttpServletRequest request){
		String xforwardedfor = request.getHeader("x-forwarded-for");
		String remoteAddr = request.getRemoteAddr();
		return "xforwardedfor:"+xforwardedfor+"----"+"remoteAddr:"+remoteAddr;
	}
}
