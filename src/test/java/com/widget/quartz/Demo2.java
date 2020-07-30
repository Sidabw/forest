/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: Demo2
 * Author:   feiyi
 * Date:     2020/7/21 4:08 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2020/7/21
 * @since 1.0.0
 */
public class Demo2 {

    //把 年月日·时分秒 转成cron 表达式，并运行测试
    public static void main(String[] args) throws ParseException, SchedulerException, InterruptedException {

        String originTimeStr = "2020-07-21 16:17:21";
        Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(originTimeStr);
        String cron = new SimpleDateFormat("ss mm HH dd MM ? yyyy").format(parse);
        System.out.println(cron);

        SchedulerFactory schedulerfactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerfactory.getScheduler();
        JobDetail job = JobBuilder.newJob(HelloQuartz.class).withIdentity("JobName", "JobGroupName").build();
        Trigger trigger=TriggerBuilder.newTrigger().withIdentity("CronTrigger1", "CronTriggerGroup")
                .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                .startNow().build();
        scheduler.scheduleJob(job, trigger);
        // 启动调度
        scheduler.start();
        Thread.sleep(1500000);
        scheduler.shutdown();
    }
}
