/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: MultiThread3
 * Author:   feiyi
 * Date:     2020/2/19 4:50 PM
 * Description: 源码分析
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.thread;

import org.junit.Test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉:
 * 〈源码分析〉
 *
 * @author feiyi
 * @create 2020/2/19
 * @since 1.0.0
 */
public class MultiThread3 {
    //线程池
    private static ThreadPoolExecutor blockingTestThreadPool = new ThreadPoolExecutor(
            2,
            2,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1));

    @Test
    public void test() {
        blockingTestThreadPool.execute(() -> {
            System.out.println(1);
        });

        System.out.println(Runtime.getRuntime().availableProcessors());
    }

}
