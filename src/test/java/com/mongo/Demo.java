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
package com.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        MongoCollection<Document> collection = MongoUtil.getCollection("mongo_demo", "col");
        //insert(collection);
        //updateByFilter(collection);
        deleteByFilter(collection);
        //findAll(collection);

    }
    private void insert(MongoCollection<Document> mongoCollection){
        Document document = new Document()
                .append("_id", "jlsdjflkasjdfljsadl")
                .append("name", "luobotou")
                .append("age", 10)
                .append("list_test", Arrays.asList(1, 2, 3, 4, 5));
        mongoCollection.insertOne(document);
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
        FindIterable<Document> documents = mongoCollection.find();
        MongoCursor<Document> iterator = documents.iterator();
        while (iterator.hasNext()){
            Document eachModel = iterator.next();
            eachModel.keySet().stream().forEach(e -> System.out.println(eachModel.get(e)));
            System.out.println("------------------------");
        }
        long count = mongoCollection.count();
        System.out.println(String.format("共有%s条记录", count));
    }
}
