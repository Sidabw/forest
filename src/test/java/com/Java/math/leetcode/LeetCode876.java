/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: LeetCode876
 * Author:   feiyi
 * Date:     2020/5/26 5:01 PM
 * Description: 链表的中间结点
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.math.leetcode;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * 〈一句话功能简述〉:
 * 〈链表的中间结点〉
 *
 * @author feiyi
 * @create 2020/5/26
 * @since 1.0.0
 */
public class LeetCode876 {

    /**
     * @Description 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     *
     * 示例 1：
     * 输入：[1,2,3,4,5]
     * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
     * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
     * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
     * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
     * 示例 2：
     *
     * 输入：[1,2,3,4,5,6]
     * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
     * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
     *
     * 提示：
     * 给定链表的结点数介于 1 和 100 之间。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/middle-of-the-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param
     * @return: void
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2020/5/26 5:02 PM
     **/
    @Test
    public void test(){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(2);
//        ListNode listNode5 = new ListNode(4);
        listNode1.setNext(listNode2);
//        listNode2.setNext(listNode3);
//        listNode3.setNext(listNode4);
//        listNode4.setNext(listNode5);
        ListNode listNode = middleNode(listNode1);
        System.out.println(JSONObject.toJSONString(listNode));
    }

    public ListNode middleNode(ListNode head) {
        ListNode cur = head;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        int index = size/2 + 1 - 1;//index start from 0

        int curIndex= 0;
        for (;;) {
            if (curIndex++ == index)
                return head;
            head = head.next;
        }
    }

}
