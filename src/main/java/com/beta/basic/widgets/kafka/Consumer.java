/**
 * Copyright (C), 2018-2018, zenki.ai
 * FileName: Consumer
 * Author:   feiyi
 * Date:     2018/12/4 下午8:12
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.basic.widgets.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2018/12/4
 * @since 1.0.0
 */
@Component
public class Consumer {

    @KafkaListener(topics = "${kafka.topic.testtopic}")
    public void receive(String payload) {
        System.out.println("kafka consumer in!");
        System.out.println(payload);
    }
}
