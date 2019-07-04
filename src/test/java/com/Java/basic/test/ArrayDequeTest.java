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
package com.Java.basic.test;

import org.junit.Test;

import java.util.ArrayDeque;

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
    public void test(){
        //ArrayDeque线程不安全
        //ArrayDeque作为栈使用时，比Stack性能好；作为队列使用时，比LinkedList性能好。
        //不可存取null

        //1.队列操作
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.offer("a");//向队列尾部添加元素，并返回是否添加成功boolean
        queue.offer("b");
        System.out.println(queue.poll());//取出队列的第一个元素
        System.out.println(queue.size());
        //2.栈操作
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push("a");//向栈顶添加元素
        stack.push("b");
        System.out.println(stack.pop());//从栈顶取出元素
        System.out.println(stack.size());

    }
}
