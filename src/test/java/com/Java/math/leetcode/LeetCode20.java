/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: LeetCode20
 * Author:   feiyi
 * Date:     2020/5/25 9:14 AM
 * Description: 有效的括号
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.math.leetcode;

import org.junit.Test;

/**
 * 〈一句话功能简述〉:
 * 〈有效的括号〉
 *
 * @author feiyi
 * @create 2020/5/25
 * @since 1.0.0
 */
public class LeetCode20 {
    /**
     * @Description 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     * 示例 1:
     *
     * 输入: "()"
     * 输出: true
     * 示例 2:
     *
     * 输入: "()[]{}"
     * 输出: true
     * 示例 3:
     *
     * 输入: "(]"
     * 输出: false
     * 示例 4:
     *
     * 输入: "([)]"
     * 输出: false
     * 示例 5:
     *
     * 输入: "{[]}"
     * 输出: true
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param
     * @return: void
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2019/7/17 11:52 AM
     **/
    @Test
    public void test6(){
//        String str = "{[]}";
//        String str = "([][]){{}}";
//        String str = "()[]{}";
        String str = "(]";
//        ( ( ( [ ] ) ) )
//        0 1 2 3 4 5 6 7
//
//        { { { } } }
//        0 1 2 3 4 5
        System.out.println(isValid((str)));
    }
    public static boolean isValid(String s) {
        //40 41 91 93 123 125
        if (s == null || s.length() % 2 == 1) return false;
        if ( s.length() == 0 || s.trim().length() == 0) return true;
        char[] chars = s.toCharArray();
        boolean[] bs = new boolean[chars.length];
        for (int i = 0; i < chars.length ; i++) {
            if (bs[i]) continue;
            char cur = chars[i];
            char next = chars[i + 1];
            int temp = next - cur;
            if (temp == 2 || temp == 1) {
                bs[i] = true;
                bs[i + 1 ] = true;
            } else {
                boolean flag = false;
                int index = 0;
                int repeated = 0;
                for (int j = i + 1 ; j < chars.length; j++){
                    if (bs[j]) return false;
                    char next2 = chars[j];
                    int temp2 = next2 - cur;
                    if (temp2 == 0) {
                        repeated ++;
                        continue;
                    }
                    if (temp2 == 2 || temp2 == 1) {
                        repeated --;
                        if (repeated == -1){
                            flag = true;
                            index = j;
                            bs[i] = true;
                            bs[j] = true;
                            break;
                        }
                    }
                }
                if (!flag) return false;
                if ((index - i + 1) % 2 == 1) return false;
            }
        }
        return true;
    }
}
