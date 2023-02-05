package com.source.workman.tree.binaryTree;

/**
 * @ClassName TreeNode
 * @Deseription 二叉树数据结构
 * @Author workman
 * @Date 2023/2/4 13:25
 * @Version 1.0
 */
public class TreeNode<T> {
    public int val;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
