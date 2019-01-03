/**
 * Copyright (C), 2018-2018, zenki.ai
 * FileName: ScheduleService
 * Author:   feiyi
 * Date:     2018/11/9 上午11:31
 * Description: 定时任务配置创建类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.widgets.scheduler.quartz;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉:
 * 〈定时任务 定时规则 配置创建类〉
 *
 * @author feiyi
 * @create 2018/11/9
 * @since 1.0.0
 */
@Service
public class ScheduleService {

    @Autowired
    private Scheduler scheduler;

    public void testScheduleTask() throws SchedulerException {
        System.out.println("quartz...   in..");
        JobDetail jobDetail = JobBuilder.newJob(TaskPerform.class)
                .withIdentity("updateMatch"+1, "updateMatch")
                .withDescription("Quartz定时比赛Id为"+1)
                .build();
        //cron表达式 表示每隔2秒执行
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/2 * * * * ? ")
                .withMisfireHandlingInstructionDoNothing();
        //触发器
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("updateMatch"+1, "updateMatch")
                .withDescription("定时比赛Id为"+1)
                .withSchedule(scheduleBuilder)
                .startNow().build();

        scheduler.scheduleJob(jobDetail,cronTrigger);
        scheduler.start();
    }

}
