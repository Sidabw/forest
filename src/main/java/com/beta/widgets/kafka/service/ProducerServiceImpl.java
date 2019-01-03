/**
 * Copyright (C), 2018-2018, zenki.ai
 * FileName: ProducerServiceImpl
 * Author:   feiyi
 * Date:     2018/12/4 下午8:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.widgets.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2018/12/4
 * @since 1.0.0
 */
@Service("producerService")
public class ProducerServiceImpl implements IProducerService {
//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void send(String topic, String payload) {
//        kafkaTemplate.send(topic, payload);
    }
}
