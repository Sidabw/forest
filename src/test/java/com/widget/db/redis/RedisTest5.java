/**
 * Copyright (C), 2018-2021, zenki.ai
 * FileName: RedisTest5
 * Author:   feiyi
 * Date:     2021/3/19 6:37 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.db.redis;

import redis.clients.jedis.Jedis;

/**
 * 〈一句话功能简述〉:
 * 〈RedisTest5
 *  不重复但有序的集合。
 * 〉
 *
 * @author feiyi
 * @create 2021/3/19
 * @since 1.0.0
 */
public class RedisTest5 {

    private static final String zset_key = "zset-key";

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.zadd(zset_key, 1, "v1");
        jedis.zadd(zset_key, 2, "v2");
        jedis.zadd(zset_key, 3, "v3");

        System.out.println(jedis.zrangeByScore(zset_key, 1, 10));
    }

}
