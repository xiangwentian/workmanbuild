package com.source.workman.tree.binaryTree;

import java.util.Stack;

/**
 * @ClassName TreePreOrder
 * @Deseription TODO
 * @Author workman
 * @Date 2023/2/4 13:33
 * @Version 1.0
 */
public class TreePreOrder {
    //前序递归遍历

    /**
     * @return void
     * @Author workman
     * @Description 递归：若二叉树为空，则空操作返回，否则先访问根结点，然后前序遍历左子树，再前序遍历右子树
     * @Date 13:42 2023/2/4
     * @Param [tree]
     **/
    public static void preOrderRecursively(TreeNode tree) {
        if (tree == null) {
            return;
        }
        System.out.print(tree.val + "\t");
        preOrderRecursively(tree.left);
        preOrderRecursively(tree.right);
    }

    //前序非递归遍历

    /**
     * @return void
     * @Author workman
     * @Description 非递归：可以使用一个栈来模拟这种操作。（利用回溯思想）
     * 若二叉树为空，则空操作返回，
     * 当根节点（root）与栈（stack）同时不为空，判断 root 是否为空，
     * 不为空：输出 root.val，将 root 压栈，并将 root 指向 root.left
     * 为空：让 root 指向 stack.pop() ，并将 root 指向 root.right
     * @Date 13:42 2023/2/4
     * @Param [tree]
     **/
    public static void preOrderIteratively(TreeNode tree) {
        if (tree == null) {
            return;
        }
        TreeNode root = tree;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                System.out.print(root.val + "\t");
                //push 入栈
                stack.push(root);
                root = root.left;
            } else {
                //pop 出栈
                root = stack.pop().right;
            }
        }
        System.out.println();
    }
}
