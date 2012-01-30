package org.open;

import org.apache.log4j.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppLaunchListener implements ServletContextListener {
    private static Logger LOG = Logger.getLogger(AppLaunchListener.class);
    private static String PROP_FILE_NAME; //=mywebapp.properties, read from web.xml
    private static final String PROP_FILE_PARAM = "propfile";

    public void contextInitialized(final ServletContextEvent sce) {
        PROP_FILE_NAME = sce.getServletContext().getInitParameter(PROP_FILE_PARAM);
        LOG.info(AppProperties.getInstance());
        LOG.debug("AppLaunchListener:contextInitialized. sce=" + sce);
    }

    public void contextDestroyed(final ServletContextEvent sce) {
        LOG.debug("AppLaunchListener:contextDestroyed. sce=" + sce);
    }

    public static String getPropertyParamValue() {
        return PROP_FILE_NAME;
    }
}
