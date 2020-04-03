/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: WebApp
 * Author:   feiyi
 * Date:     2020/3/19 4:36 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.thread.test1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2020/3/19
 * @since 1.0.0
 */
public class WebApp {

    Map<String, AtomicInteger> map = new HashMap<>();

    private static ReentrantLock lock2 = new ReentrantLock();

    public void webMethod(Lock lock, String user){
        lock2.lock();
//        synchronized (user) {
            AtomicInteger atomicInteger = map.get(user);
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger(0);
                map.put(user, atomicInteger);
            }
            atomicInteger.incrementAndGet();
            System.out.println("atomicInteger:  " + atomicInteger + "  ->user: " +  user);
            if (atomicInteger.get() == 2)
                System.out.println("-----------------------------------那看来不行::" +  user + "-----------------------------------");
            atomicInteger.decrementAndGet();
//            ReentrantLock reentrantLock = (ReentrantLock)lock;
//            System.out.println(reentrantLock.getHoldCount());
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock2.unlock();
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//        }
    }

    public void m1(String user){
        synchronized (WebApp.class) {
            System.out.println("m1 --- --- " + user + "--" + "start");
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("m1 --- --- " + user + "--" + "end");
        }
    }

    public void m2(String user){
        synchronized (WebApp.class) {
            System.out.println("m2 --- --- " + user + "--" + "start");
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("m2 --- --- " + user + "--" + "end");
        }
    }

}
