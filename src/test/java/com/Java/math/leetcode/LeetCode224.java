/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: LeetCode224
 * Author:   feiyi
 * Date:     2020/5/28 2:50 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.math.leetcode;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 〈一句话功能简述〉:
 * 〈基本计算器〉
 *
 * @author feiyi
 * @create 2020/5/28
 * @since 1.0.0
 */
public class LeetCode224 {

    /**
     * @Description 实现一个基本的计算器来计算一个简单的字符串表达式的值。
     * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
     * 示例 1:
     * 输入: "1 + 1"
     * 输出: 2
     *
     * 示例 2:
     * 输入: " 2-1 + 2 "
     * 输出: 3
     *
     * 示例 3:
     * 输入: "(1+(4+5+2)-3)+(6+8)"
     * 输出: 23
     * 说明：
     * 你可以假设所给定的表达式都是有效的。
     * 请不要使用内置的库函数 eval。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/basic-calculator
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param
     * @return: void
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2020/5/28 2:51 PM
     **/
    @Test
    public void test(){
        System.out.println(calculate("1+2+3-1+4"));
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(calculate(" 2-1 + 2 "));
        System.out.println(calculate("(1+(4+5+2)-3)"));
        System.out.println(calculate("(2147483647 - 1)"));
    }

    // "(1+(4+5+2)-3)+(6+8)"
    //1+2+3+(4+5)+
    public int calculate(String s) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        //预处理开始，去空格，合并 大于1个字符的数字
        s = s.trim();
        char[] chars = s.toCharArray();
        ArrayList<Object> objects = new ArrayList<>();//Character 和 Integer的组合
        ArrayList<Character> tmps = new ArrayList<>();
        for (char each : chars) {
            if (!(each >= 48 && each <= 57)) {
                //如果是符号，先检查tmps有内容没有，有的话，先把数字组合处理下，
                if (tmps.size()!=0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (Character tmp : tmps) {
                        stringBuilder.append(tmp);
                    }
                    objects.add(Integer.parseInt(stringBuilder.toString()));
                    tmps.clear();
                }
                objects.add(each);
            } else {
              tmps.add(each);
            }
        }
        //如果是符号，先检查tmps有内容没有，有的话，先把数字组合处理下，
        if (tmps.size()!=0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Character tmp : tmps) {
                stringBuilder.append(tmp);
            }
            objects.add(Integer.parseInt(stringBuilder.toString()));
            tmps.clear();
        }
        //预处理结束

        for (Object each : objects) {
            if (each instanceof Integer) {
                //1. push 一个数字的时候，取一个符号，再取一个数字，计算
                int tmp1 = (Integer)each;
                if (!s2.empty() && s2.peek() != 40)  {
                    Character pop = s2.pop();
                    Integer pop1 = s1.pop();
                    if (pop == 43) tmp1 = pop1 + tmp1;
                    else if (pop == 45) tmp1 =  pop1 - tmp1;
                }
                s1.push(tmp1);

            } else if (each instanceof Character){
                char charEach = (Character)each;
                if (charEach == 43 || charEach == 45 || charEach == 40)
                    s2.push(charEach);
                else if (charEach == 41) {
                    //2. push一个)  的时候 ，这个时候s2的头一定是(，先pop出来。之后再计算一次，计算完push给s1
                    s2.pop();
                    int tmp1 = 0;
                    if (!s2.empty() && s2.peek() != 40)  {
                        Character pop = s2.pop();
                        Integer pop1 = s1.pop();
                        Integer pop2 = s1.pop();
                        if (pop == 43) tmp1 = pop2 + pop1;
                        else if (pop == 45) tmp1 =  pop2 - pop1;
                        s1.push(tmp1);
                    }
                }
            }
        }
        return s1.pop();
    }
}
