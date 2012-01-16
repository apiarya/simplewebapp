package org.open;

import org.apache.log4j.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppLaunchListener implements ServletContextListener {
    private static Logger LOG = Logger.getLogger(AppLaunchListener.class);
    public void contextInitialized(final ServletContextEvent sce) {
        LOG.debug("AppLaunchListener:contextInitialized. sce=" + sce);

    }


    public void contextDestroyed(final ServletContextEvent sce) {
        LOG.debug("AppLaunchListener:contextDestroyed. sce=" + sce);
    }
}
