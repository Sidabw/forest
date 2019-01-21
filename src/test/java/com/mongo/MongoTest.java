/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: MongoTest
 * Author:   feiyi
 * Date:     2019/1/21 上午10:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/1/21
 * @since 1.0.0
 */
public class MongoTest {

    public static void main(String[] args){
        //不需要动态建库，直接建表就行。
        MongoClient mongoClient = MongoUtil.getMongoClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase("mongo_demo2");
        mongoDatabase.createCollection("demo2");
    }

}
