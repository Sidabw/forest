
package com.beta.basic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


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


    @RequestMapping(value="/sida",method=RequestMethod.POST)
    @ResponseBody
    public String sida(@RequestBody ClassOut request){
        return null;
    }

}
