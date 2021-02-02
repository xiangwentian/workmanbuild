package com.source.workman.jol;

import org.openjdk.jol.info.ClassLayout;

public class HelloJol {
    public static void main(String[] args) throws Exception {
        Object object = new Object();
        System.out.println(ClassLayout.parseInstance(object).toPrintable());

//        synchronized (object) {
//            System.out.println(ClassLayout.parseInstance(object).toPrintable());
//        }
    }
}
