package com.source.workman.thread.atomic;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest2 implements Runnable {
    private final ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 1000; j++) {
            lock.lock();
            try {
                i++;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest2 reentrantLock = new ReentrantLockTest2();
        Thread t1 = new Thread(reentrantLock);
        Thread t2 = new Thread(reentrantLock);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);

    }

}
