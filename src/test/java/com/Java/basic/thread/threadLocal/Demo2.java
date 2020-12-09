/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: Demo2
 * Author:   feiyi
 * Date:     2020/11/10 11:26 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.thread.threadLocal;

import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 〈一句话功能简述〉:
 * 〈该测试类主要是为了测试"ThreadLocal要不要手动回收"的问题〉
 *
 * @author feiyi
 * @create 2020/11/10
 * @since 1.0.0
 */
public class Demo2 {
    ThreadLocal<ArrayList<String>> curThreadLocal = ThreadLocal.withInitial(ArrayList::new);
    public static void main(String[] args) throws InterruptedException {
        Demo2 demo2 = new Demo2();
        int j = 0;
        Thread.sleep(10000L);
        System.out.println("开始....");
        while (true) {
            Thread thread = new Thread(() -> {
                for(int i = 0; i < 10000; i++) {
                    ArrayList<String> threadLocalList = demo2.curThreadLocal.get();
                    threadLocalList.add(new Random().nextInt() + "kksjaldfjlaksjdflkjasdlkfjalkjdf");
                }
            });
            thread.start();
            System.out.println(j++);
        }
    }
}
