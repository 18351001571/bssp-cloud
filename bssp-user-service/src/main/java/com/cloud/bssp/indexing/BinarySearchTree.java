package com.cloud.bssp.indexing;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.RandomUtils;

/**
 * 二叉搜索树
 * @date: 2020/10/27
 * @author weirx
 * @version 3.0
 */
public class BinarySearchTree {

    public static class Node {
        int data;
        Node left;
        Node right;
    }

    /**
     * 根节点
     */
    private static Node root;

    public static void insert(int data) {
        //最终树
        Node result;
        //得到一个节点
        Node node = new Node();
        node.data = data;
        //判断当前根节点是否为空
        if (ObjectUtils.isEmpty(root)) {
            //空？
            root = node;
        } else {
            //非空？
            //初始化一个当前节点，用于后面循环增加节点
            Node current = root;
            while (true) {
                result = current;
                if (data >= current.data) {
                    //添加到右侧
                    current = current.right;
                    if (ObjectUtils.isEmpty(current)) {
                        result.right = node;
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

    public static void main(String[] args) {
        int num;
        for (int i = 0; i < 10; i++) {
            num = RandomUtils.nextInt(0, 10);
            BinarySearchTree.insert(num);
            System.out.println(num);
        }
        //没实际意义，用于打个断点观察root
        System.out.println();
    }

}
