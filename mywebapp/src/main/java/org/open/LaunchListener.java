package org.open;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by IntelliJ IDEA.
 * User: ssapar
 * Date: 1/12/12
 * Time: 10:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class LaunchListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("LaunchListener:contextInitialized. sce="+sce);

    }


    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("LaunchListener:contextDestroyed. sce="+sce);
    }
}
