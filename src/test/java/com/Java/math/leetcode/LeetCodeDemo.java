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

import java.sql.SQLClientInfoException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/6/12
 * @since 1.0.0
 */
public class LeetCodeDemo {

    /**
     *给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
     *
     * @Description
     * @param
     * @return: void
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2019/6/12 7:56 PM
     **/
    @Test
    public void test(){

    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        String s1 = new String();
        int maxLength = 0;
        for (int i = 0; i < chars.length ; i ++) {
            char charIn = chars[i];
            s1 += charIn;
            int firstIndex = s1.indexOf(charIn);
            int lastIndex = s1.lastIndexOf(charIn);
            if (firstIndex != lastIndex) {

            }
//            if (firstIndex == -1 || lastIndex == -1) {
//                s1 += charIn;
//                maxLength = s1.length();
//            } else {
//
//            }
        }
        return maxLength;
    }
}
