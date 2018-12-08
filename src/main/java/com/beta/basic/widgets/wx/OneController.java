package com.beta.basic.widgets.wx;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.beta.basic.widgets.wx.pojo.AccessToken;
import com.beta.basic.widgets.wx.pojo.User;
import com.beta.basic.widgets.wx.pojo.WxPojo;
import com.beta.basic.widgets.wx.service.WeChatService;
import com.beta.basic.widgets.wx.util.MyX509TrustManager;
import com.beta.basic.widgets.wx.util.SignUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.ConnectException;
import java.net.URL;
import java.util.Map;

@Controller
public class OneController {

	public static final String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	public static final String appid = "wxc7ad201771fabfaa";
	public static final String appsecret = "2ff6d0fcd279ef4720a78f643ccf1b74";
	public static final String appidTestCount = "wx3b15c9af3dd48316";
	public static final String appsecretTestCount = "cc64836e45b011313aaf422c66edfbaa";

	@Autowired
    WeChatService weChatService;

	@RequestMapping("/oneController")
	@ResponseBody
	public String index(@RequestParam String name) {

		return "helllo  Spring Boot:::" + name + "|||";
	}

	@RequestMapping(value = "/hi", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public String testt(@RequestBody Map<String, Object> reqMap) {
		System.out.println(reqMap.get("name"));
		return "nihao" + reqMap.get("name") + "你的电话是tel:" + reqMap.get("tel");
	}

	@RequestMapping("/hi3")
	@ResponseBody
	public String testtt(User user) {
		System.out.println(user.getName());
		return "nihao" + user.getName() + "你的电话是tel:" + user.getTel();
	}

	@RequestMapping("/hi2")
	public String testtt(WxPojo pojo, HttpServletRequest request,
                         HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		// HttpServletResponse response = null;
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println("jinlaile");
		System.out.println(pojo.getEchostr());
		// 为true则代表请求来自微信服务器，这时候需要将请求带来的echostr原样返回
		boolean checkSignature = SignUtil.checkSignature(pojo.getSignature(),
				pojo.getTimestamp(), pojo.getNonce());
		System.out.println(checkSignature);
		PrintWriter out = response.getWriter();
		out.print(pojo.getEchostr());
		out.print(weChatService.weixinPost(request));
		out.close();
		// 获取access_token
		AccessToken accessToken = getAccessToken(appidTestCount, appsecretTestCount);
		System.out.println(accessToken);
		return "NewFile";
	}
	 public static AccessToken getAccessToken(String appid, String appsecret) {  
	        AccessToken accessToken = null;  
	  
	        String requestUrl = access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);  
	        JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
	        // 如果请求成功  
	        if (null != jsonObject) {  
	            try {  
	                accessToken = new AccessToken();  
	                accessToken.setToken(jsonObject.getString("access_token"));  
	                accessToken.setExpiresIn(jsonObject.getInteger("expires_in"));  
	            } catch (JSONException e) {
	                accessToken = null;  
	                // 获取token失败  
	                //log.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getInteger("errcode"), jsonObject.getString("errmsg"));  
	            }  
	        }  
	        return accessToken;  
	    }  
	public static JSONObject httpRequest(String requestUrl,
                                         String requestMethod, String outputStr) {

		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url
					.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);

			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();

			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			jsonObject = JSONObject.parseObject(buffer.toString());
		} catch (ConnectException ce) {
			// log.error("Weixin server connection timed out.");
		} catch (Exception e) {
			// log.error("https request error:{}", e);
		}
		return jsonObject;
	}

}
