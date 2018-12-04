/**
 * Copyright (C), 2018-2018, zenki.ai
 * FileName: Demo
 * Author:   feiyi
 * Date:     2018/12/4 下午3:28
 * Description: okhttp
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.okhttp;

import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉:
 * 〈okhttp
 *  主要测试常规的get/post/form/header append/asyn
 *  无关html
 *  有关文件上传、分块请求等赞不做测试。〉
 *
 * @author feiyi
 * @create 2018/12/4
 * @since 1.0.0
 */
public class Demo {
    private static Logger logger = LoggerFactory.getLogger(Demo.class);
    public static void main(String[] args) throws IOException {
//        get("http://localhost:8018/dp/v1/source/getSug");
        postNormal("http://localhost:8018/dp/v1/login");
        postForm("http://localhost:8018/dp/v1/login");
    }
    public static void get(String url) throws IOException {
        StringBuffer urlAndParam = new StringBuffer(url).append("?").append("searchText=\"富士康\"").append("&").append("queryType=\"company\"");
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(urlAndParam.toString()).build();
        Response response = client.newCall(request).execute();
        logger.info("response body --> {}",response.body().string());
    }

    public static void postNormal(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
//        MediaType mediaType = MediaType.parse("text/plain; charset=utf-8");   //普通的字符串post request
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "feiyi");
        jsonObject.put("password", "Feiyizenki123");
        String param = jsonObject.toJSONString();
        RequestBody body = RequestBody.create(mediaType, param);
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = client.newCall(request).execute();
        logger.info("response body --> {}",response.body().string());
    }

    public static void postForm(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        FormBody body = new FormBody.Builder()
                .add("name", "feiyi")
                .add("password", "Feiyizenki123")
                .build();
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = client.newCall(request).execute();
        logger.info("response body --> {}",response.body().string());
    }

    public static void addTimeout(){
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build();
    }

    public static void addHeader(RequestBody body){
        new Request.Builder()
                .url("")
                .addHeader("content-type","application/x-www-form-urlencoded")
                .addHeader("", "")
                .addHeader("", "")
                .post(body)
                .build();
    }

    public static void asyn(OkHttpClient client, Request request){
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                logger.info("response body --> {}",response.body().string());
            }
        });
    }
}
