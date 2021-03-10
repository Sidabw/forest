/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: WechatPayDemo
 * Author:   feiyi
 * Date:     2020/12/28 2:17 PM
 * Description: WechatPayDemo
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.wx;

import org.junit.Test;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * 〈一句话功能简述〉:
 * 〈WechatPayDemo〉
 *
 * @author feiyi
 * @create 2020/12/28
 * @since 1.0.0
 */
public class WechatPayDemo {

    @Test
    public void test() throws UnknownHostException {
        System.out.println(get32LenRandomStr());
    }

    private static final String RANDOM_BASE_STR = "abcdefghijklmnopqrstuvwxyz0123456789";

    public static String get32LenRandomStr() {
        Random random = new Random();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            int number = random.nextInt(RANDOM_BASE_STR.length());
            result.append(RANDOM_BASE_STR.charAt(number));
        }
        return result.toString().toUpperCase();
    }
}
