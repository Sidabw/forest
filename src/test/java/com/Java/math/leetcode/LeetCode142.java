/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: LeetCode142
 * Author:   feiyi
 * Date:     2020/10/10 10:28 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.math.leetcode;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2020/10/10
 * @since 1.0.0
 */
public class LeetCode142 {

    public static void main(String[] args) {

//        System.out.println(new LeetCode142().detectCycle().val);
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ArrayList<Integer> hashes = new ArrayList<>();
        hashes.add(head.hashCode());
        while (head.next != null) {
            if (hashes.contains(head.next.hashCode())) {
                return head.next;
            }
            head = head.next;
        }
        return null;
    }
}
