package com.source.workman.linkedList;

/**
 * @ClassName DoubleLinkedTable
 * @Deseription 双向循环链表的实现类 该类包含了数据域，后继指针域、前驱指针域三个属性
 * @Author workman
 * @Date 2023/2/5 14:10
 * @Version 1.0
 */
public class DoubleLinkedTable {
    //头结点
    DupNode head;

    public DoubleLinkedTable() {
        head = new DupNode();
        head.prior = head;
        head.next = head;
    }

    public int length() {
        DupNode node = head.next;
        int j = 0;
        while (!node.equals(head)) {
            j++;
            node = node.next;
        }
        return j;
    }

    public void display() {
        DupNode node = head.next;
        while (!node.equals(head)) {
            System.out.println(node.object);
            node = node.next;
        }
    }

    public void clear() {
        head.next = head;
        head.prior = head;
    }

    /**
     * 思路：
     * 1.寻找下标为i-1的数据元素，注意退出循环的条件应该是node！=head
     * 2.赋值即可，循环链表的核心就是空表也会有循环体系
     * 3，赋值时，i+1位置的元素应该是node.next 所以，应为node.next最后赋值
     *
     * @param i
     * @param object
     * @throws Exception
     */
    public void insert(int i, Object object) throws Exception {
        if (i < 0 || i > length()) {
            throw new Exception("下标不合法");
        }
        DupNode node = head;
        int j = 0;

        while (!node.next.equals(head) && j < i) {
            j++;
            node = node.next;
        }

        DupNode newNode = new DupNode(object, node, node.next);
        node.next.prior = newNode;
        node.next = newNode;
    }

    public void remove(int i) throws Exception {
        if (i < 0 || i > length() - 1) {
            throw new Exception("下标不合法");
        }
        DupNode node = head;
        int j = 0;
        while (!node.next.equals(head) && j < i) {
            j++;
            node = node.next;
        }
        node.next = node.next.next;
        node.next.prior = node;
    }

    public DupNode getNode(int i) throws Exception {
        if (i < 0 || i > length() - 1) {
            throw new Exception("下标不合法");
        }
        DupNode node = head.next;
        int j = 0;
        while (node.equals(head) && j < i) {
            j++;
            node = node.next;
        }
        return node;
    }

    public Object get(int i) throws Exception{
        return getNode(i).object;
    }

    public Object getPrior(int i)throws Exception{
        return getNode(i).prior.object;
    }

    public Object getNext(int i) throws Exception{
        return getNode(i).next.object;
    }
}
