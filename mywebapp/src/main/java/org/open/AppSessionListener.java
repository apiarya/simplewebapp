package org.open;

import com.sun.tools.example.debug.bdi.SessionListener;
import org.apache.log4j.Logger;
import java.util.EventObject;

public class AppSessionListener implements SessionListener {
    private static Logger LOG = Logger.getLogger(AppSessionListener.class);

    public void sessionStart(final EventObject eventObject) {
        LOG.debug("AppSessionListener.sessionStart, eventObject=" + eventObject);
    }

    public void sessionInterrupt(final EventObject eventObject) {
        LOG.debug("AppSessionListener.sessionInterrupt, eventObject=" + eventObject);
    }

    public void sessionContinue(final EventObject eventObject) {
        LOG.debug("AppSessionListener.sessionContinue, eventObject=" + eventObject);
    }
}
