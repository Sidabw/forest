/**
 * Copyright (C), 2018-2021, zenki.ai
 * FileName: BFSgraph
 * Author:   feiyi
 * Date:     2021/3/7 6:42 PM
 * Description: BFS广度优先遍历
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.math.geekbang.graph.fromGeekbang;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 〈一句话功能简述〉:
 * 〈BFS广度优先遍历,基于无向图〉
 *
 * @author feiyi
 * @create 2021/3/7
 * @since 1.0.0
 */
public class BFSgraph {
    public static void main(String[] args) {
        Graph graph = new Graph(8);
        //一度
        graph.addEdge(0, 3);
        graph.addEdge(0, 1);
        //二度
        graph.addEdge(1, 4);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        //三度
        graph.addEdge(2, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        //四度
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);


        graph.bfs(0, 7);
//        int[] prev = new int[] {-1, 0, 1, 0, 1, 4, 4, -1};
//        graph.print(prev, 0, 6);
    }


}

class Graph { // 无向图
    private int v; // 顶点的个数
    private LinkedList<Integer> adj[]; // 邻接表

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) { // 无向图一条边存两次
        adj[s].add(t);
        adj[t].add(s);
    }


    public void bfs(int s, int t) {
        if (s == t) return;
        boolean[] visited = new boolean[v];
        visited[s]=true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    public void print(int[] prev, int s, int t) { // 递归打印s->t的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

}
