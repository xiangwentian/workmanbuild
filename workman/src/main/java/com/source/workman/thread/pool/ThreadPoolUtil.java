package com.source.workman.thread.pool;

import java.util.concurrent.*;

/**
 * 线程池
 */
public class ThreadPoolUtil {
    private static int corePoolSize = 10;
    private static int maximumPoolSize = 10;
    private static int keepAliveTime = 60;
    private static TimeUnit SECONDS = TimeUnit.SECONDS;
    private static BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(10);
    private static ThreadFactory threadFactory = Executors.defaultThreadFactory();
    private static RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();

    public final static ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, SECONDS, workQueue, threadFactory, handler);
}
