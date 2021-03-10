/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: Semaphore
 * Author:   feiyi
 * Date:     2020/5/24 4:06 PM
 * Description: 信号量，控制并发线程数
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.thread.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 〈一句话功能简述〉:
 * 〈信号量，控制并发线程数，对公共资源的访问进行限制。
 * 具体解释可见《Java并发编程的艺术》-196 路口红绿灯控制马路车流量的例子
 * <p>
 * 应用场景，100个线程处理一部分数据，处理完之后还要同步到数据库，但是数据库连接只有10个。这个时候就需要使用信号量保证同一时间最多只有
 * 10个线程拿的到数据库连接。
 * 〉
 *
 * @author feiyi
 * @create 2020/5/24
 * @since 1.0.0
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        //固定30大小的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(30);
        //大小为10的信号量
        Semaphore semaphore = new Semaphore(10);

        //每一个任务睡15秒
        //信号量是10，所以到第11个任务的时候会卡住，等待第一个任务释放"资源"
        for (int i = 0; i < 30; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
//                    semaphore.tryAcquire();//有点tryLock的味道
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(15000L);
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

    }
}
