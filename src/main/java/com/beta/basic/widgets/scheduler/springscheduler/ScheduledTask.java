/**
 * Copyright (C), 2018-2018, zenki.ai
 * FileName: ScheduledTask
 * Author:   feiyi
 * Date:     2018/11/8 下午8:14
 * Description: spring shedule
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.basic.widgets.scheduler.springscheduler;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 〈一句话功能简述〉:
 * 〈spring shedule
 *   只有两个相关注解，类上@EnableScheduling   方法上@Scheduled
 * 〉
 *
 * @author feiyi
 * @create 2018/11/8
 * @since 1.0.0
 */
@Component
@Configurable
//@EnableScheduling
public class ScheduledTask {

    /***
     * fixedRate = 1000 * 30    每隔30秒执行
     * initialDelay=1000, fixedRate=6000    第一次延迟1秒后执行，之后按fixedRate的规则每6秒执行一次
     */
    //@Scheduled(fixedRate = 1000 * 30)
    public void reportCurrentTime(){
        System.out.println ("Scheduling Tasks Examples: The time is now " + dateFormat ().format (new Date()));
    }

    /***
     * 每1分钟执行一次
     */
    //@Scheduled(cron = "0 */1 *  * * * ")
    public void reportCurrentByCron(){
        System.out.println ("Scheduling Tasks Examples By Cron: The time is now " + dateFormat ().format (new Date ()));
    }

    private SimpleDateFormat dateFormat(){
        return new SimpleDateFormat ("HH:mm:ss");
    }

}
