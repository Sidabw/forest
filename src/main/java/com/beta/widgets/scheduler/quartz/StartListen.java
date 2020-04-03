/**
 * Copyright (C), 2018-2018, zenki.ai
 * FileName: StartListen
 * Author:   feiyi
 * Date:     2018/11/9 上午11:30
 * Description: 定时任务启动类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.widgets.scheduler.quartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉:
 * 〈定时任务启动类〉
 *
 * @author feiyi
 * @create 2018/11/9
 * @since 1.0.0
 */
@Component
@Configuration
public class StartListen implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private ScheduleService scheduleService;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        try {
            System.out.println("定时任务启动");
            scheduleService.testScheduleTask();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 初始注入scheduler
     * @return
     * @throws SchedulerException
     */
    @Bean
    public Scheduler scheduler() throws SchedulerException {
        System.out.println("初始注入scheduler");
        SchedulerFactory schedulerFactoryBean = new StdSchedulerFactory();
        return schedulerFactoryBean.getScheduler();
    }
}
