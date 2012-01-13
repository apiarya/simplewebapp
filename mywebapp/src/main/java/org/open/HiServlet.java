package org.open;

import java.io.*;

import javax.servlet.http.*;
import javax.servlet.*;

public class HiServlet extends HttpServlet {
    public void doGet (HttpServletRequest req,
                       HttpServletResponse res)
            throws ServletException, IOException
    {
        PrintWriter out = res.getWriter();

        out.println("Hi World Servlet");
        out.close();
    }
}