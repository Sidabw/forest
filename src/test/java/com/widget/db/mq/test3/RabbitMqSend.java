/**
 * Copyright (C), 2018-2021, zenki.ai
 * FileName: RabbitMqSend
 * Author:   feiyi
 * Date:     2021/3/22 10:44 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.db.mq.test3;

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

    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        //广播模型。生产者生产1条消息，2个消费者都去消息这一条消息。

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            //设置交换机；交换机类型是fanout(广播)，名称是logs。
            //其他交换机类型：direct, topic, headers
            channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

            String message = "Hello World!-3-1";

            //这里不指定队列，由消费端指定
            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
    }
}
