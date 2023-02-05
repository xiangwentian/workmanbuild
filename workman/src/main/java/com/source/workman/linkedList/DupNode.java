package com.source.workman.linkedList;

/**
 * @ClassName DupNode
 * @Deseription 双向循环链表结点类
 * @Author workman
 * @Date 2023/2/5 14:07
 * @Version 1.0
 */
public class DupNode {
    Object object;
    //前驱指针域
    DupNode prior;
    //后继指针域
    DupNode next;

    public DupNode() {
        this(null);
    }

    public DupNode(Object object) {
        this(object, null, null);
    }

    public DupNode(Object object, DupNode prior, DupNode next) {
        this.object = object;
        this.prior = prior;
        this.next = next;
    }
}
