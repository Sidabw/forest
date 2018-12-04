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
package com.beta.scheduler.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 〈一句话功能简述〉:
 * 〈定时任务执行类〉
 *
 * @author feiyi
 * @create 2018/11/9
 * @since 1.0.0
 */
public class TaskPerform extends QuartzJobBean {


    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        System.out.println("定时任务执行 " + jobExecutionContext.getJobDetail().getDescription());
    }
}
