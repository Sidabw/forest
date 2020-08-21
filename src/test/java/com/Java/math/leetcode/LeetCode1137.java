/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: LeetCode1137
 * Author:   feiyi
 * Date:     2020/5/29 10:37 AM
 * Description: 第 N 个泰波那契数
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.math.leetcode;

import org.junit.Test;

import java.util.HashMap;

/**
 * 〈一句话功能简述〉:
 * 〈第 N 个泰波那契数〉
 *
 * @author feiyi
 * @create 2020/5/29
 * @since 1.0.0
 */
public class LeetCode1137 {

    /**
     * @param
     * @Description 泰波那契序列 Tn 定义如下： 
     * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
     * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
     * @return: void
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2020/5/29 10:39 AM
     **/
    @Test
    public void test() {
        //t3=t0+t1+t2   =>2
        //t4=t1+t2+t3   =>4
        //t5=t2+t3+t4   =>7
        //t35           =>615693474
        System.out.println(tribonacci(3));
        System.out.println(tribonacci(4));
        System.out.println(tribonacci(5));
        System.out.println(tribonacci(35));
    }

    private HashMap<Integer, Integer> map = new HashMap<>();

    public int tribonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        int k1 = n - 3;
        int k2 = n - 2;
        int k3 = n - 1;

        int v1;
        if (!map.containsKey(k1)) {
            v1 = tribonacci(k1);
            map.put(k1, v1);
        } else
            v1 = map.get(k1);

        int v2;
        if (!map.containsKey(k2)) {
            v2 = tribonacci(k2);
            map.put(k2, v2);
        } else
            v2 = map.get(k2);

        int v3;
        if (!map.containsKey(k3)) {
            v3 = tribonacci(k3);
            map.put(k3, v3);
        } else
            v3 = map.get(k3);

        return v1 + v2 + v3;
    }
}
