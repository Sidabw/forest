/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: LeetCode232
 * Author:   feiyi
 * Date:     2020/5/28 11:52 AM
 * Description: 用栈实现队列
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.math.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * 〈一句话功能简述〉:
 * 〈用栈实现队列〉
 *
 * @author feiyi
 * @create 2020/5/28
 * @since 1.0.0
 */
public class LeetCode232 {

    //半个小时。。  而且还是看了答案又写的情况。。
    @Test
    public void test() {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());  // 返回 1
        System.out.println(queue.pop());   // 返回 1
        System.out.println(queue.empty()); // 返回 false
    }
}

class MyQueue {

    private final Stack<Integer> s1 = new Stack<>();
    private final Stack<Integer> s2 = new Stack<>();
    int front = 0;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (s1.empty()) front = x;
        s1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    //出队的时候又发生了push没关系，就push到s1里就可以了，只要在s2空了的情况下再去反转s1就ok。
    public int pop() {
        if (s2.empty()) {
            //反转s1
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return front;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return s2.empty() && s1.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
