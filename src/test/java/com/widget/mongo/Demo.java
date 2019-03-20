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
        MongoCollection<Document> collection = MongoUtil.getCollection("zk_unstructure_data", "gonggao_structure_data");
//        insert(collection);
        //updateByFilter(collection);
//        deleteByFilter(collection);
        findAll(collection);

    }
    private void insert(MongoCollection<Document> mongoCollection){
        JSONObject jsonIn = new JSONObject();
        jsonIn.put("age",10000000000L);
        JSONArray array = new JSONArray();
        array.add(jsonIn);
        String json = "{\n" +
                "    \"_id\" : \"AN201812181272094638__gaoguancizhi\",\n" +
                "    \"segment_ids\" : [ \n" +
                "        \"AN201812181272094638_1_0\"\n" +
                "    ],\n" +
                "    \"gmt8_created\" : \"2018-12-19 21:31:21:230\",\n" +
                "    \"group_id\" : \"gonggao\",\n" +
                "    \"model_id\" : \"gaoguancizhi\",\n" +
                "    \"doc_id\" : \"AN201812181272094638\",\n" +
                "    \"content\" : [ \n" +
                "        {\n" +
                "            \"values\" : {\n" +
                "                \"successor\" : {\n" +
                "                    \"org\" : [ \n" +
                "                        {\n" +
                "                            \"seg\" : \"AN201812181272094638_1_0\",\n" +
                "                            \"offset\" : 10,\n" +
                "                            \"org\" : \"董事会                                   \",\n" +
                "                            \"block\" : 11\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"normal\" : {\n" +
                "                        \"successor\" : \"董事会\",\n" +
                "                        \"err_msg\" : \"\",\n" +
                "                        \"error\" : 0\n" +
                "                    }\n" +
                "                },\n" +
                "                \"h_name\" : {\n" +
                "                    \"org\" : [ \n" +
                "                        {\n" +
                "                            \"seg\" : \"AN201812181272094638_1_0\",\n" +
                "                            \"offset\" : 42,\n" +
                "                            \"org\" : \"郭卓才\",\n" +
                "                            \"block\" : 4\n" +
                "                        }, \n" +
                "                        {\n" +
                "                            \"seg\" : \"AN201812181272094638_1_0\",\n" +
                "                            \"offset\" : 97,\n" +
                "                            \"org\" : \"，郭卓才\",\n" +
                "                            \"block\" : 4\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"normal\" : {\n" +
                "                        \"h_name\" : \"郭卓才，郭卓才\",\n" +
                "                        \"err_msg\" : \"\",\n" +
                "                        \"error\" : 0\n" +
                "                    }\n" +
                "                },\n" +
                "                \"gender\" : {\n" +
                "                    \"org\" : [ \n" +
                "                        {\n" +
                "                            \"seg\" : \"AN201812181272094638_1_0\",\n" +
                "                            \"offset\" : 45,\n" +
                "                            \"org\" : \"先生\",\n" +
                "                            \"block\" : 4\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"normal\" : {\n" +
                "                        \"gender\" : \"先生\",\n" +
                "                        \"err_msg\" : \"\",\n" +
                "                        \"error\" : 0\n" +
                "                    }\n" +
                "                },\n" +
                "                \"resignation_position\" : {\n" +
                "                    \"org\" : [ \n" +
                "                        {\n" +
                "                            \"seg\" : \"AN201812181272094638_1_0\",\n" +
                "                            \"offset\" : 39,\n" +
                "                            \"org\" : \"董事长\",\n" +
                "                            \"block\" : 4\n" +
                "                        }, \n" +
                "                        {\n" +
                "                            \"seg\" : \"AN201812181272094638_1_0\",\n" +
                "                            \"offset\" : 109,\n" +
                "                            \"org\" : \"董事\",\n" +
                "                            \"block\" : 4\n" +
                "                        }, \n" +
                "                        {\n" +
                "                            \"seg\" : \"AN201812181272094638_1_0\",\n" +
                "                            \"offset\" : 116,\n" +
                "                            \"org\" : \"法定代表人\",\n" +
                "                            \"block\" : 4\n" +
                "                        }, \n" +
                "                        {\n" +
                "                            \"seg\" : \"AN201812181272094638_1_0\",\n" +
                "                            \"offset\" : 122,\n" +
                "                            \"org\" : \"董事会战略委员会委员\",\n" +
                "                            \"block\" : 4\n" +
                "                        }, \n" +
                "                        {\n" +
                "                            \"seg\" : \"AN201812181272094638_1_0\",\n" +
                "                            \"offset\" : 34,\n" +
                "                            \"org\" : \"独立董事\",\n" +
                "                            \"block\" : 6\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"normal\" : {\n" +
                "                        \"err_msg\" : \"\",\n" +
                "                        \"resignation_position\" : \"董事长董事法定代表人董事会战略委员会委员独立董事\",\n" +
                "                        \"error\" : 0\n" +
                "                    }\n" +
                "                },\n" +
                "                \"resignation_time\" : {\n" +
                "                    \"org\" : [ \n" +
                "                        {\n" +
                "                            \"seg\" : \"AN201812181272094638_1_0\",\n" +
                "                            \"offset\" : 5,\n" +
                "                            \"org\" : \"002502\",\n" +
                "                            \"block\" : 0\n" +
                "                        }, \n" +
                "                        {\n" +
                "                            \"seg\" : \"AN201812181272094638_1_0\",\n" +
                "                            \"offset\" : 52,\n" +
                "                            \"org\" : \"091\",\n" +
                "                            \"block\" : 0\n" +
                "                        }, \n" +
                "                        {\n" +
                "                            \"seg\" : \"AN201812181272094638_1_0\",\n" +
                "                            \"offset\" : 26,\n" +
                "                            \"org\" : \"2018年12月17日\",\n" +
                "                            \"block\" : 4\n" +
                "                        }, \n" +
                "                        {\n" +
                "                            \"seg\" : \"AN201812181272094638_1_0\",\n" +
                "                            \"offset\" : 62,\n" +
                "                            \"org\" : \"月十九日\",\n" +
                "                            \"block\" : 11\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"normal\" : {\n" +
                "                        \"err_msg\" : \"输入格式不正确\",\n" +
                "                        \"resignation_time\" : \"0025020912018年12月17日月十九日\",\n" +
                "                        \"error\" : 1\n" +
                "                    }\n" +
                "                }\n" +
                "            },\n" +
                "            \"mask\" : 0\n" +
                "        }\n" +
                "    ],\n" +
                "    \"gmt8_modified\" : \"2018-12-19 21:31:21:230\",\n" +
                "    \"is_delete\" : 0\n" +
                "}";
        Document parse = Document.parse(json);
        Document document = new Document()
                .append("_id", "ssssadfasdfasdfa11111111s11212")
                .append("name", "luobotou")
                .append("age", array)
//                .append("is_delete")
                .append("list_test", Arrays.asList(1, 2, 3, 4, 5));
        mongoCollection.insertOne(parse);
    }
    private void updateByFilter(MongoCollection<Document> mongoCollection){
        //这里的写法类似原生的mongo语句；这里表示只修改负责条件的document的name字段的值

        mongoCollection.updateOne(Filters.eq("ObjectId","jlsdjflkasjdfljsadl"),
                                    new Document("$set", new Document("name","luobotouo")));
    }
    private void deleteByFilter(MongoCollection<Document> mongoCollection){
        DeleteResult result = mongoCollection.deleteOne(Filters.eq("_id", "5bf670f061ea9781177e7743"));
        System.out.println(String.format("总共删除了%s条记录",result.getDeletedCount()));
        DeleteResult result2 = mongoCollection.deleteOne(new Document().append("_id", new ObjectId("5bf66fc461ea9781177e7742")));
        System.out.println(String.format("总共删除了%s条记录",result2.getDeletedCount()));
    }
    private void findAll(MongoCollection<Document> mongoCollection){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("_id", "AN201901101283782382__dongshihuijueyi");
        Bson parse = Document.parse(jsonObject.toJSONString());
        FindIterable<Document> documents = mongoCollection.find(parse);
        for (Document doc : documents) {
            System.out.println(doc.toJson());
        }
        MongoCursor<Document> iterator = documents.iterator();
        while (iterator.hasNext()){
            Document eachModel = iterator.next();
//            eachModel.keySet().stream().forEach(e -> System.out.println(eachModel.get(e)));
            System.out.println("------------------------");
            JsonWriterSettings build = JsonWriterSettings.builder()
                    .outputMode(JsonMode.EXTENDED)
                    .doubleConverter((Double value, StrictJsonWriter writer) -> writer.writeString(Double.toString(value)))
                    .int64Converter((Long value, StrictJsonWriter writer) -> writer.writeString(Long.toString(value)))
                    .int32Converter((Integer value, StrictJsonWriter writer) -> writer.writeNumber(Integer.toString(value)))
                    .build();
//            JsonWriterSettings build1 = JsonWriterSettings.builder().outputMode(JsonMode.STRICT).build();
            String jsonStr = eachModel.toJson(build);
            JSONObject jsonObject1 = JSONObject.parseObject(jsonStr);
            System.out.println(jsonStr);
            System.out.println(jsonObject1.get("is_delete").getClass());
            System.out.println(JSONObject.parseObject(jsonStr).get("age"));
        }
        long count = mongoCollection.count();
        System.out.println(String.format("共有%s条记录", count));
    }
    //条件查询 在find里加Filters.eq 或其他即可
}
