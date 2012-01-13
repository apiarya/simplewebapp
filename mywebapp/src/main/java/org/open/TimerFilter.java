package org.open;

import javax.servlet.*;
import java.io.IOException;

public final class TimerFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("TimerFilter.init, filterConfig=" + filterConfig);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("TimerFilter.doFilter, request=" + request + ", response=" + response + ", chain=" + chain);
        long startTime = System.currentTimeMillis();
        chain.doFilter(request, response);
        long stopTime = System.currentTimeMillis();
        System.out.println("Time to execute request: " + (stopTime - startTime) +
                " milliseconds");
    }

    public void destroy() {
        System.out.println("TimerFilter.destroy");
    }
}
