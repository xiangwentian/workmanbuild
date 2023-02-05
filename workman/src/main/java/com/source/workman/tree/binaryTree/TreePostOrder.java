package com.source.workman.tree.binaryTree;

import java.util.Stack;

/**
 * @ClassName TreePostOrder
 * @Deseription 后序遍历
 * @Author workman
 * @Date 2023/2/4 13:58
 * @Version 1.0
 */
public class TreePostOrder {

    //后序递归遍历

    /**
     * @return void
     * @Author workman
     * @Description 递归：若二叉树为空，则空操作返回，否则从左到右先叶子后结点的方式遍历访问左右子树，最后是访问根结点。
     * @Date 14:02 2023/2/4
     * @Param [tree]
     **/
    public static void postOrderRecursively(TreeNode tree) {
        if (tree == null) {
            return;
        }
        postOrderRecursively(tree.left);
        postOrderRecursively(tree.right);
        System.out.print(tree.val + "/t");
    }

    /**
     * @return void
     * @Author workman
     * @Description 非递归：可以使用一个栈（stack）和上一个访问节点（prevVisted）来模拟这种操作。（利用回溯思想）
     * 若二叉树为空，则空操作返回，
     * 当根节点（root）与 stack 同时不为空，判断 root 是否为空，
     * 不为空：将 root 压栈，并将 root 指向 root.left
     * 为空：让 root 指向 stack.peek().right（栈顶节点的右节点），判断 root 是否为空以及是否等于 prevVisted
     * 若root 不为空 且 不等于 prevVisted：将 root 压栈，并将 root 指向 root.left
     * 否则：prevVisted 指向 stack.pop()，输出该节点值 prevVisted.val，root 指向null
     * @Date 14:02 2023/2/4
     * @Param [tree]
     **/
    public static void postOrderIteratively(TreeNode tree) {
        if (tree == null) {
            return;
        }
        TreeNode root = tree;
        TreeNode prevVisited = null;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.peek().right;
                if (root != null && root != prevVisited) {
                    stack.push(root);
                    root = root.left;
                } else {
                    prevVisited = stack.pop();
                    System.out.print(prevVisited.val + "/t");
                    root = null;
                }
            }
        }
        System.out.println();
    }
}
