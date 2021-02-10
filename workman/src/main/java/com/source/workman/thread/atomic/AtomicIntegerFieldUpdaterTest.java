package com.source.workman.thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 尽量少的修改代码，使代码具备原子性
 */
public class AtomicIntegerFieldUpdaterTest {
    public static class Candidate {
        int id;
        volatile int score;
    }

    public final static AtomicIntegerFieldUpdater<Candidate> scoreUpdate = AtomicIntegerFieldUpdater.newUpdater(Candidate.class, "score");
    //check updater is worked
    public static AtomicInteger allScore = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        final Candidate stu = new Candidate();
        Thread[] t = new Thread[1000];
        for (int i = 0; i < 1000; i++) {
            t[i] = new Thread() {
                public void run() {
                    if (Math.random() > 0.4) {
                        scoreUpdate.incrementAndGet(stu);
                        allScore.incrementAndGet();
                    }
                }
            };
            t[i].start();
        }

        for (int i = 0; i < 1000; i++) {
            t[i].join();
        }

        System.out.println("score= " + stu.score);
        System.out.println("allScore= " + allScore);
    }
}
