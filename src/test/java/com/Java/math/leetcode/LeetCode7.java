/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: LeetCode7
 * Author:   feiyi
 * Date:     2020/5/25 9:11 AM
 * Description: 整数反转
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.math.leetcode;

import org.junit.Test;

/**
 * 〈一句话功能简述〉:
 * 〈整数反转〉
 *
 * @author feiyi
 * @create 2020/5/25
 * @since 1.0.0
 */
public class LeetCode7 {
    /**
     * @param
     * @Description 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 123
     * 输出: 321
     *  示例 2:
     * <p>
     * 输入: -123
     * 输出: -321
     * 示例 3:
     * <p>
     * 输入: 120
     * 输出: 21
     * 注意:
     * <p>
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     * @return: void
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2019/7/1 7:40 PM
     **/
    @Test
    public void test2() {
        System.out.println(n(-230));
    }


    public static int n(int in) {
        String strIn = new Integer(in).toString();
        int startIndex = 0;
        if (strIn.substring(0, 1).equals("-")) {
            strIn = strIn.substring(1);
            startIndex = 1;
        }
        String reversedStrIn = new StringBuffer(strIn).reverse().toString();
        char[] chars = reversedStrIn.toCharArray();
        int charLength = chars.length;
        String subStr = reversedStrIn;
        for (int i = 0; i < charLength; i++) {
            char charIn = chars[i];
            if (charIn == '0') {
                if (i == charLength - 1) break;
                subStr = reversedStrIn.substring(i + 1);
            } else {
                break;
            }
        }
        if (startIndex == 0) {
            //正数
            if (subStr.length() < 10) return Integer.valueOf(subStr).intValue();
            int i = subStr.compareTo("2147483647");
            if (i > 0) return 0;
            return Integer.valueOf(subStr).intValue();
        } else {
            //负数
            if (subStr.length() < 10) return Integer.valueOf("-" + subStr).intValue();
            int i = subStr.compareTo("2147483648");
            if (i > 0) return 0;
            return Integer.valueOf("-" + subStr).intValue();
        }
    }

}
