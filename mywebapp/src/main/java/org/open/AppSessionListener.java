package org.open;

import com.sun.tools.example.debug.bdi.SessionListener;

import java.util.EventObject;

public class AppSessionListener implements SessionListener {
    public void sessionStart(final EventObject eventObject) {
        System.out.println("AppSessionListener.sessionStart, eventObject=" + eventObject);
    }

    public void sessionInterrupt(final EventObject eventObject) {
        System.out.println("AppSessionListener.sessionInterrupt, eventObject=" + eventObject);
    }

    public void sessionContinue(final EventObject eventObject) {
        System.out.println("AppSessionListener.sessionContinue, eventObject=" + eventObject);
    }
}
