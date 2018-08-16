package com.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/***
 *  Created by shao.guangze on 2018/7/25
 *  This is a JobDetail which implements Job.
 */
public class HelloQuartz implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Hello quarze world !!!");
    }
}
