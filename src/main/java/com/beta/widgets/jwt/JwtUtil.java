/**
 * Copyright (C), 2018-2018, zenki.ai
 * FileName: JwtUtil
 * Author:   feiyi
 * Date:     2018/11/5 下午2:26
 * Description: JWT工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.widgets.jwt;

import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;

/**
 * 〈一句话功能简述〉:
 * 〈JWT工具类〉
 *
 * @author feiyi
 * @create 2018/11/5
 * @since 1.0.0
 */
public class JwtUtil {

    public static HashMap<String, String> users = new HashMap<>();
    //加密私钥
    private static final String SALT = "secret.zenki.ai";
    //过期时间，毫秒值，12小时，12小时后cookie失效，token失效
    private static final long EXPIREMILLIS = 1000*60*60*12;
    //JWT签发机构
    private static final String ISS = "zenki.ai";

    public static String createJWT(String id, String subject) {

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SALT);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        JwtBuilder builder = Jwts.builder().setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .setIssuer(ISS)
                .signWith(signatureAlgorithm, signingKey);

        if (EXPIREMILLIS >= 0) {
            long expMillis = nowMillis + EXPIREMILLIS;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        String compact = builder.compact();
        return compact;
    }
    //Sample method to validate and read the JWT
//    public static User parseJWT(String jwt) throws Exception {
//        if(StringUtils.isEmpty(jwt))
//            return null;
//        //This line will throw an exception if it is not a signed JWS (as expected)
//        Claims claims = Jwts.parser()
//                .setSigningKey(DatatypeConverter.parseBase64Binary(SALT))
//                .parseClaimsJws(jwt).getBody();
//        User user = JSONObject.parseObject(claims.getSubject(), User.class);
//        String singleUserJwt = CookieHelper.getCookieValueByName(Const.SINGLEUSERTOKEN);
//        String jwtExisted = users.get(user.getId().toString());
//        if(!singleUserJwt.equals(jwtExisted))
//            //已经被别人挤下来了，需要重新登录
//            throw new Exception("someone else logined with your account!");
//        return user;
//    }

    public static String createSingleUserJwt() {
        Long time = new Date().getTime();
        return createJWT(time.toString(), time.toString());
    }
}
