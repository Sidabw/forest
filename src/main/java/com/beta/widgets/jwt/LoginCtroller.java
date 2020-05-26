package com.beta.widgets.jwt;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.beta.basic.pojo.LoginUser;

@Controller
@RequestMapping("/jwt")
public class LoginCtroller {

	private static final Integer expire = 7 * 24 * 3600;

	@RequestMapping("/logintest")
	@ResponseBody
	public static String loginTest(HttpServletRequest request) {
		// request.getSession()
		return "hello logintest";
	}

	@RequestMapping("jwtlogin")
	@ResponseBody
	public String login(HttpServletRequest request, HttpServletResponse response) {
		/**
		 * ... login接口：进行用户密码验证
		 * */
		// 产生密钥的base64码
		String base64Secret = Base64.encodeBase64String("secret".getBytes());
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		LoginUser loginUser = new LoginUser();
		// 不会把用户的所有信息都放到jwt token中
		loginUser.setUsername("brew");
		// 最终会把map中的key value 改编为json形式，所以value不能直接写pojo
		hashMap.put("username", loginUser.getUsername());
		// jwt生成完毕
		String jwt = Jwts.builder()
				.signWith(SignatureAlgorithm.HS256, base64Secret)
				.setClaims(hashMap).compressWith(CompressionCodecs.DEFLATE)
				.compact();
		// 获取主域名
		String serverName = request.getServerName();
		Cookie cookie = new Cookie("ACCESS_TOKEN", jwt);
		// 解决cookie跨域访问问题
		cookie.setPath("/");
		cookie.setDomain(serverName);
		cookie.setMaxAge(expire);
		cookie.setHttpOnly(true);//防止XSS攻击
		response.addCookie(cookie);

		return jwt;
	}

	public HttpServletRequest getCurrentRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		return request;
	}

	public static void main(String[] args) {
		// 产生密钥的base64码
		String base64Secret = Base64.encodeBase64String("secret".getBytes());
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		LoginUser loginUser = new LoginUser();
		// 不会把用户的所有信息都放到jwt token中
		loginUser.setUsername("brew");
		// 最终会把map中的key value 改编为json形式，所以value不能直接写pojo
		hashMap.put("username", loginUser.getUsername());
		// jwt生成完毕
		String jwt = Jwts.builder()
				.signWith(SignatureAlgorithm.HS256, base64Secret)
				// 可以直接setPayload,但是setClaims可以进行payload 压缩
				.setClaims(hashMap).compressWith(CompressionCodecs.DEFLATE)
				// setpayload 对 payload进行了两次base64处理
				// .setPayload(Base64.encodeBase64String(JSONObject.toJSONString(hashMap).getBytes()))
				.compact();
		// 必须通过base64Secret才可以解密，所以恶意代码无法解析到用户信息。但是仍不建议把敏感信息放到payload中
		Map<String, Object> loginUserMap = Jwts.parser()
				.setSigningKey(base64Secret).parseClaimsJws(jwt).getBody();
		// 可以在paylod中加入expire，签证时间等并每次走拦截器的时候判断是否超时
		System.out.println(loginUserMap.get("username"));
		/*
		 * System.out.println(jwt); //jwt = jwt + "abc"; //解析报错，JWT validity
		 * cannot be asserted and should not be trusted // "\"和"."都是regex的预定义字符
		 * System.out.println(jwt.split("\\.").length); String base64header =
		 * jwt.split("\\.")[0]; String header = new
		 * String(Base64.decodeBase64(base64header.getBytes()));
		 * System.out.println("header:"+header); String base64payload =
		 * jwt.split("\\.")[1]; System.out.println(base64payload); String
		 * payload = new String(Base64.decodeBase64(base64payload.getBytes()));
		 * System.out.println("payload"+payload); //直接base64decode payload
		 * 得到的是乱码 System.out.println(new
		 * String(Base64.decodeBase64(payload.getBytes())));
		 */
		// String fakeJwts = jwt.split("\\.")[0]+'.'+
		// jwt.split("\\.")[1]+"abc"+'.'+ jwt.split("\\.")[2];同样报错

	}

	@Test
	public void test() {
		/*
		 * HashMap<String, Object> hashMap = new HashMap<String, Object>();
		 * LoginUser loginUser = new LoginUser(); // 不会把用户的所有信息都放到jwt token中
		 * loginUser.setUsername("brew"); // 最终会把map中的key value
		 * 改编为json形式，所以value不能直接写pojo hashMap.put("username",
		 * loginUser.getUsername()); String encodeBase64String =
		 * Base64.encodeBase64String
		 * (JSONObject.toJSONString(hashMap).getBytes());
		 * System.out.println(encodeBase64String); byte[] decodeBase64 =
		 * Base64.decodeBase64(encodeBase64String.getBytes());
		 * System.out.println(new String(decodeBase64));
		 */
	}
}
