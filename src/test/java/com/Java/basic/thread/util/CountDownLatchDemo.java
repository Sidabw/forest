/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: CountDownLatchDemo
 * Author:   feiyi
 * Date:     2020/5/24 2:39 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.thread.util;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉:
 * 〈使用CountDownLatch替代x1.join(); x2.join()等，实现主线程等待子线程结束，模拟真正并发等〉
 *
 * @author feiyi
 * @create 2020/5/24
 * @since 1.0.0
 */
public class CountDownLatchDemo {

    //join版本实现
    @Test
    public void test1() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println(1);
            try {
                Thread.sleep(2000L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            System.out.println(2);
            try {
                Thread.sleep(2000L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        //可以把下面两行打开和关闭测试下join
//        t1.join();//主线程等待t1执行完
//        t2.join();//主线程等待t2执行完
        System.out.println(3);
    }

    //CountDownLatch版本实现
    @Test
    public void test2() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread t1 = new Thread(() -> {
            //计数器-1
            countDownLatch.countDown();
            System.out.println(1);
            try {
                Thread.sleep(2000L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            //计数器-1
            countDownLatch.countDown();
            System.out.println(2);
            try {
                Thread.sleep(2000L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        countDownLatch.await();//在计数器为0之前，主线程一直等待
        System.out.println(3);
    }

    //使用CountDownLatch模拟真正并发
    @Test
    public void test3() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(2000L);
                //计数器-1
                countDownLatch.countDown();
                //这样会等着一起执行
                countDownLatch.await();
                //这样会先执行，因为等了5s还没等到CountDownLatch的0
                //countDownLatch.await(5, TimeUnit.SECONDS);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(12000L);
                //计数器-1
                countDownLatch.countDown();
                countDownLatch.await(13, TimeUnit.SECONDS);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        });
        t1.start();
        t2.start();
        countDownLatch.countDown();
        countDownLatch.await();
        //按着设想，最终打印的三次时间应该是差不多的
        System.out.println(Thread.currentThread().getName() + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
    }
}
