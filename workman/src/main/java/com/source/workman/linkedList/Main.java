package com.source.workman.linkedList;

/**
 * @ClassName Main
 * @Deseription TODO
 * @Author workman
 * @Date 2023/2/5 14:27
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        DoubleLinkedTable linkedTable = new DoubleLinkedTable();
        linkedTable.insert(0, "张三");
        linkedTable.insert(1, "李四");
        linkedTable.insert(2, "赵五");
        linkedTable.display();
        System.out.println("==============");
        linkedTable.remove(1);
        linkedTable.display();
    }
}
