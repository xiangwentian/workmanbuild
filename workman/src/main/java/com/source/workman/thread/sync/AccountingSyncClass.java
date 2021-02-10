package com.source.workman.thread.sync;

/**
 * 用static修饰 锁的当前类的实例
 */
public class AccountingSyncClass implements Runnable {
    static int i = 0;

    public static synchronized void increase() {
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
        Thread t1 = new Thread(new AccountingSyncClass());
        Thread t2 = new Thread(new AccountingSyncClass());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
