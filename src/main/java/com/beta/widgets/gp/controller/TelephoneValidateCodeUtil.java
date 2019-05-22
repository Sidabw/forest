/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: TelephoneValidateCodeUtil
 * Author:   feiyi
 * Date:     2019/5/22 8:01 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.widgets.gp.controller;

import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/5/22
 * @since 1.0.0
 */
public class TelephoneValidateCodeUtil {

    public static Map<String, String> allCode = new HashMap<>();

    private static final String appSecret = "1ff941bbeede";

    private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    private static final String yunxinUrl = "https://api.netease.im/sms/sendcode.action";

    private static final String yunxinAppkey = "0a14f3d45f2000252264b4ad4ab38ae6";

    private static Logger logger = LoggerFactory.getLogger(TelephoneValidateCodeUtil.class);

    public static String getTelephoneValidateCode(String phoneNum) throws NoSuchAlgorithmException, IOException {
        String nonce = new Integer(new Random().nextInt()).toString();
        String curTime = new Long(new Date().getTime()).toString();
        String checkSum = getCheckSum(appSecret, nonce, curTime);
        logger.debug("nonce: {}, curTime: {}, checkSum: {}", nonce, curTime, checkSum);
        String code = postNormal(nonce, curTime, checkSum, phoneNum);
        allCode.put(phoneNum, code);
        return code;
    }

    private static String postNormal(String nonce, String curTime, String checkSum, String phoneNum) throws IOException {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("AppKey", yunxinAppkey);
        jsonObject.put("CurTime", curTime);
        jsonObject.put("CheckSum", checkSum);
        jsonObject.put("Nonce", nonce);
        jsonObject.put("mobile", phoneNum);
        String param = jsonObject.toJSONString();
        RequestBody body = RequestBody.create(mediaType, param);
        Request request = new Request.Builder().url(yunxinUrl).post(body).build();
        Response response = client.newCall(request).execute();
        String resBodyStr = response.body().string();
        logger.info("response body --> {}", resBodyStr);
        JSONObject resBodyJson = JSONObject.parseObject(resBodyStr);
        if (resBodyJson.getInteger("code") == 200) {
            logger.error("请求获取验证码错误");
            return null;
        }
        return resBodyJson.getString("obj");
    }

    // 计算并获取CheckSum
    private static String getCheckSum(String appSecret, String nonce, String curTime) throws NoSuchAlgorithmException {
        return encode("sha1", appSecret + nonce + curTime);
    }

    // 计算并获取md5值
    private static String getMD5(String requestBody) throws NoSuchAlgorithmException {
        return encode("md5", requestBody);
    }

    private static String encode(String algorithm, String value) throws NoSuchAlgorithmException {
        if (value == null) {
            return null;
        }
        MessageDigest messageDigest
                = MessageDigest.getInstance(algorithm);
        messageDigest.update(value.getBytes());
        return getFormattedText(messageDigest.digest());
    }
    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }


}
