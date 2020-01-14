/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: ScheduleController
 * Author:   feiyi
 * Date:     2019/12/30 10:54 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.widgets.scheduler.quartz.controller;

import com.alibaba.druid.util.StringUtils;
import com.beta.widgets.scheduler.quartz.TaskPerform;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/12/30
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/sche")
public class ScheduleController {

    @Autowired
    private Scheduler scheduler;

    private String jobkeyStr = "";

    private JobKey jobKey = null;

    @RequestMapping(value = "/dynamicInject", method = RequestMethod.GET)
    public Object dynamicInject(String id) throws SchedulerException {
        if (StringUtils.isEmpty(id))
            id = "2";
        JobDetail jobDetail = JobBuilder.newJob(TaskPerform.class)
                .withIdentity("updateMatch"+id, "updateMatch")
                .withDescription("Quartz定时比赛Id为"+id)
                .usingJobData("a", "a from JobDetail")
                .usingJobData("b", 1)
                .storeDurably()
                .build();
        //cron表达式 表示每隔2秒执行
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/4 * * * * ? ")
                .withMisfireHandlingInstructionDoNothing();
        //触发器
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("updateMatch"+id, "updateMatch")
                .withDescription("定时比赛Id为"+id)
                .usingJobData("a", "a from CronTrigger")
                .usingJobData("b", 2)
                .withSchedule(scheduleBuilder)
                .startNow().build();

        scheduler.scheduleJob(jobDetail,cronTrigger);
        scheduler.start();
        System.out.println("dynamicInject success");
        System.out.println("job key : " + jobDetail.getKey().toString());
        this.jobkeyStr = jobDetail.getKey().toString();
        this.jobKey = jobDetail.getKey();
        System.out.println(scheduler.getCurrentlyExecutingJobs().size());
        return "dynamicInject success!";
    }

    //中断任务interrupt 代表是任务正在执行过程中，去中断.正常情况。没有特殊要求，不需要在一个去中断一个任务 的执行，除非他卡住了
    //删除任务deleteJob 代表是删除...也就是 注销该任务
    @RequestMapping(value = "/dynamicCancel", method = RequestMethod.GET)
    public Object dynamicCancel() throws SchedulerException {
        System.out.println(jobkeyStr);
        System.out.println(scheduler.getCurrentlyExecutingJobs().size());
        scheduler.interrupt(jobKey);
//        scheduler.deleteJob(jobKey);
        System.out.println("dynamicCancel success");
        return "dynamicCancel success!";
    }

}
