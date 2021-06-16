/**
 * Copyright (C), 2018-2021, zenki.ai
 * FileName: RedisTest2
 * Author:   feiyi
 * Date:     2021/3/19 11:47 AM
 * Description: RedistTest2
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.db.redis.test1basic;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉:
 * 〈RedistTest2
 *  redis hash, 存放对象
 * 〉
 *
 * @author feiyi
 * @create 2021/3/19
 * @since 1.0.0
 */
public class RedisTest2 {

    public static void main(String[] args) throws InterruptedException {
        Jedis j = new Jedis("127.0.0.1", 6379);
        HashMap<String, String> value = new HashMap<>();
        value.put("v-k-1", "v-v-1");
        value.put("v-k-2", "v-v-2");
        value.put("v-k-3", "v-v-3");
        //设置值
        j.hmset("hash-test", value);
        //设置key的过期时间
        j.expire("hash-test", 1);
        //根据key把整个map拿出来
        Map<String, String> stringStringMap = j.hgetAll("hash-test");
        System.out.println(JSONObject.toJSONString(stringStringMap));
        //根据key，把map的指定几个key的value拿出来
        List<String> hmget = j.hmget("hash-test", "v-k-1");
        System.out.println(hmget);
        //判断指定key下的map的某个field是否存在
        System.out.println(j.hexists("hash-test", "v-k-4"));
        Thread.sleep(1200);
        System.out.println(j.hmget("hash-test", "v-k-1"));//[null]

        //高级用法：
        j.hmset("hash-test-2", Collections.singletonMap("v-k-1","12"));
        //增量+X
        j.hincrBy("hash-test-2", "v-k-1", 1L);
        System.out.println(j.hmget("hash-test-2", "v-k-1"));//输出13
    }
}
