/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: MultiThread
 * Author:   feiyi
 * Date:     2019/12/30 10:29 AM
 * Description: 多线程测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.thread;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * 〈一句话功能简述〉:
 * 〈多线程测试〉
 *
 * @author feiyi
 * @create 2019/12/30
 * @since 1.0.0
 */
public class MultiThread {
    //线程池
    private static ExecutorService fixedThreadPool = Executors
            .newFixedThreadPool(3);

    //线程池
    private static ExecutorService blockingTestThreadPool = new ThreadPoolExecutor(
            2,
            2,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1));

    //测试主线程是否会堵塞
    @Test
    public void test() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i + "for in");
            int finalI = i;
            //线程池会堵塞，等待其他线程结束执行，但主线程不会。
            //跑一遍，看console，都不用看文件的时间戳。
            blockingTestThreadPool.execute(() -> threadRun(finalI));
        }
        System.out.println("主线程结束::" + "timeStamp ::" + new Date().getTime());
    }

    public static void threadRun(int i) {
        try {
            System.out.println(i + " :: thread run ⬇.");
//            Thread.sleep(1);
            Thread.sleep(2);
            writeFile(i);
            System.out.println(i + " :: thread end ⬆.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void writeFile(int value) throws IOException {
        FileWriter fileWriter = new FileWriter(new File("/Users/feiyi/Desktop/thread/" + value + ".txt"));
        fileWriter.write("value:: " + value + "timeStamp ::" + new Date().getTime());
        fileWriter.close();
    }
}
