package com.source.workman.thread;

import com.source.workman.thread.pool.ThreadPoolDemo;
import com.source.workman.thread.pool.ThreadPoolUtil;

import java.util.Random;
import java.util.concurrent.*;

public class CountDownLatchDemo implements Runnable {
    static final CountDownLatch end = new CountDownLatch(10);
    static final CountDownLatchDemo demo = new CountDownLatchDemo();

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(10) * 1000);
            System.out.println(Thread.currentThread().getId() + ": check complete");
            end.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        ThreadPoolExecutor pool = ThreadPoolUtil.executor;
        for (int i = 0; i < 10; i++) {
            pool.submit(demo);
        }
        end.await();
        System.out.println("fire!");
        pool.shutdown();
    }
}
