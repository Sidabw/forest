package com.widget.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/***
 *  Created by shao.guangze on 2018/7/25
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {

        SchedulerFactory schedulerfactory = new StdSchedulerFactory();
        Scheduler scheduler;
        try{
            // 通过schedulerFactory获取一个调度器
            scheduler = schedulerfactory.getScheduler();
            // 创建jobDetail实例，绑定Job实现类
            // 指明job的名称，所在组的名称，以及绑定job类
            JobDetail job = JobBuilder.newJob(HelloQuartz.class).withIdentity("JobName", "JobGroupName").build();
            // 定义调度触发规则
            // SimpleTrigger
//            Trigger trigger=TriggerBuilder.newTrigger().withIdentity("SimpleTrigger", "SimpleTriggerGroup")
//                    .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(2).withRepeatCount(3))
//                    .startNow().build();
            //  corn表达式  每五秒执行一次
            Trigger trigger=TriggerBuilder.newTrigger().withIdentity("CronTrigger1", "CronTriggerGroup")
                    .withSchedule(CronScheduleBuilder.cronSchedule("*/2 * * * * ?"))
                    .startNow().build();
            // 把作业和触发器注册到任务调度中
            scheduler.scheduleJob(job, trigger);
            // 启动调度
            scheduler.start();
            Thread.sleep(15000);
            System.out.println(scheduler.getCurrentlyExecutingJobs().size());
            // 停止调度
            scheduler.shutdown();
        }catch(SchedulerException e){
            e.printStackTrace();
        }
    }
}
