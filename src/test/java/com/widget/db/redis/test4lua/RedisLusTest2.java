/**
 * Copyright (C), 2018-2021, zenki.ai FileName: RedisLusTest2 Author:   feiyi Date:     2021/3/31 6:04 PM Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.db.redis.test4lua;

import redis.clients.jedis.Jedis;

import java.util.Arrays;
import java.util.Collections;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2021/3/31
 * @since 1.0.0
 */
public class RedisLusTest2 {

    // private final Jedis jedis = new Jedis("127.0.0.1", 6379);
    private final Jedis jedis = new Jedis("r-uf6cmix681d5c4wsnmpd.redis.rds.aliyuncs.com", 6379);


    public static void main(String[] args) {
        new RedisLusTest2().atomicOpsByLua();
    }

    public void atomicOpsByLua() {
        //如果进来的这个值比原来的值大，则覆盖，否则不做任何处理；
        //第一次执行，not res[1]逻辑，k11Val是11 v2是v2，此时k1.k11 会变得有值：11
        //第二次执行，比较逻辑，k11Val是12，v2是v3, 此时k1.k11会变成12，k2也会变成v3
        //第三次执行，else逻辑，k11Val是10， v2是v4， 此时k1.k11依然是12，k2依然是v3
        String key1 = "meta::living:board:content:roomId_20137459";
        String key2 = "pagePusherSendTime{roomId_20137459}";
        String k3 = "pageContent{roomId_20137459}";

        String v1 = "123";
        String v2 = "avc ";
        String v3 = "60";

        String script = "local res = redis.call('hmget', KEYS[1], KEYS[2])\n"
            + "if not res[1] or tonumber(res[1]) < tonumber(ARGV[1]) then\n"
            + "  redis.call('hmset', KEYS[1], KEYS[2], ARGV[1])\n"
            + "  redis.call('hmset', KEYS[1], KEYS[3], ARGV[2])\n"
            + "  redis.call('expire', KEYS[1], ARGV[3])\n"
            + "  return 1\n"
            + "else\n"
            + "  return 0\n"
            + "end";

        jedis.auth("cc%_live^&redis36@ol");
        Object unlockRes = jedis.eval(script, Arrays.asList(key1, key2, k3), Arrays.asList(v1, v2, v3));
        System.out.println(unlockRes);

    }
}
