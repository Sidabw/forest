/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: Demo
 * Author:   feiyi
 * Date:     2019/2/13 8:02 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.http.java;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 〈一句话功能简述〉:
 * 〈使用Java 内置类 发送Http请求〉
 *
 * @author feiyi
 * @create 2019/2/13
 * @since 1.0.0
 */
public class Demo {

    public static void main(String[] args) throws IOException {
        test();
    }

    public static void test() throws IOException {
        URL url = new URL("http://www.baidu.com");
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(10000);//10s
        connection.setReadTimeout(20000);//20s
        connection.connect();
        System.out.println(String.format("response code %s", connection.getResponseCode()));
        InputStream res = connection.getInputStream();
        System.out.println("get result from response input stream ....");
        connection.disconnect();
    }
}
