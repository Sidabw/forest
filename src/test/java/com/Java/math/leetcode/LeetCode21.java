/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: LeetCode21
 * Author:   feiyi
 * Date:     2020/5/25 9:16 AM
 * Description: 合并两个有序链表
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.math.leetcode;

import org.junit.Test;

/**
 * 〈一句话功能简述〉:
 * 〈合并两个有序链表〉
 *
 * @author feiyi
 * @create 2020/5/25
 * @since 1.0.0
 */
public class LeetCode21 {
    /**
     * @param
     * @Description 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
     * 示例：
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @return: void
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2019/7/22 4:51 PM
     **/
    @Test
    public void test10() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);

        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);

        listNode4.setNext(listNode5);
        listNode5.setNext(listNode6);
        mergeTwoLists(listNode1, listNode4);
    }

    @Test
    public void test11() {
        System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
        System.out.println(orangesRotting(new int[][]{{0, 2}}));//0
        System.out.println(orangesRotting(new int[][]{{0}}));//0
        System.out.println(orangesRotting(new int[][]{{1}}));//-1
        System.out.println(orangesRotting(new int[][]{{2}}));//0
        System.out.println(orangesRotting(new int[][]{{1}, {2}}));//1
        System.out.println(orangesRotting(new int[][]{{2}, {1}}));//1


    }

    public static int orangesRotting(int[][] grid) {
        if (grid.length == 0) return -1;
        //xia:  将4个正方向的好橘子变成烂橘子，同时计时+1
        int timing = 0;
        while (true) {
            boolean badExist = false;
            boolean preBadExist = false;
            boolean goodExist = false;
            int iLen = grid.length;
            for (int i = 0; i < iLen; i++) {
                int jLen = grid[i].length;
                for (int j = 0; j < jLen; j++) {
                    int cur = grid[i][j];
                    if (cur == 1)
                        goodExist = true;
                    if (cur == 0 || cur == 1 || cur == 3)
                        continue;
                    badExist = true;
                    //此时cur == 2
                    //正4方向
                    int i1 = i - 1;
                    int i2 = i + 1;
                    int j1 = j - 1;
                    int j2 = j + 1;
                    //把所有不越界的新鲜橘子变成准备腐烂橘子
                    if (i1 > -1 && i1 < iLen && grid[i1][j] == 1) {
                        if (grid[i1][j] == 1)
                            goodExist = true;
                        grid[i1][j] = 3;
                        preBadExist = true;
                    }
                    if (i2 > -1 && i2 < iLen && grid[i2][j] == 1) {
                        if (grid[i2][j] == 1)
                            goodExist = true;
                        grid[i2][j] = 3;
                        preBadExist = true;
                    }
                    if (j1 > -1 && j1 < jLen && grid[i][j1] == 1) {
                        if (grid[i][j1] == 1)
                            goodExist = true;
                        grid[i][j1] = 3;
                        preBadExist = true;
                    }
                    if (j2 > -1 && j2 < jLen && grid[i][j2] == 1) {
                        if (grid[i][j2] == 1)
                            goodExist = true;
                        grid[i][j2] = 3;
                        preBadExist = true;
                    }
                }
            }
            //初始化状态下没有1则return0
            if (timing == 0 && !goodExist)
                return timing;
            //遍历一圈没有2，return-1
            if (!badExist)
                return -1;
            //遍历一圈发现没有3了，那就完事了
            if (!preBadExist) {
                //此时表示有一个或几个1永远都不会变成2
                if (goodExist) return -1;
                return timing;
            }
            for (int i = 0; i < iLen; i++) {
                int jLen = grid[i].length;
                for (int j = 0; j < jLen; j++) {
                    int cur = grid[i][j];
                    if (cur == 3)
                        grid[i][j] = 2;
                }
            }
            timing++;
            //shang:
        }

    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //判空
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if (l1 == null)
            cur.next = l2;
        else
            cur.next = l1;
        return dummyHead.next;
    }
}
