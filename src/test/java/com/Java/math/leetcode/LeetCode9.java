/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: LeetCode9
 * Author:   feiyi
 * Date:     2020/5/25 4:18 PM
 * Description: 回文数
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.math.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉:
 * 〈回文数 〉
 *
 * @author feiyi
 * @create 2020/5/25
 * @since 1.0.0
 */
public class LeetCode9 {
    /**
     * @Description 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     *
     * 输入: 121
     * 输出: true
     *示例 2:
     *
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3:
     *
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 进阶:
     * 你能不将整数转为字符串来解决这个问题吗？     => 取余运算
     * @param
     * @return: void
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2020/5/13 5:51 PM
     **/
    @Test
    public void test12(){
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(1211));
        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(1));
        System.out.println(isPalindrome(12121));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        ArrayList<Integer> arrayList = new ArrayList<>();
        int xTmp = x;
        arrayList.add(xTmp%10);
        while ((xTmp = xTmp/10) !=0) {
            arrayList.add(xTmp%10);
            if (xTmp < 10) break;
        }
        //剩下的跟leetcode-234一样
        //求得leftEnd 和 rightStart
        int size = arrayList.size();
        if (size == 0 || size == 1) return true;
        int lefEndIndex = size/2 -1;
        int rightStartIndex;
        if (size%2 == 0)
            rightStartIndex = size/2;
        else
            rightStartIndex = size/2 + 1;

        List<Integer> subLeft = arrayList.subList(0, lefEndIndex + 1);
        List<Integer> subRight = arrayList.subList(rightStartIndex, size);
        for (int i = 0; i<subLeft.size(); i++) {
            int curLeftIndex = i;
            int curRightIndex = subRight.size() - i - 1;
            Integer left = subLeft.get(curLeftIndex);
            Integer right = subRight.get(curRightIndex);
            if (!left.equals(right))
                return false;
        }
        return true;
    }
}
