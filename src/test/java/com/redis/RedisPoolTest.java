package com.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/***
 *  Created by shao.guangze on 2018/7/4
 */
public class RedisPoolTest {
    //使用Jedis的数据库连接池
    public static void main(String[] args) {
        //1.配置连接池的相关参数
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(100);
        jedisPoolConfig.setMinIdle(10);
        jedisPoolConfig.setMaxWaitMillis(3000);

        JedisPool pool ;
        Jedis jedis ;

        //2.按照配置参数创建连接池对象
        pool = new JedisPool(jedisPoolConfig,"127.0.0.1",6379);
        //3.使用连接时从连接池获取对象
        jedis=pool.getResource();
        //4.使用连接
        String str = jedis.get("name");
        System.out.println(str);
        //5.将连接放回连接池
        jedis.close();
        pool.close();

    }
}
