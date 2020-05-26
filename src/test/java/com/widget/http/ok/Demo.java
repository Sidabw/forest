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
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
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
        postMultipartUpload2();
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
//        FileInputStream fileInputStream = new FileInputStream(new File("/Users/feiyi/Desktop/zenki-note.txt"));
        FileInputStream fileInputStream = new FileInputStream(new File("/Users/feiyi/Desktop/handsome_guy.jpg"));
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

//        FileInputStream fileInputStream2 = new FileInputStream(new File("/Users/feiyi/Desktop/models-proceed-demo.png"));
//        int length2 = 0;
//        byte[] temp2 = new byte[1024];
//        ArrayList<Byte> list2 = new ArrayList<>();
//        while ((length2 = fileInputStream2.read(temp)) != -1){
//            for (int i = 0 ; i<length2 ; i ++){
//                list2.add(temp2[i]);
//            }
//        }
//        Object[] objects2 = list2.toArray();
//        byte[] bytes2 = new byte[objects2.length];
//        for (int i = 0 ; i < objects2.length ; i ++){
//            bytes2[i] = ((Byte)objects2[i]).byteValue();
//        }

        RequestBody requestBody2 = new MultipartBody.Builder()
                .addPart(
                        Headers.of("Content-Disposition",
                                "form-data; name=\"file\""),
                        RequestBody.create(null, bytes))
               .build();
        Request request = new Request.Builder()
                .header("Accept-Language", "zh-cn")
                .url("http://localhost:8020/dp/api/v1/pmc/proceed/filetest")
                .post(requestBody2)
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.message());
    }

    //多文件上传
    public static void postMultipartUpload2() throws IOException {
        File file = new File("/Users/feiyi/Desktop/handsome_guy.jpg");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes =inputStreamToByte(fileInputStream);
        //TODO  OkHttp official example. practice. https://square.github.io/okhttp/recipes/#posting-a-multipart-request
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", "file",
                        RequestBody.create(null, bytes))
//                .addFormDataPart("file", "models-proceed-demo.png",
//                RequestBody.create(MediaType.parse("image/png"), new File("/Users/feiyi/Desktop/models-proceed-demo.png")))
                .build();

        Request request = new Request.Builder()
                .url("http://localhost:8020/dp/api/v1/pmc/proceed/aaaa")
                .post(requestBody)
                .build();
        okHttpClient.newCall(request).execute();
    }
    private static byte[] inputStreamToByte(InputStream inputStream) throws IOException {
        int length ;
        byte[] temp = new byte[1024];
        ArrayList<Byte> list = new ArrayList<>();
        while ((length = inputStream.read(temp)) != -1){
            for (int i = 0 ; i<length ; i ++) {
                list.add(temp[i]);
            }
        }
        Object[] objects = list.toArray();
        byte[] bytes = new byte[objects.length];
        for (int i = 0 ; i < objects.length ; i ++){
            bytes[i] = ((Byte)objects[i]).byteValue();
        }
        return bytes;
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

    public static void asyn(OkHttpClient client, Request request) {
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

    @Test
    public void test() throws IOException {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .header("Cookie","UM_distinctid=16d7c40ff5e769-011fea921754e6-38607501-1aeaa0-16d7c40ff5f4ad; zenki.ops=MTU3MzY5Njk5OXxEdi1CQkFFQ180SUFBUXdCRUFBQWN2LUNBQUVGZEc5clpXNEdjM1J5YVc1bkRGOEFYWHNpWjJsMlpXNU9ZVzFsSWpvaTZJS2w2WUdYSWl3aWN5STZJbU00TVRsaFlUUTNOelpqT1RJeU56QTNaakEzWTJVd1l6ZGlZbUU1TURaaUlpd2lkR2x0WlNJNk1UVTNNelk1TmprNU9Td2lkV2xrSWpvaVptVnBlV2tpZlE9PXzGfznVis3g7pNtMi9QlhPUK8_6r5k6YRfzf1O9TYIeyg==; zenki.act=MTU3MzcwMjQ1NnxEdi1CQkFFQ180SUFBUXdCRUFBQV83WF9nZ0FCQlhSdmEyVnVCbk4wY21sdVp3el9vUURfbm5zaWFXUWlPamN6TkRVc0luQm9iMjVsYm5WdFltVnlJam9pTVRjMk1UQXhOekEyTWpJaUxDSnpJam9pTjJOak5UTmlZV1l6TWpSa09UaGlNelEzTlRRNU1UZzBZak14TVRWaFl6TWlMQ0owYVcxbElqb3hOVGN6TnpBeU5EVTJMQ0oxYVdRaU9pSTRNRFkzTVRFeFptVm1OamxpTnpReVkyVTVObUpsWTJJeVpUa3lNR05rWWlJc0luVnpaWEp1WVcxbElqb2lXRlZKVjBsTFVpSjl8v4RunzfXwPvlm_o5cq5-YAUu5It7Wd5oFCkDUuvBigE=")
                .url("http://localhost:8020/dp/api/v1/pmc/proceed/test").build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().contentType());
        System.out.println(response.header("Content-Disposition"));
//        ResponseBody body = response.body();
//        InputStream inputStream = body.byteStream();
//        System.out.println(inputStream.available());
//        System.out.println(inputStream.read());
//        System.out.println(response.body().string());
    }


}
