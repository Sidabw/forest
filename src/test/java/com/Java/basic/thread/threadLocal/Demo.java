/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: Demo
 * Author:   feiyi
 * Date:     2020/3/4 7:32 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.thread.threadLocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2020/3/4
 * @since 1.0.0
 */
public class Demo {

    //SimpleDateFormat本身是线程不安全的。
    //所以可以在format方法上加锁
    //但也可以使用ThreadLocal.这样每个线程都有一份自己的SimpleDateFormat，自然就不存在线程安全问题了。
    //如果不使用ThreadLocal.那总不能每次访问util.format方法就new SimpleDateFormat吧..
    ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>() {
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("");
        }
    };

    public static void main(String[] args) {

    }


    public String format(Date date) {
        return threadLocal.get().format(date);
    }

}
