package com.beta.basic.controller.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userSwagger")
@Api("ControllerSwagger相关api")
public class ControllerSwagger {
	  @ApiOperation("获取用户信息")
	    @ApiImplicitParams({
	        @ApiImplicitParam(paramType="header",name="username",dataType="String",required=true,value="用户的姓名",defaultValue="zhaojigang"),
	        @ApiImplicitParam(paramType="query",name="password",dataType="String",required=true,value="用户的密码",defaultValue="wangna")
	    })
	    @ApiResponses({
	        @ApiResponse(code=400,message="请求参数没填好"),
	        @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	    })
	@RequestMapping(value="/getUserSwagger",method=RequestMethod.GET)
	public String swaggerTest1(){
		String returnString = "";
		return returnString;
	}
	  
	  
	  
}
