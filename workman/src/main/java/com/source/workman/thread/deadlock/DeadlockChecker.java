package com.source.workman.thread.deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class DeadlockChecker {
    private final static ThreadMXBean mbean = ManagementFactory.getThreadMXBean();

    public static void check() {
        Thread tt = new Thread(() -> {
            while(true) {
                long[] deadlockedThreadIds = mbean.getAllThreadIds();
                if (deadlockedThreadIds != null) {
                    ThreadInfo[] threadInfos = mbean.getThreadInfo(deadlockedThreadIds);
                    for (Thread t : Thread.getAllStackTraces().keySet()) {
                        for (int i = 0; i < threadInfos.length; i++) {
                            if (t.getId() == threadInfos[i].getThreadId()) {
//                                System.out.println(t.getName());
                                t.interrupt();
                            }
                        }
                    }
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {}
            }
        });
        tt.setDaemon(true);
        tt.start();
    }
}
