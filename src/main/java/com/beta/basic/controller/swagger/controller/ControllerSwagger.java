package com.beta.basic.controller.swagger.controller;

import com.alibaba.fastjson.JSONArray;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/userSwagger")
@Api("ControllerSwagger相关api")
public class ControllerSwagger {

    @Autowired
    Environment env;
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
	public String swaggerTest1(String param){
	  	System.out.println("param" + param);
		String returnString = "";
		return returnString;
	}

    @RequestMapping(value="/test",method=RequestMethod.POST)
    public String test(@RequestBody ClassOut out, HttpServletResponse response) {
        System.out.println(out.getPlatId());
        System.out.println(out.getType());
        System.out.println(JSONArray.toJSONString(out.getList()));
        response.setHeader("a", "b");
        response.addHeader("b", "a");
        return "aa";
    }

}
class ClassIn {

    private String manageId;

    private String manageName;

    private String aId;

    public String getManageId() {
        return manageId;
    }

    public void setManageId(String manageId) {
        this.manageId = manageId;
    }

    public String getManageName() {
        return manageName;
    }

    public void setManageName(String manageName) {
        this.manageName = manageName;
    }

    public String getaId() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId = aId;
    }
}
class ClassOut {

    private String platId;

    private String type;

    private List<ClassIn> list;

    public String getPlatId() {
        return platId;
    }

    public void setPlatId(String platId) {
        this.platId = platId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ClassIn> getList() {
        return list;
    }

    public void setList(List<ClassIn> list) {
        this.list = list;
    }
}
