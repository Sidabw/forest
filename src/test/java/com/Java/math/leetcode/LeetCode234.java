/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: LeetCode234
 * Author:   feiyi
 * Date:     2020/5/25 9:18 AM
 * Description: 回文链表
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
 * 〈回文链表〉
 *
 * @author feiyi
 * @create 2020/5/25
 * @since 1.0.0
 */
public class LeetCode234 {

    /**
     * @param
     * @Description 请判断一个链表是否为回文链表。
     * 示例 1:
     * 输入: 1->2
     * 输出: false
     * 示例 2:
     * 输入: 1->2->2->1
     * 输出: true
     * 进阶：
     * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @return: void
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2020/5/21 9:13 AM
     **/
    @Test
    public void test13() {
        //笨方法：第一次遍历拿到中间点；第二次遍历把中间点之后的数据放到一个ArrayList中；第三次遍历看 链表first node 到中间点的
        //元素 和 ArrayList中的元素是否相同，ArrayList倒序遍历。

        //取巧的方法，第一次遍历链表，并把所有的元素放到ArrayList中。再在该ArrayList中判断是否是回文数。

        //测试用例1
//        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(2);
//        ListNode listNode4 = new ListNode(1);
//        listNode1.setNext(listNode2);
//        listNode2.setNext(listNode3);
//        listNode3.setNext(listNode4);

        //测试用例2
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(1);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        listNode4.setNext(listNode5);
        System.out.println(isPalindrome(listNode1));
    }

    public static boolean isPalindrome(ListNode head) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            arrayList.add(cur.val);
            cur = cur.next;
        }
        //求得leftEnd 和 rightStart
        int size = arrayList.size();
        if (size == 0 || size == 1) return true;
        int lefEndIndex = size / 2 - 1;
        int rightStartIndex;
        if (size % 2 == 0)
            rightStartIndex = size / 2;
        else
            rightStartIndex = size / 2 + 1;

        List<Integer> subLeft = arrayList.subList(0, lefEndIndex + 1);
        List<Integer> subRight = arrayList.subList(rightStartIndex, size);
        for (int i = 0; i < subLeft.size(); i++) {
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
