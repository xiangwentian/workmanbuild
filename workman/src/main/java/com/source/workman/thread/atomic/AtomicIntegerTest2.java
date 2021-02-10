package com.source.workman.thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest2 {
    public AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerTest2 atomicIntegerTest = new AtomicIntegerTest2();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean flag = atomicIntegerTest.atomicInteger.compareAndSet(0, 1);
                System.out.println("t1: " + flag);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (flag) {
                    atomicIntegerTest.atomicInteger.getAndDecrement();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean flag = atomicIntegerTest.atomicInteger.compareAndSet(0, 1);
                System.out.println("t2: " + flag);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (flag) {
                    atomicIntegerTest.atomicInteger.getAndDecrement();
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean flag = atomicIntegerTest.atomicInteger.compareAndSet(0, 1);
                System.out.println("t3: " + flag);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (flag) {
                    atomicIntegerTest.atomicInteger.getAndDecrement();
                }
            }
        });

        t1.start();

        t2.start();

        t3.start();
    }
}
