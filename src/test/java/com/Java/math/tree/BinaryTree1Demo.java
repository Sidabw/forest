/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: BinaryTreeDemo
 * Author:   feiyi
 * Date:     2020/6/26 12:29 PM
 * Description: 二叉树学习Demo
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.math.tree;

import java.util.ArrayDeque;

/**
 * 〈一句话功能简述〉:
 * 〈二叉树学习Demo〉
 *
 * @author feiyi
 * @create 2020/6/26
 * @since 1.0.0
 */
public class BinaryTree1Demo {

    public static void main(String[] args) {
        Node root = buildTree();
//        preOrder(root);
//        inOrder(root);
        postOrder(root);
//        levelOrder(root);
    }

    //前序遍历(先打印当前节点，再打印左子树，再打印右子树)
    private static void preOrder(Node root) {
        if (root != null)
            System.out.println(root.value);
        else
            return;
        preOrder(root.left);
        preOrder(root.right);
    }

    //中序遍历（先打印左子树，再打印本身，再打印右子树）
    public static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.value);
        inOrder(root.right);
    }

    //后序遍历（先打印左子树，再打印右子树，再打印本身）
    public static void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.value);
    }

    //分层遍历
    public static void levelOrder(Node root) {
        ArrayDeque<Node> nodes = new ArrayDeque<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            Node poll = nodes.poll();
            System.out.println(poll.value);
            if (poll.left != null)
                nodes.offer(poll.left);
            if (poll.right != null)
                nodes.offer(poll.right);
        }
    }

    /**
     * @Description
     *
     * 声明：这只是一个二叉树，不是二叉搜索树
     *
     *        10
     *   6        11
     * 3    7   9   12
     * @param
     * @return: com.Java.math.tree.Node
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2020/6/27 3:35 PM
     **/
    public static Node buildTree() {
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
        Node right3 = new Node(12);
        right1.left = left3;
        right1.right = right3;

        return root;
    }
}

class Node{

    int value;

    Node left;

    Node right;

    public Node(int value) {
        this.value = value;
    }
}
