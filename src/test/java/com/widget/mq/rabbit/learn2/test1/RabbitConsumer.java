/**
 * Copyright (C), 2018-2021, bokecc.com FileName: RabbitConsumer Author:   shaogz Date:     2021/5/22 7:00 PM
 * Description: History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.mq.rabbit.learn2.test1;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author shaogz
 * @create 2021/5/22
 * @since 1.0.0
 */
public class RabbitConsumer {

    private static final String IP_ADDRESS = "localhost";

    private static final int PORT = 5672;

    private static final String QUEUE_NAME = "queue_demo";


    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Address[] addresses = new Address[] {new Address(IP_ADDRESS, PORT)};
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        Connection connection = connectionFactory.newConnection(addresses);
        final Channel channel = connection.createChannel();

        //客户端最多接收未ack的消息的个数
        channel.basicQos(64);
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                byte[] body) throws IOException {
                System.out.println("recv mes: " + new String(body));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e ) {
                    e.printStackTrace();
                }
                //deliveryTag: 每一个消息的唯一标识，递增的long类型
                //multiple： true的话，一并会将当前deliveryTag前的消息也ack掉
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        channel.basicConsume(QUEUE_NAME, consumer);

        //睡一会等回调执行完
        TimeUnit.SECONDS.sleep(5);
        channel.close();
        connection.close();
    }
}
