/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: ApacheHttpUtils
 * Author:   feiyi
 * Date:     2020/10/15 10:37 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.http.apache;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2020/10/15
 * @since 1.0.0
 */
public class ApacheHttpUtils {

    private static final Logger log = LoggerFactory.getLogger(ApacheHttpUtils.class);

    private static final CloseableHttpClient httpClient = HttpClients.createDefault();

    public static String executePost(String url, Object reqBody) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        StringEntity stringEntity = new StringEntity(objectMapper.writeValueAsString(reqBody));
        stringEntity.setContentEncoding("utf-8");
        //发送json数据需要设置contentType
        stringEntity.setContentType("application/json");
        httpPost.setEntity(stringEntity);
        log.info("prepare request, request line: {}", httpPost);
        log.info("prepare request, request body: {}", JSONObject.toJSONString(reqBody));

        //发送请求
        CloseableHttpResponse response = httpClient.execute(httpPost);
        String string = null;
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            HttpEntity entity = response.getEntity();
            string = EntityUtils.toString(entity, "utf-8");
        }
        //关闭资源
        response.close();
        log.info("request finished, response body: {}", string);
        return string;
    }

    public static void main(String[] args) throws IOException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("a", "a");
        map.put("v", "v");
        map.put("b", 1);
        map.put("aaa", null);
        map.put("ddd", null);
        System.out.println(map.keySet().size());
        executePost("http://127.0.0.1:8017/test/reqTestParams", map);
    }

}
