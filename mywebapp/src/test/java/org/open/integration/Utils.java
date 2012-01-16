package org.open.integration;


import org.apache.log4j.Logger;

public class Utils {
    private static Logger LOG = Logger.getLogger(Utils.class);

    private static boolean isLo4jInitialized = false;
    private static String BASE_URL = "not-initialized";
    static {
        LOG.debug("properties dump"+System.getProperties());
        initTests();
    }


    private static void initTests() {
        if (isLo4jInitialized) {
            return;
        }
        String port = System.getProperty("jetty.port");
        String appContext = System.getProperty("app.context");
        BASE_URL = "http://localhost:"+port+"/"+appContext;
        LOG.info("Base URL=" + BASE_URL);
        isLo4jInitialized = true;
    }

    public static String getBaseURL() {
        return BASE_URL;
    }

}
