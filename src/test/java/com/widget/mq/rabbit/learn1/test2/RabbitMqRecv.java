/**
 * Copyright (C), 2018-2021, zenki.ai
 * FileName: RabbitMqRecv
 * Author:   feiyi
 * Date:     2021/3/22 7:45 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.mq.rabbit.learn1.test2;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.concurrent.TimeoutException;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2021/3/22
 * @since 1.0.0
 */
public class RabbitMqRecv {

    private final static String QUEUE_NAME = "hello-2";

    public static void main(String[] args) throws IOException, TimeoutException {
        //同样创建连接、声明队列；但是不要close这些resource，你close掉了你还咋消费
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //fair dispatch: accept only one unack-ed message at a time
        channel.basicQos(1);
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        //注册callback 进行消费
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);

            try {
                Thread.sleep(new Random().nextInt(4) * 1000);
//                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), true);
            } catch (Exception ignore) {

            } finally {
                //手动确认
                //rabbit-mq没有超时的概念，如果消费者挂了，他会告诉producer，我挂了！
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            }

            System.out.println(" [x] Received '" + message + "'");
        };
        channel.basicConsume(QUEUE_NAME, false, deliverCallback, consumerTag -> { });
    }

}
