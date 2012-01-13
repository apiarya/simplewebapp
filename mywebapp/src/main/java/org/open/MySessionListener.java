package org.open;

import com.sun.tools.example.debug.bdi.SessionListener;

import java.util.EventObject;

/**
 * Created by IntelliJ IDEA.
 * User: ssapar
 * Date: 1/12/12
 * Time: 10:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class MySessionListener implements SessionListener{
    public void sessionStart(EventObject eventObject) {
        System.out.println("MySessionListener.sessionStart, eventObject="+eventObject);
    }

    public void sessionInterrupt(EventObject eventObject) {
        System.out.println("MySessionListener.sessionInterrupt, eventObject="+eventObject);
    }

    public void sessionContinue(EventObject eventObject) {
        System.out.println("MySessionListener.sessionContinue, eventObject="+eventObject);
    }
}
