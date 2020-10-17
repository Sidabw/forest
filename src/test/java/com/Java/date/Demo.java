/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: Demo
 * Author:   feiyi
 * Date:     2020/10/16 11:29 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2020/10/16
 * @since 1.0.0
 */
public class Demo {

    //为什么要使用LocalDate LocalTime LocalDateTime??
    //其实把SimpleDateFormat用ThreadLocal做线程安全的处理后，这些是没必要学的
    //就当是拓宽下技术栈把
    public static void main(String[] args) {


        //1LocalDate 只获取年月日
        LocalDate localDateNow = LocalDate.now();
        LocalDate localDateSpecified = LocalDate.of(2020, 11, 12);
        System.out.println(localDateNow.getYear());//年
        System.out.println(localDateNow.getMonth().getValue());//月
        System.out.println(localDateNow.getDayOfMonth());//日
        System.out.println(localDateNow.getDayOfWeek().getValue());//星期几
        System.out.println("⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️");
        //2LocalTime 只获取时分秒
        LocalTime localTimeNow = LocalTime.now();
        LocalTime localTimeSpecified = LocalTime.of(23, 59, 59);
        System.out.println(localTimeNow.getHour());
        System.out.println(localTimeNow.getMinute());
        System.out.println(localTimeNow.getMinute());
        System.out.println("⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️");
        //3LocalDateTime 获取年月日时分秒
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(2019, 11, 10, 14, 46, 56);
        //LocalDateTime = LocalDate + LocalTime
        LocalDateTime localDateTime2 = LocalDateTime.of(localDateNow, localTimeNow);
        System.out.println("⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️⬇️️️️");
        //4格式化时间（线程安全）
        System.out.println(DateTimeFormatter.ofPattern("yyyy//MM//dd").format(localDateTime));
        LocalDateTime localDateTime3 = LocalDateTime.parse("2020//12/12");//parse的话就必须对应的类，不能用DateTimeFormatter

    }
}
