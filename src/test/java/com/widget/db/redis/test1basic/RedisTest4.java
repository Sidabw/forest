/**
 * Copyright (C), 2018-2021, zenki.ai
 * FileName: RedisTest4
 * Author:   feiyi
 * Date:     2021/3/19 6:32 PM
 * Description: RedisTest4
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.db.redis.test1basic;

import redis.clients.jedis.Jedis;

/**
 * 〈一句话功能简述〉:
 * 〈RedisTest4
 *   set, 无序且不重复的集合。
 *  〉
 *
 * @author feiyi
 * @create 2021/3/19
 * @since 1.0.0
 */
public class RedisTest4 {

    private static final String set_key = "set-key";

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.sadd(set_key, "v-1");
        jedis.sadd(set_key, "v-2");
        jedis.sadd(set_key, "v-1");
        System.out.println(jedis.smembers(set_key));
    }

}
