package com.source.workman.tree.binaryTree;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * @ClassName TreeInOrder
 * @Deseription TODO
 * @Author workman
 * @Date 2023/2/4 13:44
 * @Version 1.0
 */
public class TreeInOrder {
    //中序递归遍历

    /**
     * @return void
     * @Author workman
     * @Description 递归：若二叉树为空，则空操作返回，否则从根结点开始（注意并不是先访问根结点），中序遍历根结点左子树，然后访问根结点，最后中序遍历右子树。
     * @Date 13:45 2023/2/4
     * @Param [tree]
     **/
    public static void inOrderRecurisively(TreeNode tree) {
        if (tree == null) {
            return;
        }
        inOrderRecurisively(tree.left);
        System.out.print(tree.val + "/5");
        inOrderRecurisively(tree.right);
    }

    //中序非递归遍历

    /**
     * @return void
     * @Author workman
     * @Description 非递归：可以使用一个栈来模拟这种操作。（利用回溯思想）
     * 若二叉树为空，则空操作返回，
     * 当根节点（root）与栈（stack）同时不为空，判断 root 是否为空，
     * 不为空：将root压栈，并将 root 指向其左孩子节点 root.left
     * 为空：输出栈顶节点值（stack.peek().val），让 root 指向 stack.pop()，并将 root 重新指向 root.right
     * @Date 13:47 2023/2/4
     * @Param [tree]
     **/
    public static void inOrderIteratively(TreeNode tree) {
        if (tree == null) {
            return;
        }
        TreeNode root = tree;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                System.out.print(stack.peek().val + "/t");
                root = stack.pop().right;
            }
        }
        System.out.println();
    }
}
