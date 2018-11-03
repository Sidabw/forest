package com.kafka;

import com.beta.basic.pojo.User;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Arrays;
import java.util.Properties;

/***
 *  Created by shao.guangze on 2018/9/25
 */
public class GroupConsumer {
    public static void main(String[] args){

        String topic = "MlutibrokerApplication";
        String group = "MyFirstGroup";
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", group);
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer",
                StringDeserializer.class.getName());
        props.put("value.deserializer",
                StringDeserializer.class.getName());
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Arrays.asList(topic));
        System.out.println("Subscribed to topic  &plus; topic");

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records)
            System.out.printf("offset = %d, key = %s, value = %s\n",
                        record.offset(), record.key(), record.value());
        }
    }
}
