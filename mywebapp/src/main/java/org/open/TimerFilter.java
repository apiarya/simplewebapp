package org.open;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public final class TimerFilter implements Filter {
    public void init(final FilterConfig filterConfig) throws ServletException {
        System.out.println("TimerFilter.init, filterConfig=" + filterConfig);
    }

    public void doFilter(final ServletRequest request, final ServletResponse response,
                         final FilterChain chain) throws IOException, ServletException {
        System.out.println("TimerFilter.doFilter, request=" + request + ", response=" + response + ", chain=" + chain);
        final long startTime = System.currentTimeMillis();
        chain.doFilter(request, response);
        final long stopTime = System.currentTimeMillis();
        System.out.println("Time to execute request: " + (stopTime - startTime) +
                " milliseconds");
    }

    public void destroy() {
        System.out.println("TimerFilter.destroy");
    }
}
