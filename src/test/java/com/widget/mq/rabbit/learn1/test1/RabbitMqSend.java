/**
 * Copyright (C), 2018-2021, zenki.ai
 * FileName: RabbitMqTest
 * Author:   feiyi
 * Date:     2021/3/19 9:22 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.mq.rabbit.learn1.test1;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2021/3/19
 * @since 1.0.0
 */
public class RabbitMqSend {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        //简答模型，1个生成者，1个消费者

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "Hello World!";
            //这是传入的是queue name，实际需要的是routing key，看下面解释
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }

        //ps：这里使用的是默认Exchange，该Exchange的特点是，好坑。。。
        //该默认Exchange，默认绑定所有的queue，而binding key就是queue name
    }

}
