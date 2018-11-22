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
package com.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉:
 * 〈util〉
 *
 * @author feiyi
 * @create 2018/11/22
 * @since 1.0.0
 */
public class MongoUtil {

    public static MongoCollection<Document> getCollection(String databaseName, String collectionName){

        //MongoClient mongoClient = getMongoClientCredential();
        MongoClient mongoClient = getMongoClient();
        //连接到数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> label_info = mongoDatabase.getCollection(collectionName);
        return label_info;
    }

    private static MongoClient getMongoClientCredential(){
        //连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址
        ServerAddress serverAddress = new ServerAddress("localhost",27017);
        List<ServerAddress> addrs = new ArrayList<>();
        addrs.add(serverAddress);

        //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
        MongoCredential credential = MongoCredential.createScramSha1Credential("ie_model", "zk_ie_model", "8a1d3920aea87ea01098012f8188dc96".toCharArray());
        List<MongoCredential> credentials = new ArrayList<>();
        credentials.add(credential);
        //通过连接认证获取MongoDB连接
        MongoClient mongoClient = new MongoClient(addrs,credentials);
        return mongoClient;
    }
    private static MongoClient getMongoClient(){
        return new MongoClient( "localhost" , 27017 );
    }

}
