/**
 * Copyright (C), 2018-2021, zenki.ai
 * FileName: GraphTraversal
 * Author:   feiyi
 * Date:     2021/3/7 7:45 PM
 * Description: 遍历图
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.math.geekbang.graph.fromBilibili;

import java.util.*;

/**
 * 〈一句话功能简述〉:
 * 〈遍历图，基于有向图
 *  BFS , 广度优先搜索， Breath-First-Search
 *  DFS， 深度优先搜索， Depth-First-Search
 * 〉
 *
 * @author feiyi
 * @create 2021/3/7
 * @since 1.0.0
 */
public class GraphTraversal {

    boolean[] visited;

    ListGraph graph;

    public GraphTraversal(ListGraph listGraph) {
        this.graph = listGraph;
        visited = new boolean[listGraph.graphs.size()];
    }

//⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇BFS⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇
    public void BFSTraversal(int v) {
        Deque<Integer> queue = new ArrayDeque<>();
        visited[v] = true;
        queue.offerFirst(v);
        while (queue.size() != 0) {
            Integer cur = queue.pollFirst();
            System.out.print(cur + " -> ");
            Iterator<Integer> neighbors = graph.graphs.get(cur).listIterator();
            while (neighbors.hasNext()) {
                int nextNode = neighbors.next();
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.offerLast(nextNode);
                }
            }
        }
    }

    public void BFS() {
        for (int i = 0; i < graph.graphs.size(); i++) {
            if (!visited[i]) {
                BFSTraversal(i);
            }
        }
    }

//⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆BFS⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆

//--------------------------------------------------------------

//⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇DFS⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇
    public void DFSTraversal(int v) {
        if(visited[v]) return;
        visited[v] = true;
        System.out.print(v + " -> ");
        Iterator<Integer> neighbors = graph.graphs.get(v).listIterator();
        while (neighbors.hasNext()) {
            int nextNode = neighbors.next();
            if (!visited[nextNode]) {
                DFSTraversal(nextNode);
            }
        }
    }

    public void DFS() {
        for (int i = 0; i < graph.graphs.size(); i++) {
            if (!visited[i]) {
                DFSTraversal(i);
            }
        }
    }
//⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆DFS⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆

    public static void main(String[] args) {
        //创建图
        ListGraph listGraph = new ListGraph(7);
        listGraph.addEdge(0, 1);
        listGraph.addEdge(1, 2);
        listGraph.addEdge(1, 3);
        listGraph.addEdge(1, 5);
        listGraph.addEdge(5, 1);
        listGraph.addEdge(2, 5);
        listGraph.addEdge(4, 2);
        listGraph.addEdge(4, 5);
        //遍历(traversal)
        GraphTraversal graphTraversal = new GraphTraversal(listGraph);
        graphTraversal.BFS();
    }
}

class ListGraph {

    List<List<Integer>> graphs;

    //v 表示点的个数
    public ListGraph(int v) {
        graphs = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graphs.add(new ArrayList<>());
        }
    }

    public void addEdge(int start, int end) {
        graphs.get(start).add(end);
    }

    public void removeEdge(int start, int end) {
        graphs.get(start).remove((Integer)end);
    }

}
