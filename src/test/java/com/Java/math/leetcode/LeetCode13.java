/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: LeetCode13
 * Author:   feiyi
 * Date:     2020/5/25 9:13 AM
 * Description: 罗马数字转整数
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.math.leetcode;

import org.junit.Test;

import java.util.HashMap;

/**
 * 〈一句话功能简述〉:
 * 〈罗马数字转整数〉
 *
 * @author feiyi
 * @create 2020/5/25
 * @since 1.0.0
 */
public class LeetCode13 {

    /**
     * @param
     * @Description 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     * <p>
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     * <p>
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     * <p>
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "III"
     * 输出: 3
     * 示例 2:
     * <p>
     * 输入: "IV"
     * 输出: 4
     * 示例 3:
     * <p>
     * 输入: "IX"
     * 输出: 9
     * 示例 4:
     * <p>
     * 输入: "LVIII"
     * 输出: 58
     * 解释: L = 50, V= 5, III = 3.
     * 示例 5:
     * <p>
     * 输入: "MCMXCIV"
     * 输出: 1994
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/roman-to-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @return: void
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2019/7/17 11:06 AM
     **/
    @Test
    public void test5() {
//        String str = "III";
//        String str = "IV";
//        String str = "IX";
//        String str = "LVIII";
        String str = "MCMXCIV";
        System.out.println(romanToInt(str));

    }

    public static int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        char[] chars = s.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            char cur = chars[i];
            if (i == chars.length - 1) {
                result += map.get(String.valueOf(cur));
                break;
            }
            boolean flag = false;
            switch (cur) {
                case 'I':
                    if (chars[i + 1] == 'V') {
                        result += 4;
                        i++;
                        flag = true;
                    } else if (chars[i + 1] == 'X') {
                        result += 9;
                        i++;
                        flag = true;
                    }
                    break;
                case 'X':
                    if (chars[i + 1] == 'L') {
                        result += 40;
                        i++;
                        flag = true;
                    } else if (chars[i + 1] == 'C') {
                        result += 90;
                        i++;
                        flag = true;
                    }
                    break;
                case 'C':
                    if (chars[i + 1] == 'D') {
                        result += 400;
                        i++;
                        flag = true;
                    } else if (chars[i + 1] == 'M') {
                        result += 900;
                        i++;
                        flag = true;
                    }
                    break;
                default:
                    break;
            }
            if (!flag) result += map.get(String.valueOf(cur));
        }
        if (result < 1 || result > 3999) return 0;
        return result;
    }

}
