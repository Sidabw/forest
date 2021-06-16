/**
 * Copyright (C), 2018-2021, zenki.ai
 * FileName: RabbitMqSend
 * Author:   feiyi
 * Date:     2021/3/22 7:44 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.mq.rabbit.learn1.test2;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
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

    private final static String QUEUE_NAME = "hello-2";

    public static void main(String[] args) throws IOException, TimeoutException {
        //工作模型，1个生产者，2个消费者。生产2条消息，每个消费者各自消费1条

        //代码和test1相同
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
            //保证消息不丢失-1-队列保证
            boolean durable = true;
            channel.queueDeclare(QUEUE_NAME, durable, false, false, null);

            String message = "Hello World!-2-2";
            //保证消息不丢失-2-消息保证（ MessageProperties.PERSISTENT_TEXT_PLAIN）
            channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
    }

}