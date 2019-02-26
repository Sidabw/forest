package com.beta.widgets.wx;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.beta.widgets.wx.pojo.AccessToken;
import com.beta.widgets.wx.pojo.User;
import com.beta.widgets.wx.pojo.WxPojo;
import com.beta.widgets.wx.service.WeChatService;
import com.beta.widgets.wx.util.MessageUtil;
import com.beta.widgets.wx.util.MyX509TrustManager;
import com.beta.widgets.wx.util.SignUtil;
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
@RequestMapping("/wechat")
public class OneController {

	public static final String get_access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	public static final String get_user_info_url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	public static final String appid = "wxc7ad201771fabfaa";
	public static final String appsecret = "2ff6d0fcd279ef4720a78f643ccf1b74";
	//通过接口测试号的appid 和 appSecret 获取access_token
	public static final String appidTestCount = "wx3cbe13f83ffac815";
	public static final String appsecretTestCount = "475232751d242533109f77959e5d00bb";

	@Autowired
    WeChatService weChatService;

	@RequestMapping("/hi")
	public Object testtt(WxPojo pojo, HttpServletRequest request,
                         HttpServletResponse response) throws Exception {
        //不设置编码格式的话会返回空
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
//		// 为true则代表请求来自微信服务器，这时候需要将请求带来的echostr原样返回
		boolean checkSignature = SignUtil.checkSignature(pojo.getSignature(),
				pojo.getTimestamp(), pojo.getNonce());
        if (!checkSignature) {
            return null;
        }
        // xml请求解析
        Map<String, String> requestMap = MessageUtil.xmlToMap(request);
        // 发送方帐号（open_id）
        String openId = requestMap.get("FromUserName");
		// 获取access_token
		AccessToken accessToken = getAccessToken(appid, appsecret);
		getCurrentUserInfo(accessToken, openId);
		PrintWriter out = response.getWriter();
		out.print(pojo.getEchostr());
        String resContent = weChatService.weixinPost(requestMap);
        out.print(resContent);
		out.close();
        return null;
	}

    private void getCurrentUserInfo(AccessToken accessToken, String openId) {
        String requestUrl = get_user_info_url.replace("ACCESS_TOKEN", accessToken.getToken()).replace("OPENID", openId);
        JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
        System.out.println(jsonObject);
    }

    public static AccessToken getAccessToken(String appid, String appsecret) {
	        AccessToken accessToken = null;  
	        String requestUrl = get_access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
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

	/**
	 * 功能描述:
	 * 〈发送http请求〉
	 *
	 * @return:
	 * @since: 1.0.0
	 * @Author:feiyi
	 * @Date: 2019/2/25 8:05 PM
	 */
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
