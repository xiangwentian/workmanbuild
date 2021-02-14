package com.source.workman.thread.atomic;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCondition2 {
    private int queueSize = 10;
    private PriorityQueue<Integer> queue = new PriorityQueue<Integer>(queueSize);

    private Lock lock = new ReentrantLock();
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();

    class Consumer implements Runnable {

        @Override
        public void run() {
            consume();
        }

        /**
         * 消费者
         */
        private void consume() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == 0) {
                        try {
                            System.out.println("队列空，等待数据");
                            empty.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Integer i = queue.poll();
                    full.signal();
                    System.out.println("从队列取走一个元素:" + i + "，队列剩余" + queue.size() + "个元素");
                } finally {
                    lock.unlock();
                }
            }

        }
    }

    /**
     * 消费者
     */
    class Producer implements Runnable {

        @Override
        public void run() {
            produce();
        }

        private void produce() {
            int i=1;
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == queueSize) {
                        try {
                            System.out.println("队列满，等待有空余空间");
                            full.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
//                    queue.offer(1);
                    queue.offer(i++);
                    empty.signal();
                } finally {
                    lock.unlock();
                }
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockCondition2 r2 = new ReentrantLockCondition2();
        Consumer cus = r2.new Consumer();
        Producer pro = r2.new Producer();
        Thread cusT = new Thread(cus);
        Thread proT = new Thread(pro);

        proT.start();
        cusT.start();
    }
}
