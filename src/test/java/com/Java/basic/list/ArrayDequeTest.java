/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: ArrayDequeTest
 * Author:   feiyi
 * Date:     2019/7/4 10:47 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.list;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/7/4
 * @since 1.0.0
 */
public class ArrayDequeTest {

    @Test
    public void test() {
        //ArrayDeque线程不安全,不可存取null
        //ArrayDeque作为栈使用时，比Stack性能好；作为队列使用时，比LinkedList性能好。

        //1.队列操作
        ArrayDeque<String> queue = new ArrayDeque<>(6);
        queue.offer("a");//向队列尾部添加元素，并返回是否添加成功boolean
        queue.offer("b");
        System.out.println(queue.poll());//取出队列的第一个元素
        System.out.println(queue.size());
        System.out.println(queue.offer("c"));
        System.out.println(queue.offer("d"));
        System.out.println(queue.offer("e"));
        System.out.println(queue.offer("f"));
        System.out.println(queue.offer("g"));
        System.out.println(queue.offer("h"));//true:证明ArrayDeque是按需增长的，构造器传入的也只是一个初始化容量而已
        System.out.println(queue.size());
        System.out.println(queue.peek());
        System.out.println(queue.size());
        System.out.println("queue ⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆");

        ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(6);
        System.out.println(blockingQueue.offer(1));
        System.out.println(blockingQueue.offer(2));
        System.out.println(blockingQueue.offer(3));
        System.out.println(blockingQueue.offer(4));
        System.out.println(blockingQueue.offer(5));
        System.out.println(blockingQueue.offer(6));
        System.out.println(blockingQueue.offer(7));//false
        System.out.println("blockingQueue ⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆");

        //2.栈操作
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push("a");//向栈顶添加元素
        stack.push("b");
        System.out.println(stack.pop());//从栈顶取出元素
        System.out.println(stack.size());
        System.out.println("stack ⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆");

    }

    /**
     * shuffle 重新洗牌
     */
    @Test
    public void testShuffle() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        System.out.println(integers);
        Collections.shuffle(integers);
        System.out.println(integers);
    }

}
