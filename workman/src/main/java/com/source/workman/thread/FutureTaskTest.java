package com.source.workman.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "return true";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask task = new FutureTask(new FutureTaskTest());
        new Thread(task).start();
        System.out.println(task.get());
    }
}
