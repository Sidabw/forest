/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: ArrayDequeTest
 * Author:   feiyi
 * Date:     2019/7/4 10:47 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.test;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/7/4
 * @since 1.0.0
 */
public class ArrayDequeTest {

    @Test
    public void test(){
        //ArrayDeque线程不安全
        //ArrayDeque作为栈使用时，比Stack性能好；作为队列使用时，比LinkedList性能好。
        //不可存取null

        //1.队列操作
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.offer("a");//向队列尾部添加元素，并返回是否添加成功boolean
        queue.offer("b");
        System.out.println(queue.poll());//取出队列的第一个元素
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        //2.栈操作
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push("a");//向栈顶添加元素
        stack.push("b");
        System.out.println(stack.pop());//从栈顶取出元素
        System.out.println(stack.size());

    }

    @Test
    public void test2(){
//        int n = 9;
//        int[][] adjacencyList = new int[][]{
//                {1},{2,3},{4,5},{8},{},{8},{6,7},{8},{8}};
        int n = 5;
//        int[][] adjacencyList = new int[][]{
//                 {2, 3}, {3, 4}, {5}, {4, 5}, {}
//        };
        int[][] adjacencyList = new int[][]{
                {1}, {2, 3}, {3, 4}, {4}, {}
        };
        List<Integer> integers = new ArrayDequeTest().topologicalSort(n, adjacencyList);
        System.out.println(integers);
    }

    /**
     * Get topological ordering of the input directed graph
     * @param n number of nodes in the graph
     * @param adjacencyList adjacency list representation of the input directed graph
     * @return topological ordering of the graph stored in an List<Integer>.
     */
    public List<Integer> topologicalSort(int n, int[][] adjacencyList) {
        List<Integer> topoRes = new ArrayList<>();
        int[] inDegree = new int[n];
        for (int[] parent : adjacencyList) {
            for (int child : parent) {
                inDegree[child]++;
            }
        }

        Deque<Integer> deque = new ArrayDeque<>();

        // start from nodes whose indegree are 0
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) deque.offer(i);
        }

        while (!deque.isEmpty()) {
            int curr = deque.poll();
            topoRes.add(curr);
            for (int child : adjacencyList[curr]) {
                inDegree[child]--;
                if (inDegree[child] == 0) {
                    deque.offer(child);
                }
            }
        }

        return topoRes.size() == n ? topoRes : new ArrayList<>();
    }
}
