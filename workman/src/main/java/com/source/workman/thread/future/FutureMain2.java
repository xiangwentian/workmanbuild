package com.source.workman.thread.future;

import java.util.concurrent.*;

public class FutureMain2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        //new thread invoke RealData call() method
        Future<String> future = executor.submit(new RealData("a"));
        System.out.println("request end");
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
