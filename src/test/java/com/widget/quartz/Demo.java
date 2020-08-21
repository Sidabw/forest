package com.widget.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/***
 *  Created by shao.guangze on 2018/7/25
 */
public class Demo {

    //对应日志见最下方。
    private static final String cron = "0/13 * * * * ?";//从现在开始，到当前时间的第十三秒执行一次，整除计算：
//    private static final String cron = "0 * * * * ?";//从现在开始，每分钟的第0秒执行一次。
//    private static final String cron = "0 */2 * * * ?";//同上，从现在开始，每分钟的第0秒执行一次。。。

    //未测试用法
//    private static final String cron = "0 0 * * * ?";//从现在开始，在每小时的第0分钟第0秒执行一次。
//    private static final String cron = "0 0 0 * * ?";//从现在开始，在每天的第0时第0分钟第0秒执行一次。

    //错误用法
//    private static final String cron = "* */1 * * * ?";//实际是每秒。

    public static void main(String[] args) throws InterruptedException {

        SchedulerFactory schedulerfactory = new StdSchedulerFactory();
        Scheduler scheduler;
        try {
            // 通过schedulerFactory获取一个调度器
            scheduler = schedulerfactory.getScheduler();
            // 创建jobDetail实例，绑定Job实现类
            // 指明job的名称，所在组的名称，以及绑定job类
            JobDetail job = JobBuilder.newJob(HelloQuartz.class).withIdentity("JobName", "JobGroupName").build();
            // 定义调度触发规则
            // SimpleTrigger
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("SimpleTrigger", "SimpleTriggerGroup")
                    .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(13).withRepeatCount(3))
                    .startNow().build();
            //  corn表达式  每五秒执行一次2
//                Trigger trigger=TriggerBuilder.newTrigger().withIdentity("CronTrigger1", "CronTriggerGroup")
//                        .withSchedule(CronScheduleBuilder.cronSchedule(cron))
//                        .startNow().build();
            System.out.println("scheduler.start()::" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date()));
            // 把作业和触发器注册到任务调度中
            scheduler.scheduleJob(job, trigger);
            // 启动调度
            scheduler.start();

//            System.out.println("//获取下次调度时间⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇");
//            CronExpression cronExpression = new CronExpression(cron);
//            Date n1 = cronExpression.getNextValidTimeAfter(new Date());
//            Date n2 = cronExpression.getNextValidTimeAfter(n1);
//            System.out.println( new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(n1));
//            System.out.println( new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(n2));
//            System.out.println("//获取下次调度时间⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆");

            Thread.sleep(1500000);
            System.out.println(scheduler.getCurrentlyExecutingJobs().size());
            // 停止调度
            scheduler.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    private static final String cron = "*/10 * * * * ?";
//    scheduler.start()::2020-04-09 14:31:08:089
//    Hello quarze world !!!   ::2020-04-09 14:31:10:040

//    private static final String cron = "0 * * * * ?";
//    scheduler.start()::2020-04-09 14:37:18:014
//    Hello quarze world !!!   ::2020-04-09 14:38:00:054
//    Hello quarze world !!!   ::2020-04-09 14:39:00:005

//    private static final String cron = "0 */1 * * * ?";
//    scheduler.start()::2020-04-09 14:40:25:491
//    Hello quarze world !!!   ::2020-04-09 14:41:00:038


}
