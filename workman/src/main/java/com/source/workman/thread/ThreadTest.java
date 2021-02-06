package com.source.workman.thread;

public class ThreadTest extends Thread {

    String name;

    public ThreadTest(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(name + " world");
    }

    public static void main(String[] args) throws InterruptedException {
        //new ThreadTest("hello").start();
        Thread thread = new Thread(new ThreadTest("hello"));

        thread.start();
//        thread.join();
        System.out.println("---end---");
    }
}
