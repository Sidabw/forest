/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: LeetCodeDemo
 * Author:   feiyi
 * Date:     2019/6/12 7:56 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.math.leetcode;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/6/12
 * @since 1.0.0
 */
public class LeetCodeDemo {

    public static void main(String[] args) {
        double a = 1601175692.3262467D;
        Date date = new Date(1601175692326L);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(date));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
