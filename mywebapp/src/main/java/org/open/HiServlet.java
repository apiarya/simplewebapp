package org.open;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HiServlet extends HttpServlet {
    public void doGet(final HttpServletRequest req,
                      final HttpServletResponse res)
            throws ServletException, IOException {
        final PrintWriter out = res.getWriter();

        out.println("Hi World Servlet");
        out.println(AppProperties.getInstance());
        out.close();
    }
}