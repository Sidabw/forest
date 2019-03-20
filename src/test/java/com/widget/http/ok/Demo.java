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
package com.widget.http.ok;

import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉:
 * 〈okhttp
 *  主要测试常规的get/post/form/header append/asyn/文件上传
 *  无关html
 *  有关分块请求等暂不做测试。〉
 *
 * @author feiyi
 * @create 2018/12/4
 * @since 1.0.0
 */
public class Demo {
    private static Logger logger = LoggerFactory.getLogger(Demo.class);
    public static void main(String[] args) throws IOException {
//        get("http://localhost:8018/dp/v1/source/getSug");
//        postNormal("http://localhost:8018/dp/v1/login");
//        postForm("http://localhost:8018/dp/v1/login");
        postMultipartUpload();

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

    /**
     * 功能描述:
     *  有争议，详细见md of cur package
     * @return:
     * @since: 1.0.0
     * @Author:feiyi
     * @Date: 2019/3/20 8:15 PM
     */
    public static void postMultipartUpload() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("/Users/feiyi/Desktop/zenki-note.txt"));
        int length = 0;
        byte[] temp = new byte[1024];
        ArrayList<Byte> list = new ArrayList<>();
        while ((length = fileInputStream.read(temp)) != -1){
            for (int i = 0 ; i<length ; i ++){
                list.add(temp[i]);
            }
        }
        Object[] objects = list.toArray();
        byte[] bytes = new byte[objects.length];
        for (int i = 0 ; i < objects.length ; i ++){
            bytes[i] = ((Byte)objects[i]).byteValue();
        }
//        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), bytes);
//        MultipartBody body = new MultipartBody.Builder().addFormDataPart("126", "126", requestBody).build();
        RequestBody requestBody2 = new MultipartBody.Builder()
                .addPart(
                        Headers.of("Content-Disposition",
                                "form-data; name=\"128\""),
                        RequestBody.create(null, bytes)).build();
        Request request = new Request.Builder()
                .header("Accept-Language", "zh-cn")
                .url("http://weedfs-filer.zenki.cn/feiyitest/128")
                .post(requestBody2)
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.message());
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
