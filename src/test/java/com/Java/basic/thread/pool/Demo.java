/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: Demo
 * Author:   feiyi
 * Date:     2020/4/19 10:02 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.thread.pool;


import java.util.Random;
import java.util.concurrent.*;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2020/4/19
 * @since 1.0.0
 */
public class Demo {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 0L,
                TimeUnit.MILLISECONDS, new SynchronousQueue<>());

        for (int i = 0; i< 10; i++) {
            System.out.println("source:: " + i);
            for (;;) {
                try {
                    threadPoolExecutor.execute(()->{
                        try {
                            Thread.sleep(new Random().nextInt(3)*1000L);
                        } catch (Exception e) {

                        }
                    });
                } catch (Exception e) {
                  try {
                      System.out.println("source:: " + i + "sleep!");
                      Thread.sleep(1000L);
                  } catch (Exception e1) {}
                  continue;
                }
                break;
            }
        }
        System.out.println("finished");
    }
}
