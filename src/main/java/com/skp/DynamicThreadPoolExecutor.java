package com.skp;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DynamicThreadPoolExecutor extends ThreadPoolExecutor {

    public DynamicThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, new LinkedBlockingQueue<>());
    }

    public void adjustPoolSize(int newCorePoolSize, int newMaximumPoolSize) {
        setCorePoolSize(newCorePoolSize);
        setMaximumPoolSize(newMaximumPoolSize);
    }
}
