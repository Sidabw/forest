/**
 * Copyright (C), 2018-2021, zenki.ai FileName: RedisClusterTest Author:   feiyi Date:     2021/4/8 3:40 PM Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.db.redis.test5cluster;

import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2021/4/8
 * @since 1.0.0
 */
public class RedisClusterTest {

    @Test
    public void test() throws InterruptedException {
        //创建一连接，JedisCluster对象,在系统中是单例存在
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("127.0.0.1", 7001));
        nodes.add(new HostAndPort("127.0.0.1", 7002));
        nodes.add(new HostAndPort("127.0.0.1", 7003));
        nodes.add(new HostAndPort("127.0.0.1", 7004));
        nodes.add(new HostAndPort("127.0.0.1", 7005));
        nodes.add(new HostAndPort("127.0.0.1", 7006));
        JedisCluster cluster = new JedisCluster(nodes);
        cluster.set("key-1", "key-v");
        // cluster.hmset("key-1-2", Collections.singletonMap("k-2-1", "aaa"));

        Thread.sleep(30000L);
        //如果此时kill掉7001，但还是用原来的JedisCluster的话会报错....
        System.out.println(new JedisCluster(nodes).get("key-1"));
        cluster.close();
    }

}
