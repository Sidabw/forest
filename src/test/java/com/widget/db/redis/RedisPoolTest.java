package com.widget.db.redis;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashMap;

/***
 *  Created by shao.guangze on 2018/7/4
 */
public class RedisPoolTest {

    private String a = "";

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    //使用Jedis的数据库连接池
    public static void main(String[] args) {
        //1.配置连接池的相关参数
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(100);
        jedisPoolConfig.setMinIdle(10);
        jedisPoolConfig.setMaxWaitMillis(3000);

        JedisPool pool;
        Jedis jedis;

        //2.按照配置参数创建连接池对象
        pool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379);
        //3.使用连接时从连接池获取对象
        jedis = pool.getResource();
        //4.使用连接
//        String str = jedis.get("sida");
//        System.out.println(str);
//        hashTest(jedis);
        strTest(jedis);
        //5.将连接放回连接池
        jedis.close();
        pool.close();
    }

    public static void hashTest(Jedis jedis) {
        HashMap<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        jedis.hmset("map_test", map);
        System.out.println(jedis.hmget("map_test", "key1", "key2"));
    }

    public static void strTest(Jedis jedis) {
        HashMap<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        String strMap = JSONObject.toJSONString(map);
//        jedis.set("str_test", strMap);
        if (!jedis.exists("str_test")) {
            //NX 不存在时才set；XX 存在时才set；EX 秒；PX毫秒
            System.out.println("key " + "str_test" + " not exist!");
            jedis.set("str_test", strMap, "NX", "EX", 10);
        } else {
            //
            System.out.println("key " + "str_test" + " exist!");
            jedis.set("str_test", strMap, "XX", "EX", 10);
        }
        System.out.println(jedis.get("str_test"));
    }

}
