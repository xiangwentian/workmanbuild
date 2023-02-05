package com.source.workman.tree.binaryTree;

/**
 * @ClassName Main
 * @Deseription TODO
 * @Author workman
 * @Date 2023/2/4 14:50
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        //            1
        //              \
        //               2
        //              /
        //             3
        //pre->123  in->132   post->321  level->123
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        root.right = new TreeNode<Integer>(2);
        root.right.left = new TreeNode<Integer>(3);
        TreePostOrder treePreOrder = new TreePostOrder();
        treePreOrder.postOrderRecursively(root);
        System.out.println();
        treePreOrder.postOrderIteratively(root);
    }
}
