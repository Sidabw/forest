package com.widget.db.redis.test1basic;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

/***
 *  Created by shao.guangze on 2018/7/4
 */
public class RedisTest {

    public static void main(String[] args) {
        Jedis j = new Jedis("127.0.0.1", 6379);
        //NX 不存在时才set；XX 存在时才set；
        //EX 秒；PX毫秒
        // j.set("jedisDemo", "Sida", "NX", "EX", 3);//2.9版本的jedis
        j.set("jedisDemo", "Sida", SetParams.setParams().ex(3).nx());//3.01版本的jedis
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(j.get("jedisDemo")); //Sida
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(j.get("jedisDemo"));//null
        j.close();
    }

}
