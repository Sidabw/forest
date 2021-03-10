/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: BinarySearchTreeDemo
 * Author:   feiyi
 * Date:     2020/6/27 8:53 AM
 * Description: 二叉搜索树
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.math.geekbang.tree;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉:
 * 〈二叉搜索树: BinarySearchTree〉
 *
 * @author feiyi
 * @create 2020/6/27
 * @since 1.0.0
 */
public class BinaryTree2Search {

    //BinarySearchTree
    public static void main(String[] args) {
        Node root = BinaryTree1Demo.buildTree();
        Node target = new Node(12);
        search(root, target);
//        delete(root, target);
//        BinaryTree1Demo.inOrder(root);
        insert(root, 13);
        BinaryTree1Demo.inOrder(root);

    }

    private static void delete(Node root, Node target) {
        //第一种情况：删除的节点没有子节点
        //第二种情况：删除的节点有一个子节点
        //第三种情况：删除的节点有两个子节点(找到右子树的最小值替换之)
        int targetValue = target.value;
        //1.找到当前节点和当前节点的父节点
        Node p = root;
        Node pp = null;
        while (p != null && p.value != targetValue) {
            pp = p;
            if (targetValue < p.value) p = p.left;
            else p = p.right;
        }
        if (p == null) return;//没有找到

        //2,对有两个节点的情况进行特殊处理
        if (p.left != null && p.right != null) {
            //找右子树的最小值
            Node minP = p.right;
            Node minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.value = minP.value;//只是进行值的替换
            //对p和pp进行篡改，使得往下进行的逻辑依旧是"删除节点是叶子节点或者仅有一个节点。"
            p = minP;
            pp = minPP;
        }

        //3.删除节点是叶子节点或者仅有一个节点。
        Node child;//p的child
        if (p.left != null) child = p.left;
        else if (p.right != null) child = p.right;
        else child = null;//此时说明p是叶子节点

        if (pp == null) root = child;//此时表示删除的是根节点。且该树只有一个节点。
        else if (pp.left == p) pp.left = child;
        else pp.right = child;

    }

    private static void search(Node root, Node target) {
        if (root == null) {
            System.out.println("not found! root null!");
        } else if (root.value == target.value) {
            System.out.println("found! root value:: " + root.value);
            return;
        } else if (target.value < root.value) {
            search(root.left, target);
        } else if (target.value > root.value) {
            search(root.right, target);
        }
    }

    //返回根节点
    private static Node insert(Node root, int target) {
        if (root == null) {
            return new Node(target);
        }
        Node p = root;
        while (p != null) {
            if (target < p.value) {
                if (p.left == null) {
                    p.left = new Node(target);
                    return root;
                }
                p = p.left;
            } else {
                if (p.right == null) {
                    p.right = new Node(target);
                    return root;
                }
                p = p.right;
            }
        }
        return root;
    }

    //使用分层遍历计算树的确定高度

    /**
     * @param root
     * @Description 每一层记录都记录下当前队列的长度，这个是队尾，每一层队头从0开始。然后每遍历一个元素，队头下标+1。
     * 直到队头下标等于队尾下标。这个时候表示当前层遍历完成。每一层刚开始遍历的时候，树的高度+1。最后队列为空，就能得到树的高度。
     * @return: int
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2020/6/27 3:47 PM
     **/
    public static int calHeight(Node root) {
        return -1;
    }


    private static List<Integer> res = new ArrayList<>();

    private static void getLeaf(Node root) {
        if (root == null) return;
        getLeaf(root.left);
        getLeaf(root.right);
        if (root.left == null && root.right == null)
            res.add(root.value);
    }

    public static boolean com(Node root1, Node root2) {
        getLeaf(root1);
        ArrayList<Integer> leaf1 = new ArrayList<>(res);
        res.clear();

        getLeaf(root2);
        ArrayList<Integer> leaf2 = new ArrayList<>(res);
        res.clear();

        if (leaf1.size() != leaf2.size()) return false;
        for (int i = 0; i < leaf1.size(); i++) {
            int i1 = leaf1.get(i);
            int i2 = leaf2.get(i);
            if (i1 != i2) return false;
        }
        return true;
    }

    @Test
    public void test() {
        Node root1 = buildTree1();
        Node root2 = buildTree2();
        System.out.println(com(root1, root2));
    }

    /**
     * @param
     * @Description 声明：这只是一个二叉树，不是二叉搜索树
     * <p>
     * 10
     * 6        11
     * 3    7   9   12
     * @return: com.Java.math.tree.Node
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2020/6/27 3:35 PM
     **/
    public static Node buildTree1() {
        Node root = new Node(10);
        Node left1 = new Node(6);
        Node right1 = new Node(11);
        root.left = left1;
        root.right = right1;

        Node left2 = new Node(3);
        Node right2 = new Node(7);
        left1.left = left2;
        left1.right = right2;

        Node left3 = new Node(9);
        Node right3 = new Node(13);
        right1.left = left3;
        right1.right = right3;

        return root;
    }

    /**
     * @param
     * @Description 声明：这只是一个二叉树，不是二叉搜索树
     * <p>
     * 10
     * 6        11
     * 3    7   9   12
     * @return: com.Java.math.tree.Node
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2020/6/27 3:35 PM
     **/
    public static Node buildTree2() {
        Node root = new Node(8);
        Node left1 = new Node(6);
        Node right1 = new Node(11);
        root.left = left1;
        root.right = right1;

        Node left2 = new Node(3);
        Node right2 = new Node(7);
        left1.left = left2;
        left1.right = right2;

        Node left3 = new Node(9);
        Node right3 = new Node(12);
        right1.left = left3;
        right1.right = right3;

        return root;
    }

}
