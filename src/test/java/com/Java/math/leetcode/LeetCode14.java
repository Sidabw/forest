/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: LeetCode14
 * Author:   feiyi
 * Date:     2020/5/25 9:12 AM
 * Description: 最长公共前缀
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.math.leetcode;

import org.junit.Test;

/**
 * 〈一句话功能简述〉:
 * 〈最长公共前缀〉
 *
 * @author feiyi
 * @create 2020/5/25
 * @since 1.0.0
 */
public class LeetCode14 {
    /**
     * @param
     * @Description 编写一个函数来查找字符串数组中的最长公共前缀。
     * <p>
     * 如果不存在公共前缀，返回空字符串 ""。
     * <p>
     * 示例 1:
     * <p>
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     * <p>
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     * <p>
     * 所有输入只包含小写字母 a-z 。
     * <p>
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-common-prefix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @return: void
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2019/7/15 7:50 PM
     **/
    @Test
    public void test3() {
        String[] strs = new String[]{"flower", "flow", "flight"};
//        String[] strs = new String[]{"dog","racecar","car"};
//        String[] strs = new String[]{"c", "c"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        String first = strs[0];
        for (int i = 0; i < first.length(); i++) {
            String cur = first.substring(0, i + 1);
            boolean flag = true;
            for (int j = 1; j < strs.length; j++) {
                String curJ = strs[j];
                if (curJ.indexOf(cur) != 0) {
                    flag = false;
                    break;
                }
            }
            if (i == 0 && !flag) return "";
            if (!flag) return cur.substring(0, cur.length() - 1);
            if (cur.equals(first)) return cur;
        }
//        HashSet<String> strings = new HashSet<>();
//        for (int i = 0; i < chars.length-1; i++){
//            for (int j = i+1; j<chars.length;j++){
//                String in = String.valueOf(chars[i]) + String.valueOf(chars[j]);
//                strings.add(in);
//            }
//        }
        return "";
    }

}
