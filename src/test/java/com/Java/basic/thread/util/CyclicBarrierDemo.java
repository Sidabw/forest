/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: CyclicBarrier
 * Author:   feiyi
 * Date:     2020/5/24 3:23 PM
 * Description: 可以认为是CountDownLatch的更高级版
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.thread.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 〈一句话功能简述〉:
 * 〈可以认为是CountDownLatch的更高级版，有一些reset、getNumberWaiting等CountDownLatch没有的功能，他的功能是：
 * 一组线程到达一个屏障（同步点）时 被阻塞，直到最后一个线程到达屏障时，屏障才会打开，所有被拦截的线程继续运行
 * <p>
 * 〉
 *
 * @author feiyi
 * @create 2020/5/24
 * @since 1.0.0
 */
public class CyclicBarrierDemo {

    //创建一个普通的同步屏障
//    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

    //创建一个所有线程到达屏障之后，优先执行A的...,是等待A执行完了其他才执行
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
        System.out.println("⬇⬇⬇⬇⬇⬇⬇");
        System.out.println("我被优先执行");
        System.out.println(Thread.currentThread().getName() + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("⬆⬆⬆⬆⬆⬆⬆");
    });

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(2000L);
                cyclicBarrier.await();//达到屏障，开始等待
                System.out.println(Thread.currentThread().getName() + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(6000L);
                cyclicBarrier.await();//达到屏障，开始等待
                System.out.println(Thread.currentThread().getName() + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        cyclicBarrier.await();
        System.out.println(Thread.currentThread().getName() + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
    }

}
