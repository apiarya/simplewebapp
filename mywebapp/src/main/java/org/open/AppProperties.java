package org.open;


import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.File;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.Iterator;

// protect new, clone, serialize and reflection
public class AppProperties implements Serializable {
    public static int counter = 0;
    final static Logger LOG = Logger.getLogger(AppProperties.class);
    private static final String ENV_PROP_NAME = "MY_WEB_APP_PROPS_DIR";
    private static PropertiesConfiguration PROPS_CONFIG;
    private static final String LOG4J_PROPS = "log4j.properties";

    private static class Inner {
        private static final AppProperties ONLY = new AppProperties();
    }

    public static AppProperties getInstance() {
        return Inner.ONLY;
    }

    private AppProperties() {
        StackTraceElement[] st = Thread.currentThread().getStackTrace();
        if (st[2].getMethodName().startsWith("newInstance")) {
            throw new InstantiationError("reflection not allowed");
        }
        counter++;
        String folderName = null;
        try {
            InitialContext context = new InitialContext();
            folderName = (String) context.lookup("java:comp/env/" + ENV_PROP_NAME);
            initLog4J(folderName);

        } catch (NamingException exp) {
            LOG.warn("exception in jndi lookup, " + ENV_PROP_NAME + " NOT found in java:comp/env/");
            folderName = null;
        }
        if (folderName != null) {
            LOG.info("Found in java:comp/env/" + ENV_PROP_NAME + "=" + folderName);
            File configFile = new File(folderName + "/" + AppLaunchListener.getPropertyParamValue());
            try {
                PROPS_CONFIG = new PropertiesConfiguration(configFile);
                PROPS_CONFIG.setReloadingStrategy(new FileChangedReloadingStrategy());
                LOG.info("Loaded properties from CONTEXT. " + PROPS_CONFIG.getBasePath());
            } catch (ConfigurationException exp) {
                LOG.error("exception loading properties file " + configFile, exp);
                folderName = null;
            }
        }
        if (folderName == null) {
            try {
                PROPS_CONFIG = new PropertiesConfiguration(AppLaunchListener.getPropertyParamValue());
                PROPS_CONFIG.setReloadingStrategy(new FileChangedReloadingStrategy());
                LOG.info("Loaded properties from CLASSPATH. " + PROPS_CONFIG);

            } catch (ConfigurationException e) {
                LOG.fatal("Failed to load properties from classpath propStream" + PROPS_CONFIG);
            }
        }
        LOG.info("One and only instance created.");
    }

    private void initLog4J(String prefix) {
        PropertyConfigurator.configureAndWatch(prefix + "/" + LOG4J_PROPS);
    }

    public String getProperty(String key, String defaultValue) {
        Object value = PROPS_CONFIG.getProperty(key);
        if (null != value) {
            return value.toString();
        }
        LOG.warn("key missing from property file. key: " + key + ", BASE_PATH: " + PROPS_CONFIG.getBasePath());
        return defaultValue;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("AppProperties[");
        sb.append(", BASE_PATH: ").append(PROPS_CONFIG.getBasePath());
        Iterator<String> keyIterator = PROPS_CONFIG.getKeys();
        while (keyIterator.hasNext()) {
            String key = keyIterator.next();
            Object value = PROPS_CONFIG.getProperty(key);
            sb.append(" ").append(key).append(": ").append(value).append(", ");
        }
        sb.append("]");
        return sb.toString();
    }


    private Object readResolve() throws ObjectStreamException {
        return getInstance();
    }

    public Object clone() {
        return getInstance();
    }

    public static void main(String[] args) {
        AppProperties s4 = AppProperties.getInstance();
        s4.toString();
        ((AppProperties) s4.clone()).toString();
        Constructor[] cons = AppProperties.class.getDeclaredConstructors();
        Constructor c = cons[0].getParameterTypes().length == 0 ? cons[0] : cons[1];
        try {
            AppProperties s = (AppProperties) (c.newInstance(new Object[0]));
            s.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final String PROP_RESOURCE_MODE = "resourcemode";

    public String getResourceMode() {
        return getProperty(PROP_RESOURCE_MODE, "debug");
    }


}