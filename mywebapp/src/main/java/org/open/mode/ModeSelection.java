package org.open.mode;

import org.apache.log4j.Logger;
import org.open.AppProperties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ModeSelection extends HttpServlet {

    private static Logger LOG = Logger.getLogger(ModeSelection.class);

    public void doGet(final HttpServletRequest req,
                      final HttpServletResponse res)
            throws ServletException, IOException {
        LOG.debug("Hi ModeSelection Servlet");
        String mode = AppProperties.getInstance().getResourceMode();
        String location = req.getContextPath() + "/mode/" + mode + "/book.jsp";
        LOG.info("Sending redirect to " + location);
        res.sendRedirect(location);
    }
}