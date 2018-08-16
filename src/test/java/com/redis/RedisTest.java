package com.redis;

import redis.clients.jedis.Jedis;

/***
 *  Created by shao.guangze on 2018/7/4
 */
public class RedisTest {
    public static void main(String[] args) {
        Jedis j = new Jedis("127.0.0.1",6379);
        j.set("jedisDemo", "Sida");
        System.out.println(j.get("jedisDemo"));
        j.close();
    }
}
