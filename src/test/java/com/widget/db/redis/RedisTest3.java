/**
 * Copyright (C), 2018-2021, zenki.ai
 * FileName: RedisTest3
 * Author:   feiyi
 * Date:     2021/3/19 6:07 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.db.redis;

import redis.clients.jedis.Jedis;

/**
 * 〈一句话功能简述〉:
 * 〈RedisTest3
 *   redis 字符串列表。可以做队列使用。使用链表来实现的。〉
 *
 * @author feiyi
 * @create 2021/3/19
 * @since 1.0.0
 */
public class RedisTest3 {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //插入元素：将1个或多个元素插入到列表头部
        jedis.lpush("list-k", "list-v-1", "list-v-2");
        //插入元素：将1个或多个元素插入到列表尾部
        jedis.rpush("list-k", "list-v-3", "list-v-4");

        //查找元素：end为-1表示直到链表尾部
        System.out.println(jedis.lrange("list-k", 0, -1));

        //队列用法：弹出头
        System.out.println(jedis.lpop("list-k"));
        //队列用法：弹出尾
        System.out.println(jedis.rpop("list-k"));

        //队列长度
        System.out.println(jedis.get("list-key"));

        //将1个或多个元素插入到已存在的队列的头部
        jedis.lpushx("list-k","list-v-3", "list-v-4");
        System.out.println(jedis.llen("list-k"));

    }
}
