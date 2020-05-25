/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: LeetCode3
 * Author:   feiyi
 * Date:     2020/5/25 9:10 AM
 * Description: 无重复字符的最长子串
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.math.leetcode;

import org.junit.Test;

/**
 * 〈一句话功能简述〉:
 * 〈无重复字符的最长子串〉
 *
 * @author feiyi
 * @create 2020/5/25
 * @since 1.0.0
 */
public class LeetCode3 {

    /**
     *给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
     *示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
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
        System.out.println(m());
    }
    public static int m (){
//        String str = "abcabcbb";//3
//        String str = "bbbbb";
//        String str = "pwwkew";
//        String str = "zcxabcdebce"; //1b: 4 2b:8,子串：1b:4
        String str = "nfpdmpi";
        if (str == null || "".equals(str)) return 0;
        char[] chars = str.toCharArray();
        char[] chars1 = new char[]{chars[0]};
        int max = 1;
        for (int i = 1 ; i < chars.length ; i ++) {
            char cur = chars[i];
            boolean flag = false;
            int indexRepeated = 0;
            for (int j = 0; j < chars1.length; j++){
                if (chars1[j] == cur) {
                    flag = true;
                    indexRepeated = j;
                }
            }

            if (!flag) {
                //不重复，就继续往下加
                char[] chars2 = new char[chars1.length + 1];
                for (int j = 0 ; j < chars2.length -1 ; j ++){
                    chars2[j] = chars1[j];
                }
                chars2[chars2.length - 1] = cur;
                chars1 = chars2;
                max = max < chars2.length ? chars2.length : max;
                continue;
            } else {
                //重复了,重新生成chars1,attention：chars1不一定就是最长子串！
                int index2 = i - chars1.length + indexRepeated;
                char[] chars2 = new char[i - index2];
                for (int j = 0 ;j < chars2.length ; j ++){
                    chars2[j] = chars[index2 + j + 1];
                }
                chars1 = chars2;
                max = max < chars1.length ? chars1.length : max;
            }

        }
        return max;
    }

}
