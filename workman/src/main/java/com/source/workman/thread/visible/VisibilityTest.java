package com.source.workman.thread.visible;

public class VisibilityTest extends Thread {
    private volatile boolean stop;
    //wrong test,not statement volatile,not visible
    //private boolean stop;

    public void run() {
        int i = 0;
        while (!stop) {
            i++;
        }
        System.out.println("finish loop,i=" + i);
    }

    public void stopIt() {
        stop = true;
    }

    public boolean getStop() {
        return stop;
    }

    public static void main(String[] args) throws InterruptedException {
        VisibilityTest v = new VisibilityTest();
        v.start();

        Thread.sleep(100);
        v.stopIt();
        Thread.sleep(2000);
        System.out.println("finish main");
        System.out.println(v.getStop());
    }
}
