package com.xyzh.testLibrary.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Author:Jenny
 * Date:2017/7/18
 * E-mail:fishloveqin@gmail.com
 * 线程池
 */

public class ThreadPoolProxy {

    private static ThreadPoolExecutor mThreadPoolExecutor = null;

    private int                       corePoolSize;
    private int                       maximumPoolSize;
    private long                      keepAliveTime;

    private ThreadPoolProxy() {
    }

    private static final int             CORE_SIZE       = 3;
    private static final int             MAX_SIZE        = 5;
    private static final int             KEEP_ALIVE_TIME = 3000;
    private static final ThreadPoolProxy instance        = new ThreadPoolProxy();

    public static ThreadPoolProxy getInstance() {


        return instance;
    }

    private static ThreadPoolExecutor initExecutor() {
        if (mThreadPoolExecutor == null) {
            synchronized (ThreadPoolProxy.class) {
                if (mThreadPoolExecutor == null) {

                    TimeUnit unit = TimeUnit.MILLISECONDS;
                    ThreadFactory threadFactory = Executors.defaultThreadFactory();
                    RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
                    LinkedBlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();

                    mThreadPoolExecutor = new ThreadPoolExecutor(CORE_SIZE, //核心线程数
                        MAX_SIZE, //最大线程数
                        KEEP_ALIVE_TIME, //保持时间
                        unit, //保持时间对应的单位
                        workQueue, threadFactory, //线程工厂
                        handler);//异常捕获器
                }
            }
        }
        return mThreadPoolExecutor;
    }

    /**执行任务*/
    public void executeTask(Runnable r) {
        initExecutor();
        mThreadPoolExecutor.execute(r);
    }

    /**提交任务*/
    public Future<?> commitTask(Runnable r) {
        initExecutor();
        return mThreadPoolExecutor.submit(r);
    }

    /**删除任务*/
    public void removeTask(Runnable r) {
        initExecutor();
        mThreadPoolExecutor.remove(r);
    }

}
