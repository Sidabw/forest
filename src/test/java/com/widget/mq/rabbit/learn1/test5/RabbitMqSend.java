/**
 * Copyright (C), 2018-2021, zenki.ai
 * FileName: RabbitMqSend
 * Author:   feiyi
 * Date:     2021/3/22 11:39 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.mq.rabbit.learn1.test5;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2021/3/22
 * @since 1.0.0
 */
public class RabbitMqSend {

    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        //主题模型（订阅模型）：该topic类型同direct类型相同，但更强大
        //1.生产者发送消息时可以指定组合路由键（用 点 分割）
        //2.消费者使用通配符绑定组合路由键（*代表1个单词， # 代表多个）

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHANGE_NAME, "topic");

            //发三次消息
            //第一次（q1 q2都收到消息）
//            String severity = "quick.orange.rabbit";
//            String message = "run....";
            //第二次（q1 q2都收到消息）
//            String severity = "lazy.orange.elephant";
//            String message = "run....";
            //第三次（只有q1收到消息）
//            String severity = "quick.orange.fox";
//            String message = "run....";
            //第四次（只有q2收到消息）
//            String severity = "lazy.brown.fox";
//            String message = "run....";
            //第五次(q1 q2 都不会收到消息)
//            String severity = "quick.brown.fox";
//            String message = "run....";
            //第六次（q2收到消息，虽然有4个单词，但q2用的是#）
            String severity = "lazy.orange.male.rabbit";
            String message = "run....";

            //发送消息时指定键
            //最终结果就是，第一次、第二次、第三次消息，都会被绑定info、warning、error键的消费者消费，而只绑定error键的消费者只接收到了error的消息
            channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + severity + "':'" + message + "'");
        }
    }

}
