package org.open;

import org.apache.log4j.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public final class TimerFilter implements Filter {
    private static Logger LOG = Logger.getLogger(TimerFilter.class);
    public void init(final FilterConfig filterConfig) throws ServletException {
        LOG.debug("TimerFilter.init, filterConfig=" + filterConfig);
    }

    public void doFilter(final ServletRequest request, final ServletResponse response,
                         final FilterChain chain) throws IOException, ServletException {
        LOG.debug("TimerFilter.doFilter, request=" + request + ", response=" + response + ", chain=" + chain);
        final long startTime = System.currentTimeMillis();
        chain.doFilter(request, response);
        final long stopTime = System.currentTimeMillis();
        LOG.debug("Time to execute request: " + (stopTime - startTime) +
                " milliseconds");
    }

    public void destroy() {
        LOG.debug("TimerFilter.destroy");
    }
}
