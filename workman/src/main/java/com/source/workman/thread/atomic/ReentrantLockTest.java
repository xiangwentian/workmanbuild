package com.source.workman.thread.atomic;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    private final ReentrantLock lock = new ReentrantLock();

    public void m() {
        lock.lock();
        try {
            doSomething(Thread.currentThread().getName());
        } finally {
            lock.unlock();
        }
    }

    private void doSomething(String threadName) {
        System.out.println("hello " + threadName);
    }

    public static void main(String[] args) {
        ReentrantLockTest reentrantLock = new ReentrantLockTest();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                reentrantLock.m();
            }, "test" + i).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                reentrantLock.m();
            }, "test_" + i).start();
        }
    }
}
