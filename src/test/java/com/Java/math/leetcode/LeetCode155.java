/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: LeetCode155
 * Author:   feiyi
 * Date:     2020/5/27 11:42 AM
 * Description: 最小栈
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.math.leetcode;

import org.junit.Test;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * 〈一句话功能简述〉:
 * 〈最小栈〉
 *
 * @author feiyi
 * @create 2020/5/27
 * @since 1.0.0
 */
public class LeetCode155 {

    /**
     * @Description 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     *
     * push(x) —— 将元素 x 推入栈中。
     * pop() —— 删除栈顶的元素。
     * top() —— 获取栈顶元素。
     * getMin() —— 检索栈中的最小元素。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/min-stack
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param
     * @return: void
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2020/5/27 11:43 AM
     **/
    @Test
    public void test(){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());  // --> 返回 -3.
        minStack.pop();
        System.out.println( minStack.top());     //--> 返回 0.
        System.out.println(minStack.getMin());   //--> 返回 -2.

    }

}
//我们只需要设计一个数据结构，使得每个元素 a 与其相应的最小值 m 时刻保持一一对应。因此我们可以使用一个辅助栈，
// 与元素栈同步插入与删除，用于存储与每个元素对应的最小值。
class MinStack {

    private Stack<Integer> origins;
    private Stack<Integer> assisted;

    public MinStack() {
        origins = new Stack<>();
        assisted = new Stack<>();
    }

    public void push(int x) {
        origins.push(x);
        try {
            Integer top = assisted.peek();
            if (x < top) assisted.push(x);
            else assisted.push(top);
        } catch (EmptyStackException e) {
            //此时是第一次。
            assisted.push(x);
        }
    }

    public void pop() {
        origins.pop();
        assisted.pop();
    }

    public int top() {
        return origins.peek();
    }

    public int getMin() {
        return assisted.peek();
    }
}

