/**
 * Copyright (C), 2018-2018, zenki.ai
 * FileName: Demo
 * Author:   feiyi
 * Date:     2018/11/20 下午5:29
 * Description: mongo测试使用类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.db.mongo;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 〈一句话功能简述〉:
 * 〈mongo测试使用类
 * pom开启mongo依赖
 * 〉
 *
 * @author feiyi
 * @create 2018/11/20
 * @since 1.0.0
 */
public class Demo {

    private static final Logger LOGGER = LoggerFactory.getLogger(Demo.class);
    @Test
    public void test() {
//        MongoCollection<Document> collection = MongoUtil.getCollection("zk_unstructure_data", "gonggao_structure_data");
        MongoClient mongoClient = MongoUtil.getMongoClient();
        MongoCollection<Document> collection = mongoClient.getDatabase("demo").getCollection("demo1");

//        MongoUtil.aggs(collection);
        MongoUtil.aggs2(collection);

        collection.find(Document.parse(""));
    }

    private static final String originStr = "{\n" +
            "        \"_id\" : \"7a49d9a3014b4523b6fbf96a730bdb8f\",\n" +
            "        \"err_msg\" : \"model method [proceed] invoke failed! cur model name : 比较过滤器, msg :compare not passed.symbol <=, val1 2019-09-0100:00:00,val2 2012-04-12 07:43:00\",\n" +
            "        \"main_thread_id\" : \"238--2ebd32761d3a413294ae07e042911d0a\",\n" +
            "        \"model_id\" : \"dbe457a8fa8f422bb6f2f9eb1ea9e8a4\",\n" +
            "        \"proceed_id\" : \"2541c4c9db7c47159898697c7981b38f\",\n" +
            "        \"gmt8_modified\" : \"2020-09-18 21:32:26:595\",\n" +
            "        \"gmt8_created\" : \"2020-09-18 21:32:26:595\",\n" +
            "        \"is_delete\" : 0\n" +
            "    }";
    @Test
    public void test2(){
        MongoClient localhost = new MongoClient("localhost", 27001);
        MongoCollection<Document> models = localhost.getDatabase("sidabw").getCollection("pmc_models");
        Document originDoc = Document.parse(originStr);
        for (int i = 0; i< 10000000; i++) {
            originDoc.put("_id", UUID.randomUUID().toString().replaceAll("-", ""));
            originDoc.put("main_thread_id", new Random().nextInt(500) + " - " + UUID.randomUUID().toString().replaceAll("-", ""));
            originDoc.put("gmt8_created", getGmt8CreatedRandom());
            models.insertOne(originDoc);
            System.out.println("models.insertOne(originDoc), -- > " + i);
        }
    }
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

    private String getGmt8CreatedRandom() {
        //随机
        //1598893326000 2020-09-01 01:02:06:000
        //1601481599999 2020-09-30 23:59:59:999
        //中间相隔 2588273999
        int i = new Random().nextInt(258827399);
        long i2 = 1598893326000L + i;
        Date date = new Date(i2);
        return DATE_FORMAT.format(date);
    }

    @Test
    public void t3(){
        System.out.println(1601481599999L - 1598893326000L);
    }

    @Test
    public void t4() throws JsonProcessingException {
        Sida sida = new Sida();
        sida.setName("aaa");
        System.out.println(JSONObject.toJSONString(sida));

        System.out.println(new ObjectMapper().writeValueAsString(sida));

        System.out.println("⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇");

        HashMap<String, String> map = new HashMap<>();
        map.put("a", "av");
        map.put("v", null);
        System.out.println(JSONObject.toJSONString(map));
        System.out.println(new ObjectMapper().writeValueAsString(map));
    }

}

class Sida {
    private String name;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
