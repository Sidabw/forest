/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: Demo
 * Author:   feiyi
 * Date:     2020/3/19 4:34 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.thread.test1;


/**
 * 〈一句话功能简述〉:
 * 〈对synchronized锁和lock锁进行了进一步的学习和测试
 * Reentrant锁同synchronized一样分为锁对象实例和锁类。使用上static修饰的成员变量ReentrantLock为类锁，否则为对象锁。
 * 锁住当前对象了那么其他线程对当前对象的所有方法的访问将会堵塞。锁住当前类类那么其他线程对当前类的所有方法的访问将会堵塞。
 * <p>
 * 做这些测试的主要目的是为了测试接口幂等性的实现方案：
 * 每个用户拥有一个功能对象 =》 使用synchronized对象锁/lock锁 =〉用户A锁住该功能对象a的同时，不影响用户B锁住该功能对象b
 * <p>
 * 经测试，该方案可行。缺点是每个用户拥有一个功能对象是否浪费内存。能否通过WeakHashMap来实现？
 * 〉
 *
 * @author feiyi
 * @create 2020/3/19
 * @since 1.0.0
 */
public class Demo {

    public static void main(String[] args) throws InterruptedException {
        WebApp webApp1 = new WebApp();
        WebApp webApp2 = new WebApp();
        WebApp webApp3 = new WebApp();

        Thread t1 = new Thread(new User1(webApp1));
        Thread t2 = new Thread(new User2(webApp2));
        Thread t3 = new Thread(new User3(webApp3));

        Thread t4 = new Thread(new User1(webApp1));
        Thread t5 = new Thread(new User2(webApp2));
        Thread t6 = new Thread(new User3(webApp3));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        Thread.sleep(200000L);
        System.exit(1);
    }

}
