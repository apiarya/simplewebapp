package org.open;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppLaunchListener implements ServletContextListener {
    public void contextInitialized(final ServletContextEvent sce) {
        System.out.println("AppLaunchListener:contextInitialized. sce=" + sce);

    }


    public void contextDestroyed(final ServletContextEvent sce) {
        System.out.println("AppLaunchListener:contextDestroyed. sce=" + sce);
    }
}
