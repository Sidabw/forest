/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: Demo
 * Author:   feiyi
 * Date:     2019/5/8 10:05 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.bak.messagecode;

import org.junit.Test;

import java.security.MessageDigest;
import java.util.Date;
import java.util.Random;

/**
 * 〈一句话功能简述〉:
 * 〈本demo是基于 网易云信 搭建
 *  api: https://dev.yunxin.163.com/docs/product/%E7%9F%AD%E4%BF%A1/%E7%9F%AD%E4%BF%A1%E6%8E%A5%E5%8F%A3%E6%8C%87%E5%8D%97
 *  home: https://app.yunxin.163.com/index#/app/info/15671052
 *  terminal:
 *  curl -X POST -H "AppKey: 0a14f3d45f2000252264b4ad4ab38ae6" -H "CurTime: 1557287936115"
 *  -H "CheckSum: f3aa41d3a67445ead7626255fcbb3fd29e17654c" -H "Nonce: -1937279936"
 *  -H "Content-Type: application/x-www-form-urlencoded" -d 'mobile=17610170622' 'https://api.netease.im/sms/sendcode.action'
 *  注意：使用curl时，要求put full url whit in double quote。 就是在二重认真quote时，把上边输入的命令再输入一边..
 * 〉
 *
 * @author feiyi
 * @create 2019/5/8
 * @since 1.0.0
 */
public class Demo {

    private static final String appSecret = "1ff941bbeede";

    @Test
    public void test () {
        String nonce = new Integer(new Random().nextInt()).toString();
        System.out.println("nonce: " + nonce);
        String curTime = new Long(new Date().getTime()).toString();
        System.out.println("curTime: "+curTime);
        System.out.println("checkSum: " + getCheckSum(appSecret, nonce, curTime));
    }

    // 计算并获取CheckSum
    public static String getCheckSum(String appSecret, String nonce, String curTime) {
        return encode("sha1", appSecret + nonce + curTime);
    }

    // 计算并获取md5值
    public static String getMD5(String requestBody) {
        return encode("md5", requestBody);
    }

    private static String encode(String algorithm, String value) {
        if (value == null) {
            return null;
        }
        try {
            MessageDigest messageDigest
                    = MessageDigest.getInstance(algorithm);
            messageDigest.update(value.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
    private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

}
