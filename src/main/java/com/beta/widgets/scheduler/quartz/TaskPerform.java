/**
 * Copyright (C), 2018-2018, zenki.ai
 * FileName: TaskPerform
 * Author:   feiyi
 * Date:     2018/11/9 上午11:35
 * Description: 定时任务执行类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.widgets.scheduler.quartz;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 〈一句话功能简述〉:
 * 〈定时任务执行类〉
 *
 * @author feiyi
 * @create 2018/11/9
 * @since 1.0.0
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class TaskPerform extends QuartzJobBean implements InterruptableJob {

    private static Logger logger = LoggerFactory.getLogger(TaskPerform.class);

    private boolean a = Boolean.FALSE;

    private int i = 0;
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("⬇");
//        System.out.println(jobExecutionContext.getJobDetail().toString());
//        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
//        int a = jobDataMap.getInt("a");
//        jobDataMap.put("a", ++a);
//        System.out.println(a);
//        logger.debug("定时任务执行 " + jobExecutionContext.getJobDetail().getDescription());

//        System.out.println(++i);

        System.out.println(jobExecutionContext.getJobDetail().getJobDataMap().get("a"));    // from JobDetail
        System.out.println(jobExecutionContext.getMergedJobDataMap().get("a")); //from CronTrigger

        //job上的变量会发生变化
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        int b = jobDataMap.getInt("b");
        jobDataMap.put("b", ++b);
        System.out.println("b from jobDetail :" + jobDataMap.getInt("b"));

        //触发器上的变量是不会发生变化的
        JobDataMap mergedJobDataMap = jobExecutionContext.getMergedJobDataMap();
        int b2 = mergedJobDataMap.getInt("b");
        mergedJobDataMap.put("b", ++b2);
        System.out.println("b from CronTrigger :" + mergedJobDataMap.getInt("b"));

        System.out.println("⬇");
        System.out.println(jobExecutionContext.getJobDetail().getKey().toString() + a);
    }

    @Override
    public void interrupt() throws UnableToInterruptJobException {
        this.a = Boolean.TRUE;
        System.out.println("interrupt method in");
    }
}
