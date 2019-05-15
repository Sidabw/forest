package com.Java.bak.middle.WebTs.src.com.zpark.web;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zpark.pojo.User;

import net.sf.json.JSONObject;

public class JsonDemo extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader reader = req.getReader();
		StringBuffer json = new StringBuffer();
		String line=null;
		while((line=reader.readLine())!=null){
			json.append(line);
		}
		String jsonStr = json.toString();
		//将json格式的字符串变为json对象
		JSONObject jsonObject = JSONObject.fromObject(jsonStr);
		//将json对象转为需要的Bean对象
		User u=(User) JSONObject.toBean(jsonObject,User.class);
		//将json字符串传递回ajax页面
		resp.getWriter().print(jsonStr);
		System.out.println(u);
	}
}
