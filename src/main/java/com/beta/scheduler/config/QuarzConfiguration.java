package com.beta.scheduler.config;

import com.beta.scheduler.task.ScheduleTask;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;

/***
 *  Created by shao.guangze on 2018/8/20
 */
@Configuration
public class QuarzConfiguration {

    public MethodInvokingJobDetailFactoryBean detailFactoryBean(ScheduleTask task){
        MethodInvokingJobDetailFactoryBean jobDeatail = new MethodInvokingJobDetailFactoryBean();
        jobDeatail.setConcurrent(false);//是否并发执行
        jobDeatail.setName("sidabw");
        jobDeatail.setGroup("fm");
        jobDeatail.setTargetObject(task);
        jobDeatail.setTargetMethod("sayHello");
        return jobDeatail;
    }
    /***
     * 配置定时任务的触发器
     */

}
