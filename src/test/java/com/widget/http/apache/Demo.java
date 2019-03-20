/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: Demo
 * Author:   feiyi
 * Date:     2019/1/21 下午3:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.http.apache;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/1/21
 * @since 1.0.0
 */
public class Demo {

    public static void main(String[] args) throws IOException {
        test();
    }

    //seaweedFS 测试
    public static void test() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://weedfs-filer.zenki.cn/feiyitest/131");
        httpPost.setHeader(new BasicHeader("Accept-Language", "zh-cn"));
        HttpEntity reqEntity = MultipartEntityBuilder.create()
                .setCharset(Charset.forName("UTF-8"))
                .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                .addBinaryBody("132", new FileInputStream(new File("/Users/feiyi/Desktop/sida2.png")))
                .build();

        // 发起请求并返回请求的响应
        httpPost.setEntity(reqEntity);
        CloseableHttpResponse response = httpClient.execute(httpPost);
        System.out.println(response.getStatusLine());
    }
}
