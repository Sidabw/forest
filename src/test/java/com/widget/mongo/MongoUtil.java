/**
 * Copyright (C), 2018-2018, zenki.ai
 * FileName: MongoUtil
 * Author:   feiyi
 * Date:     2018/11/22 下午6:13
 * Description: util
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.mongo;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.*;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.json.JsonMode;
import org.bson.json.JsonWriterSettings;
import org.bson.json.StrictJsonWriter;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 〈一句话功能简述〉:
 * 〈util〉
 *
 * @author feiyi
 * @create 2018/11/22
 * @since 1.0.0
 */
public class MongoUtil {
    //mongo shell
    //1.
    /*db.getCollection('ps1554085431232_data_source').find().forEach( function(doc){
        db.ps1554085431232_data_source.update({_id: doc._id}, {$set: {is_delete: NumberInt(0)}});
    })*/

    public static MongoCollection<Document> getCollection(String databaseName, String collectionName){

        MongoClient mongoClient = getMongoClientCredential();
//        MongoClient mongoClient = getMongoClient();
        //连接到数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> label_info = mongoDatabase.getCollection(collectionName);
        return label_info;
    }

    public static MongoClient getMongoClientCredential(){
        //连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址
        ServerAddress serverAddress = new ServerAddress("",12000);
        List<ServerAddress> addrs = new ArrayList<>();
        addrs.add(serverAddress);

        //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
        MongoCredential credential = MongoCredential.createScramSha1Credential("", "", "".toCharArray());
        List<MongoCredential> credentials = new ArrayList<>();
        credentials.add(credential);
        //通过连接认证获取MongoDB连接
        MongoClient mongoClient = new MongoClient(addrs,credentials);
        return mongoClient;
    }
    public static MongoClient getMongoClient(){
        return new MongoClient( "localhost" , 27017 );
    }

    public static void createCol(String colName) {
        //不需要动态建库，直接建表就行。
        MongoClient mongoClient = MongoUtil.getMongoClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase("");
        mongoDatabase.createCollection(colName);
    }

    public static void insert(MongoCollection<Document> col) {
        //两种插入方式。建议使用document1，可以直接parse json str
        String json = "{}";
        Document document1 = Document.parse(json);
        Document document2 = new Document()
                .append("_id", "ssssadfasdfasdfa11111111s11212")
                .append("name", "luobotou")
                .append("list_test", Arrays.asList(1, 2, 3, 4, 5));
        col.insertOne(document2);
    }
    public static void updateByFilter(MongoCollection<Document> mongoCollection){
        //这里的写法类似原生的mongo语句；这里表示只修改负责条件的document的name字段的值
        //
//        Filters.eq("_id", new ObjectId("sjdlfkjalsdjflak"));
        mongoCollection.updateOne(Filters.eq("ObjectId","jlsdjflkasjdfljsadl"),
                new Document("$set", new Document("name","luobotouo")));
    }

    public static void replaceById(MongoCollection<Document> mongoCollection){
        //replace的时候已经有id了下面的document就不用再放id了。要放也要放一样的。
        mongoCollection.replaceOne(Filters.eq("_id", new ObjectId("sjdlfkjalsdjflak")),
                new Document("name", "Green Salads Buffet")
                        .append("contact", "TBD")
                        .append("categories", Arrays.asList("Salads", "Health Foods", "Buffet")));
    }

    public static void deleteByFilter(MongoCollection<Document> mongoCollection){
        DeleteResult result = mongoCollection.deleteOne(Filters.eq("_id", "5bf670f061ea9781177e7743"));
        System.out.println(String.format("总共删除了%s条记录",result.getDeletedCount()));
        DeleteResult result2 = mongoCollection.deleteOne(new Document().append("_id", new ObjectId("5bf66fc461ea9781177e7742")));
        System.out.println(String.format("总共删除了%s条记录",result2.getDeletedCount()));
    }

    /***
     * 1.json 转 条件：Bson parse = Document.parse(jsonObject.toJSONString());
     * 2.通过JsonWriterSettings可以将long或double转为string。以防原有数据结构在json序列化时发生变化。
     * @param mongoCollection
     */
    public static void findAll(MongoCollection<Document> mongoCollection){
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
                    .int64Converter((Long value, StrictJsonWriter writer) -> {
                        if (value > 9007199254740992L)
                            writer.writeString(Long.toString(value));
                        else
                            writer.writeNumber(Long.toString(value));
                    })
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

    //模糊匹配
    public static void findFuzzy (MongoCollection<Document> mongoCollection) {
        Pattern pattern = Pattern.compile("^.*替换.*$", Pattern.CASE_INSENSITIVE);
        Bson name = Filters.regex("name", pattern);
        FindIterable<Document> documents = mongoCollection.find(name);
        MongoCursor<Document> iterator = documents.iterator();
        while (iterator.hasNext()) {
            Document next = iterator.next();
            System.out.println(next.toJson());
        }
    }

    public static void aggs(MongoCollection<Document> mongoCollection) {
//        String str = "[      \n" +
//                "          {\"$project\": {\n" +
//                "                 \"_id\":0,\n" +
//                "                 \"item\":1,        \n" +
//                "                 \"sizeOfColors\": {\"$size\": \"$content\"}         \n" +
//                "                 }\n" +
//                "           },\n" +
//                "            { $group : { \"_id\": \"$_id\", num_tutorial : {$sum : \"$sizeOfColors\"}}}\n" +
//                "]";
//        JSONArray array = JSONArray.parseArray(str);
        ArrayList<Bson> bsons = new ArrayList<>();
//        for (Object o : array) {
//            Bson parse = Document.parse(o.toString());
//            bsons.add(parse);
//        }
        String s1 = " {\"$project\": {\n" +
                "                 \"_id\":0,\n" +
                "                 \"item\":1,        \n" +
                "                 \"sizeOfColors\": {\"$size\": \"$content\"}         \n" +
                "                 }\n" +
                "           }";
        String s2 = "{ \"$group\" : { \"_id\": \"$_id\", \"num_tutorial\" : {\"$sum\" : \"$sizeOfColors\"} }}  ";


        JSONObject j1 = JSONObject.parseObject(s1);
        JSONObject j2 = JSONObject.parseObject(s2);
        bsons.add(Document.parse(j1.toJSONString()));
        bsons.add(Document.parse(j2.toJSONString()));

        AggregateIterable<Document> aggregate = mongoCollection.aggregate(bsons);
        MongoCursor<Document> iterator = aggregate.iterator();
        while (iterator.hasNext()) {
            System.out.println(JSONObject.toJSONString(iterator.next()));
        }
    }

    public static void aggs2(MongoCollection<Document> collection) {
        AggregateIterable<Document> aggregate = collection.aggregate(
                Arrays.asList(
                        Aggregates.match(Filters.ne("_id", 1.0)),
                        Aggregates.group("_id", Accumulators.sum("sum", "$num"))
                )
        );
        MongoCursor<Document> iterator = aggregate.iterator();
        while (iterator.hasNext()) {
            System.out.println(JSONObject.toJSONString(iterator.next()));
        }
    }
}
