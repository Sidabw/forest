/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: CallableTest
 * Author:   feiyi
 * Date:     2020/5/19 9:53 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.thread.callable;

import java.util.concurrent.*;

/**
 * 〈一句话功能简述〉:
 * 〈
 * 主要涉及到几个类：
 * Future:接口，声明，里面的get方法会阻塞等待线程的返回值。
 * FutureTask:包装Callable的，同时也是Runnable 和 Future的子类，
 *  里面的run方法，就是正常调用(也就是阻塞执行)Callable的call方法。
 *  里面的get方法，实现了Future的get方法，循环等待Callable的返回值，也就是阻塞等待结果。
 *
 *  ExecutorCompletionService： 多任务情况下使用，本质上就是就是将结果放到了一个阻塞队列里。调用take方法阻塞等待返回值，本质上也是
 *  调用阻塞队列的take方法阻塞等待返回。
 *
 * 〉
 *
 * @author feiyi
 * @create 2020/5/19
 * @since 1.0.0
 */
public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        //方式1   ::new Thread(futureTask).start();
        //FutureTask是Runnable的子类
        FutureTask<Integer> futureTask = new FutureTask<>(new CallableTask());
        new Thread(futureTask).start();
        System.out.println(futureTask.isDone());
        System.out.println(futureTask.get());//get 是阻塞执行的
        System.out.println("⬆⬆⬆⬆⬆⬆⬆⬆");
        //方式2   ::同上，使用FutureTask，只不过启动发生用线程池替代new Thread
        FutureTask<Integer> futureTask2 = new FutureTask<>(new CallableTask());
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(futureTask2);
        System.out.println(futureTask2.get(3, TimeUnit.SECONDS));//超时抛出TimeoutException
        executorService.shutdown();
        System.out.println("⬆⬆⬆⬆⬆⬆⬆⬆");
        //方式3   ::执行多个带返回值的任务，并获取对应结果
        ExecutorService executorService2 = Executors.newFixedThreadPool(5);
        CompletionService<Integer> cs = new ExecutorCompletionService<Integer>(executorService2);
        for (int i = 0; i< 5; i++) {
            CallableTask task = new CallableTask(i);
            cs.submit(task);
        }
        for (int i = 0; i<5; i++) {
            System.out.println("第 " + i + " 次尝试获取结果");
            //take方法就是从一个completionBlockingQueue中take数据而已，所以哪个线程先执行完了，自然就会先出现在队列里。
            //阻塞队列的take方法会阻塞，如果队列里没有元素；poll方法在这种情况下会直接返回null。
            System.out.println(cs.take().get());//take返回Future对象
        }
        System.out.println("⬆⬆⬆⬆⬆⬆⬆⬆");
        executorService2.shutdown();
    }
}
