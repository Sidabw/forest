package com.widget.mq.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Arrays;
import java.util.Properties;

/***
 *  Created by shao.guangze on 2018/9/25
 *  如果已经提前打开了kafka-console-consumer.bat 运行完成后可以在consumer处看到结果
 */
public class SimpleProducer {
    public static void main(String[] args) {
        String topicName = "PMC-Spider-Source";
//        String topicName = "Hello-Kafka";
        Properties props = new Properties();
//        props.put("bootstrap.servers", "localhost:9092");
//        props.put("bootstrap.servers", "10.10.1.8:8080");
        props.put("bootstrap.servers", Arrays.asList("storage6.local:9092", "storage7.local:9092", "storage8.local:9092"));
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());
        // Thread.currentThread().setContextClassLoader(null);
        Producer<String, String> producer = new KafkaProducer<String, String>(props);
//        for(int i = 0; i < 10; i++)
        producer.send(new ProducerRecord<String, String>(topicName,
                "test-msg2..."));
        System.out.println("Message sent successfully");
        producer.close();
    }
}
