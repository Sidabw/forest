package com.Java.bak.middle.springbootBak.springboot.src.main.java.com.beta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControllerMy {

	@RequestMapping("/user/and")
	public String test(){
		return "hello Spring boot";
	}
}
