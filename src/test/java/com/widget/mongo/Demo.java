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
package com.widget.mongo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.json.JsonMode;
import org.bson.json.JsonWriterSettings;
import org.bson.json.StrictJsonWriter;
import org.bson.types.ObjectId;
import org.junit.Test;

import java.util.Arrays;

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

    @Test
    public void test(){
//        MongoCollection<Document> collection = MongoUtil.getCollection("zk_unstructure_data", "gonggao_structure_data");
        MongoClient mongoClient = MongoUtil.getMongoClient();
        MongoCollection<Document> collection = mongoClient.getDatabase("demo").getCollection("demo1");

//        MongoUtil.aggs(collection);
        MongoUtil.aggs2(collection);



    }


   

}
