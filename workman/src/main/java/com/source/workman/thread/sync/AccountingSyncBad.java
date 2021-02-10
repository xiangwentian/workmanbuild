package com.source.workman.thread.sync;

/**
 * 错误的加锁demo
 * 锁的是当前对象实例
 */
public class AccountingSyncBad implements Runnable {
    static int i = 0;

    public synchronized void increase() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 20000; j++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //thead每次都是new的实例，锁的不是同一个对象，导致加锁失败，数据不一致
        Thread t1 = new Thread(new AccountingSyncBad());
        Thread t2 = new Thread(new AccountingSyncBad());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
