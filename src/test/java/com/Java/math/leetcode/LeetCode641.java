/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: LeetCode641
 * Author:   feiyi
 * Date:     2020/5/28 8:49 PM
 * Description: 设计循环双端队列
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.math.leetcode;

import org.junit.Test;

/**
 * 〈一句话功能简述〉:
 * 〈设计循环双端队列〉
 *
 * @author feiyi
 * @create 2020/5/28
 * @since 1.0.0
 */
public class LeetCode641 {

    //先实现一个双端队列，再实现一个循环队列
    //双端队列⬇
    // 头尾指针：  head                                 tail
    // 元素：       a      b       c      d       e      f
    // 角标：       0      1       2      3       4      5
    //(真的是，还是应该听老师的，tail应该总是指向最后一个空元素，而不是最后一个有值元素。不然你说0角标对应有值没有值的情况，就会多一大堆判断)
    //另外，真正的双端队列是有两个指针分别是 head 和 tail，但是我这里只有1个tail，导致的问题就是每次removeFirst都会触发一次O(n)的数据移动，
    //如果有head的话就可以避免，只需要在tail=n的情况下，再进行数据搬移就可以了！！！
    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(5);
        System.out.println(circularDeque.insertFront(1));
        System.out.println(circularDeque.insertLast(2));
        System.out.println(circularDeque.insertFront(3));
        System.out.println(circularDeque.insertLast(4));
        System.out.println(circularDeque.deleteFront());
        System.out.println(circularDeque.deleteFront());
        System.out.println(circularDeque.insertLast(5));
        System.out.println(circularDeque.insertFront(6));
        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.getFront());
    }
}

class MyCircularDeque {

    int[] origins;
    int tail = 0;
    int size = 0;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        origins = new int[k];
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    //每次insertFront都会导致一次O(n)的数据搬移
    public boolean insertFront(int value) {
        if (size == origins.length)
            return false;

        if (isEmpty()) {
            size++;
            origins[0] = value;
            return true;
        }
        //进行insertFront真正的数据搬移
        int temp1 = value;
        int temp2 = 0;
        for (int i = 0; i < size + 1; i++) {
            temp2 = origins[i];
            origins[i] = temp1;
            temp1 = temp2;
        }
        tail++;
        size++;
        return true;
    }

    //tail指针的移动和size的变化。
    //tail总是指向最后一个有值的元素

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull())
            return false;
        if (isEmpty())
            origins[tail] = value;
        else
            origins[++tail] = value;
        size++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        origins[0] = 0;
        //所有的数据向head平移一个指针
        for (int i = 1; i < size; i++) {
            origins[i - 1] = origins[i];
        }
        size--;
        if (tail != 0)
            tail--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        origins[tail--] = 0;
        size--;
        if (tail < 0) tail = 0;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (size == 0) return -1;
        return origins[0];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (size == 0) return -1;
        return origins[tail];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return size == origins.length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */