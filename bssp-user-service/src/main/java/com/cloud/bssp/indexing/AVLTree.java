package com.cloud.bssp.indexing;

import org.apache.commons.lang3.ObjectUtils;

/**
 * AVL树，平衡二叉树
 * @date: 2020/10/27
 * @author weirx
 * @version 3.0
 */
public class AVLTree {

    public static class Node {

        int key;
        int height = 0;
        Node right;
        Node left;
    }

    private static Node root;

    /**
     * 左单旋
     */
    public static void leftRotation() {

    }

    /**
     * 右单旋
     */
    public static void rightRotation() {

    }

    /**
     * 先左单旋，再右单旋
     */
    public static void leftRightRotation() {

    }

    /**
     * 先右单旋，再左单旋
     */
    public static void rightLeftRotation() {

    }

    public static void insert(int data) {
        //最终树
        Node result;
        //得到一个节点
        Node node = new Node();
        node.key = data;
        //判断当前根节点是否为空
        if (ObjectUtils.isEmpty(root)) {
            //空？
            root = node;
            root.height += 1;
        } else {
            //非空？
            //初始化一个当前节点，用于后面循环增加节点
            Node current = root;
            while (true) {
                result = current;
                if (data >= current.key) {
                    //添加到右侧
                    current = current.right;
                    if (ObjectUtils.isEmpty(current)) {
                        result.right = node;
                        result.right.height = 1;
                        root.height += 1;
                        //判断当前树高度
                        return;
                    }
                } else {
                    //添加到左侧
                    current = current.left;
                    if (ObjectUtils.isEmpty(current)) {
                        result.left = node;
                        return;
                    }
                }
            }
        }
    }
}
