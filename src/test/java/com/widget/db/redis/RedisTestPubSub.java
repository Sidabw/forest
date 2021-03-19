/**
 * Copyright (C), 2018-2021, zenki.ai
 * FileName: RedisTestPubSub
 * Author:   feiyi
 * Date:     2021/3/19 3:17 PM
 * Description: redis 的发布订阅
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.db.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * 〈一句话功能简述〉:
 * 〈redis 的发布订阅
 *  1.RedisTestPubSub.main 去订阅频道
 *  2.RedisTestPubMain.main 去向特定频道发布消息
 * 〉
 *
 * @author feiyi
 * @create 2021/3/19
 * @since 1.0.0
 */
public class RedisTestPubSub{

    public static void main(String[] args) throws InterruptedException {
        Jedis jr = new Jedis("127.0.0.1", 6379, 0);

        RedisSubListener redisSubListener = new RedisSubListener();
        jr.subscribe(redisSubListener, "news.share", "news.blog");
        jr.disconnect();
    }

}

class RedisSubListener  extends JedisPubSub {
    @Override
    public void onMessage(String channel, String message) {
        //收到消息（频道）
        System.out.println(channel + "," + message);
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        //订阅时的回调（频道）
        System.out.println("onSubscribe: channel[" + channel + "]," + "subscribedChannels[" + subscribedChannels + "]");
    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        //取消订阅时的回调（频道）
        System.out.println(
                "onUnsubscribe: channel[" + channel + "], " + "subscribedChannels[" + subscribedChannels + "]");
    }

    @Override
    public void onPMessage(String pattern, String channel, String message) {
        //收到消息（模式）
        System.out.println(pattern + "," + channel + "," + message);
    }

    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        //订阅时的回调（模式）
        System.out.println("onPSubscribe: pattern[" + pattern + "], " +
                "subscribedChannels[" + subscribedChannels + "]");
    }

    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
        //取消订阅时的回调（模式）
        System.out.println("onPUnsubscribe: pattern[" + pattern + "]," +
                "subscribedChannels[" + subscribedChannels + "]");
    }
}


class RedisTestPubMain {

    public static void main(String[] args) {
        Jedis jr = new Jedis("127.0.0.1", 6379, 0);
        jr.publish("news.share", "mmmm");
        jr.disconnect();
    }

}

