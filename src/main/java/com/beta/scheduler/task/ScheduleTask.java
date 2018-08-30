package com.beta.scheduler.task;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/***
 *  Created by shao.guangze on 2018/8/20
 */
@Configuration
@Component
@EnableScheduling
public class ScheduleTask {
    private Logger logger = Logger.getLogger(ScheduleTask.class);

    public void sayHello(){
        logger.info("hello,You'll be the king of the world!");
    }

}
