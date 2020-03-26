package com.widget.quartz;

import org.quartz.*;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/***
 *  Created by shao.guangze on 2018/7/25
 *  This is a JobDetail which implements Job.
 */
@DisallowConcurrentExecution
@PersistJobDataAfterExecution
//public class HelloQuartz implements Job {
public class HelloQuartz extends QuartzJobBean implements InterruptableJob{
//    @Override
//    public void execute(JobExecutionContext context) throws JobExecutionException {
//        System.out.println("Hello quarze world !!!");
//        try {
//            Thread.sleep(5000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("week up");
//    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        System.out.println("Hello quarze world !!!   ::" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date()));
//        try {
//            Thread.sleep(5000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("week up");

    }

    @Override
    public void interrupt() throws UnableToInterruptJobException {

    }
}
