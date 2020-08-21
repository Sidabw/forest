/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: LeetCode28
 * Author:   feiyi
 * Date:     2020/5/25 9:15 AM
 * Description: 实现 strStr()
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.math.leetcode;

import org.junit.Test;

/**
 * 〈一句话功能简述〉:
 * 〈实现 strStr()〉
 *
 * @author feiyi
 * @create 2020/5/25
 * @since 1.0.0
 */
public class LeetCode28 {

    /**
     * @param
     * @Description 实现 strStr() 函数。
     * <p>
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     * <p>
     * 示例 1:
     * <p>
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     * 说明:
     * <p>
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * <p>
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/implement-strstr
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @return: void
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2019/7/18 4:00 PM
     **/
    @Test
    public void test8() {
        String hayStack = "mississippi";
        String needle = "sippia";
        System.out.println(strStr(hayStack, needle));
    }

    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        if (haystack == null || haystack.length() == 0) return -1;
        if (needle.length() > haystack.length()) return -1;
        char[] chars1 = haystack.toCharArray();
        char[] chars2 = needle.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            char curI = chars1[i];
            boolean eq = false;
            int x = 0;
            int y = 0;
            for (int j = 0; j < chars2.length; j++) {
                char curJ = chars2[j];
                if (curJ == curI) {
                    eq = true;
                    if (i == chars1.length - 1 && j != chars2.length - 1) return -1;
                    if (j == chars2.length - 1) return i;
                    x++;
                    y = i + x;
                    if (y > chars1.length - 1) return -1;
                    curI = chars1[y];
                } else {
                    eq = false;
                    break;
                }
            }
            if (eq) return i;
        }
        return -1;
    }

}
