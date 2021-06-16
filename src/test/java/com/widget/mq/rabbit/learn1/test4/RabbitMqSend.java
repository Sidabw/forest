/**
 * Copyright (C), 2018-2021, zenki.ai
 * FileName: RabbitMqSend
 * Author:   feiyi
 * Date:     2021/3/22 11:08 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.mq.rabbit.learn1.test4;

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

    private static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        //路由模型：生产者发送的消息有类型。不同类型的消息给不同的消费者（即不同类型的消息发送到不同队列中去）

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHANGE_NAME, "direct");

            //发三次消息
            //第一次
//            String severity = "info";
//            String message = "info log appended!";
            //第二次
//            String severity = "warning";
//            String message = "warning log appended!";
            //第三次
            String severity = "error";
            String message = "error log appended!";

            //发送消息时指定键
            //最终结果就是，第一次、第二次、第三次消息，都会被绑定info、warning、error键的消费者消费，而只绑定error键的消费者只接收到了error的消息
            channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + severity + "':'" + message + "'");
        }
    }
}
