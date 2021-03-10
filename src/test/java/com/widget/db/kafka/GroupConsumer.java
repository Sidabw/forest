package com.widget.db.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.junit.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

/***
 *  Created by shao.guangze on 2018/9/25
 */
public class GroupConsumer {
    public static void main(String[] args) {

        String topic = "PMC-Spider-Source";
//        String topic = "Multibrokerapplication";
//        String topic = "Hello-Kafka";
        String group = "MyFirstGroup343hgjhaaaaaaakjhk4";
        Properties props = new Properties();
        props.put("bootstrap.servers", Arrays.asList("storage6.local:9092", "storage7.local:9092", "storage8.local:9092"));
        props.put("group.id", group);
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", StringDeserializer.class.getName());
        props.put("value.deserializer", StringDeserializer.class.getName());
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Arrays.asList(topic));
        System.out.println("Subscribed to topic  " + topic);

        while (true) {
            //Duration: a time-based amount of time
            //poll(Duration timeout) : timeout means the maximum time to block
//            Duration.ofMillis();
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100L));
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("offset = %d, key = %s, value = %s\n",
                        record.offset(), record.key(), record.value());
                consumer.commitSync();
            }
        }
    }

    @Test
    public void testt() {
        Duration duration = Duration.ofMillis(100);
        System.out.println(duration.toMillis());
    }
}
