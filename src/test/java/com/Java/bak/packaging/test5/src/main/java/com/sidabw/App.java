package com.Java.bak.packaging.test5.src.main.java.com.sidabw;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MongoClient mongoClientCredential = getMongoClientCredential("10.10.1.7", 12004, "unstructure", "e10adc3949ba59abbe56e057f20f883e", "zk_unstructure_data");
        MongoDatabase mongoDatabase = mongoClientCredential.getDatabase("zk_unstructure_data");
        MongoCollection<Document> col = mongoDatabase.getCollection("gonggao_structure_data");
        Bson filterGte = Filters.gte("gmt8_modified", "2019-01-25 12:40:00:000");
        Bson filterLte = Filters.lte("gmt8_modified", "2019-01-25 16:00:00:000");
        Bson filter = Filters.and(filterLte, filterGte);
        FindIterable<Document> documents = col.find(filter);
        MongoCursor<Document> iterator = documents.iterator();
        int i = 0;
        while (iterator.hasNext()){
            Document next = iterator.next();
            i++;
        }
        System.out.println(i);
    }

    public static MongoClient getMongoClientCredential(String host, int port, String userName, String password, String source){
        //连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址
        ServerAddress serverAddress = new ServerAddress(host,port);
//        ServerAddress serverAddress = new ServerAddress("localhost",27017);
        List<ServerAddress> addrs = new ArrayList<ServerAddress>();
        addrs.add(serverAddress);

        //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
        MongoCredential credential = MongoCredential.createScramSha1Credential(userName, source, password.toCharArray());
//        MongoCredential credential = MongoCredential.createScramSha1Credential("ie_model", "zk_ie_model", "8a1d3920aea87ea01098012f8188dc96".toCharArray());
        List<MongoCredential> credentials = new ArrayList<MongoCredential>();
        credentials.add(credential);
        //通过连接认证获取MongoDB连接
        MongoClient mongoClient = new MongoClient(addrs,credentials);
        return mongoClient;
    }
}
