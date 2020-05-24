/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: ForkJoinDemo
 * Author:   feiyi
 * Date:     2020/5/24 11:08 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.thread.util;

import java.util.concurrent.*;

/**
 * 〈一句话功能简述〉:
 * 〈
 * fork/join,即拆分/组合，是即jdk1.7之后提供的并发框架,其思想在于将大任务拆分成小任务，各个线程完成各子的小任务，最后再组合结果。
 * 重要的是其工作窃取(work-stealing)算法。每个线程都会维护一个任务队列，该队列是一个双端队列。当前线程取任务是从头上取，其他线程完成了
 * 自己的任务，就可以去其他线程的双端队列里，从尾部取任务。
 *
 * RecursiveAction 没有返回结果的任务
 * RecursiveTask 有返回结果的任务
 * ForkJoinTask, Future的子类 上面两个的爸爸，通常不需要
 * 〉
 *
 * @author feiyi
 * @create 2020/5/24
 * @since 1.0.0
 */
public class ForkJoinDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinTask <Integer> countTask = new CountTask(1, 4);
        //pool主要由任务队列和WorkerThread队列组成。
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future<Integer> result = forkJoinPool.submit(countTask);
        Integer resultInt = result.get();
        System.out.println(resultInt);
    }
}

//一个有返回值的ForkJoin任务
//对于何时fork，fork时left和right的start 和 end 分别是多少，一定要想清楚，多测试。
class CountTask extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 2;//阀值

    private int start;

    private int end;

    public CountTask (int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean needlessFork = (end - start) <= THRESHOLD;
        //不需要fork，直接计算
        if (needlessFork)
            for (int i = start; i<= end; i++) {
                sum+=i;
            }
        //需要fork
        else {
            //任务拆分。手动
            int mid = (end + start) / 2;
            CountTask leftCountTask = new CountTask(start, mid);
            CountTask rightCountTask = new CountTask(mid + 1, end);
            //去计算
            leftCountTask.fork();//异步的，向任务队列中pushTask,创建或唤醒工作线程
            rightCountTask.fork();
            //等结果
            Integer joinLeft = leftCountTask.join();//执行任务，堵塞等待结果。
            Integer joinRight = rightCountTask.join();
            //任务合并。手动
            sum = joinLeft + joinRight;
        }
        return sum;
    }
}
