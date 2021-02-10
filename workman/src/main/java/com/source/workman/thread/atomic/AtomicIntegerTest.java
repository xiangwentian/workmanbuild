package com.source.workman.thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest implements Runnable {
    public AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public void run() {
        boolean flag = atomicInteger.compareAndSet(0, 1);
        System.out.println(Thread.currentThread().getName() + " : " + flag);
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerTest atomicIntegerTest = new AtomicIntegerTest();

        Thread t1 = new Thread(atomicIntegerTest);
        Thread t2 = new Thread(atomicIntegerTest);
        Thread t3 = new Thread(atomicIntegerTest);

        t1.setName("t1");
        t1.start();

        t2.setName("t2");
        t2.start();

        t1.join();
        t2.join();

        atomicIntegerTest.atomicInteger.getAndDecrement();

        t3.setName("t3");
        t3.start();
    }
}
