package com.source.workman.thread;

public class RunnableTest implements Runnable {

    String name;

    public RunnableTest(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " world");
    }

    public static void main(String[] args) {
        new Thread(new RunnableTest("hello")).start();
    }
}
