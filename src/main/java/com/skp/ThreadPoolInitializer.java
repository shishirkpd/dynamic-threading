package com.skp;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.TimeUnit;

@WebListener
public class ThreadPoolInitializer implements ServletContextListener {

    private DynamicThreadPoolExecutor threadPool;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        threadPool = new DynamicThreadPoolExecutor(10, 20, 60, TimeUnit.SECONDS);
        sce.getServletContext().setAttribute("threadPool", threadPool);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        if (threadPool != null) {
            threadPool.shutdown();
            try {
                if (!threadPool.awaitTermination(60, TimeUnit.SECONDS)) {
                    threadPool.shutdownNow();
                }
            } catch (InterruptedException e) {
                threadPool.shutdownNow();
            }
        }
    }
}
