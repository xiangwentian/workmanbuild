package com.source.workman.thread.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> future = new FutureTask<>(new RealData("a"));
        ExecutorService executor = Executors.newFixedThreadPool(1);
        //new thread invoke RealData call() method
        executor.submit(future);
        try {
            //do other things
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //get result,get result of call()
        System.out.println("data=" + future.get());
        executor.shutdown();
    }
}
