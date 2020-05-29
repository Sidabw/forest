/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: LeetCode933
 * Author:   feiyi
 * Date:     2020/5/28 7:13 PM
 * Description: 最近的请求次数
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.math.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 〈一句话功能简述〉:
 * 〈最近的请求次数〉
 *
 * @author feiyi
 * @create 2020/5/28
 * @since 1.0.0
 */
public class LeetCode933 {

    @Test
    public void test(){
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(2));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
    }
}

class RecentCounter {

    private static final int cc = 3000;
    private Deque<Integer> deque;

    public RecentCounter() {
        deque = new ArrayDeque<>();
    }

    public int ping(int t) {
        deque.addLast(t);
        while (!deque.isEmpty() && deque.peek() < (t - cc)) {
            deque.poll();//其实和pop一个意思。都是检索并返回head元素。stack的head是last..
        }
        return deque.size();
    }
}