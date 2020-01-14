/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: MultiThread2
 * Author:   feiyi
 * Date:     2020/1/2 7:40 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.thread;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2020/1/2
 * @since 1.0.0
 */
public class MultiThread2 {

    //线程池
    private static ThreadPoolExecutor blockingTestThreadPool = new ThreadPoolExecutor(
            2,
            2,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1));



    @Test
    public void test1() throws InterruptedException {
        for (int i = 0; i< 6 ; i ++) {
            int activeCount = blockingTestThreadPool.getActiveCount();
            System.out.println("activeCount : " + activeCount);
            int finalI = i;
            if (activeCount < 2)
//            if (activeCount < 3)
                blockingTestThreadPool.execute(() -> {run(finalI);});
            else
                Thread.sleep(4000L);
        }
    }

    private void run(int i) {
        try {
            System.out.println(Thread.currentThread().getName() + " : run : " + i);
            Thread.sleep(10000L);
            System.out.println(Thread.currentThread().getName() + " : end : " + i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){
//        ExecutorService es = Executors.newFixedThreadPool(5);
//        es.execute();
//        es.submit()
//        blockingTestThreadPool.submit()

    }
}
