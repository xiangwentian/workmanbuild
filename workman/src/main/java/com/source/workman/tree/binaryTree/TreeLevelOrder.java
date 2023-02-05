package com.source.workman.tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName TreeLevelOrder
 * @Deseription 层序遍历
 * @Author workman
 * @Date 2023/2/4 14:09
 * @Version 1.0
 */
public class TreeLevelOrder {
    // 层次遍历并顺序打印（借助队列）
    public static void levelOrder1(TreeNode tree) {
        if (tree == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        TreeNode temp = null;
        while (!queue.isEmpty()) {
            //检索并删除该队列的头部
            temp = queue.poll();
            System.out.print(temp.val + "/t");
            if (temp.left != null) {
                //插入到队列
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
        System.out.println();
    }

    public static void levelOrder2(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = size - 1; i >= 0; i--) {
                TreeNode temp = (TreeNode) queue.poll();
                System.out.print(temp.val + "/t");
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
        System.out.println();
    }
}
