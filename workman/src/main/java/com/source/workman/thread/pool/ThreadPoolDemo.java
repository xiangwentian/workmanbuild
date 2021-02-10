package com.source.workman.thread.pool;

import com.source.workman.thread.RunnableTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 100; i++) {
            executorService.execute(new RunnableTest(i + ""));
        }
    }
}
