package com.skp;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class DynamicThreadPoolFilter implements Filter {

    private DynamicThreadPoolExecutor threadPool;

    @Override
    public void init(FilterConfig filterConfig) {
        threadPool = (DynamicThreadPoolExecutor) filterConfig.getServletContext().getAttribute("threadPool");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        if (threadPool != null) {
            int activeCount = threadPool.getActiveCount();
            int corePoolSize = threadPool.getCorePoolSize();
            int maxPoolSize = threadPool.getMaximumPoolSize();

            if (activeCount > corePoolSize * 0.75 && corePoolSize < maxPoolSize) {
                threadPool.adjustPoolSize(corePoolSize + 5, maxPoolSize + 10);
            } else if (activeCount < corePoolSize * 0.25 && corePoolSize > 10) {
                threadPool.adjustPoolSize(corePoolSize - 5, maxPoolSize - 10);
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // No cleanup necessary
    }
}
