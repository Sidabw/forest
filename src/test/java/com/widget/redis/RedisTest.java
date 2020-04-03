package com.widget.redis;

import redis.clients.jedis.Jedis;

/***
 *  Created by shao.guangze on 2018/7/4
 */
public class RedisTest {
    public static void main(String[] args) {
        Jedis j = new Jedis("127.0.0.1",6379);
        //NX 不存在时才set；XX 存在时才set；EX 秒；PX毫秒
        j.set("jedisDemo", "Sida", "XX", "EX", 3);
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
