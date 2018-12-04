/**
 * Copyright (C), 2018-2018, zenki.ai
 * FileName: KafkaController
 * Author:   feiyi
 * Date:     2018/12/4 下午8:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.basic.kafka;

import com.beta.basic.kafka.service.IProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2018/12/4
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    @Resource(name = "producerService")
    private IProducerService producerService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Object kafkaTest(){
        producerService.send("Hello-Kafka", "kkkkkkkkkkkk");
        return "kkk";
    }
}
