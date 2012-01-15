<?xml version="1.0" encoding="UTF-8"?>
<%@ page import="java.util.*" %>
<%
    Cookie[] cookies = request.getCookies();
    if (cookies == null)
      cookies = new Cookie[0];
    %>

This page: <a href="<%=request.getRequestURL()%>"><%=request.getRequestURL()%></a>

<html xmlns="http://www.w3.org/1999/xhtml">
    <body>
        <h1>Footer JSP</h1>
        <table border="1">
            <tr><th colspan="2">application</th></tr>
            <tr><td>application.getServletContextName </td><td><%=application.getServletContextName()%></td></tr>
            <tr><td>application.getServerInfo         </td><td><%=application.getServerInfo()%></td></tr>
            <tr><td>application.getMajorVersion       </td><td><%=application.getMajorVersion()%></td></tr>
            <tr><td>application.getMinorVersion       </td><td><%=application.getMinorVersion()%></td></tr>
            <tr><td>application                       </td><td><%=application%></td></tr>
            <tr><td>application.getAttributeNames     </td><td><%=application.getAttributeNames()%></td></tr>
        </table>

        <table border="1">
            <tr><th colspan="2">config</th></tr>
            <tr><td>config.getServletName           </td><td><%=config.getServletName()%></td></tr>
            <tr><td>config.getInitParameterNames    </td><td><%=config.getInitParameterNames()%></td></tr>
        </table>

        <table border="1">
            <tr><th colspan="2">request</th></tr>
            <tr><td>request.getProtocol             </td><td><%=request.getProtocol()%></td></tr>
            <tr><td>request.getMethod               </td><td><%=request.getMethod()%></td></tr>
            <tr><td>request.ServerName              </td><td><%=request.getServerName()%></td></tr>
            <tr><td>request.getServerPort           </td><td><%=request.getServerPort()%></td></tr>
            <tr><td>request.getRequestURI           </td><td><%=request.getRequestURI()%></td></tr>
            <tr><td>request.getRequestURL           </td><td><%=request.getRequestURL()%></td></tr>
            <tr><td>request.getServletPath          </td><td><%=request.getServletPath()%></td></tr>
            <tr><td>request.getRealPath("/")        </td><td><%=request.getRealPath("/")%>
            <tr><td>request.getContextPath()        </td><td><%=request.getContextPath( )%>
            <tr><td>request.getPathInfo             </td><td><%=request.getPathInfo()%></td></tr>
            <tr><td>request.getQueryString          </td><td><%=request.getQueryString()%></td></tr>
            <tr><td>request.getRemoteHost           </td><td><%=request.getRemoteHost()%></td></tr>
            <tr><td>request.getRemoteAddr           </td><td><%=request.getRemoteAddr()%></td></tr>
            <tr><td>request.getRemoteUser           </td><td><%=request.getRemoteUser()%></td></tr>
            <tr><td>request.getRequestedSessionId   </td><td><%=request.getRequestedSessionId()%></td></tr>
            <tr><td>request.getUserPrincipal        </td><td><%=request.getUserPrincipal()%></td></tr>
        </table>

        <table border="1">
            <tr><th colspan="2">request</th></tr>
            <tr><td>request.getPathTranslated       </td><td><%=request.getPathTranslated()%></td></tr>
            <tr><td>request.getAuthType             </td><td><%=request.getAuthType()%></td></tr>
            <tr><td>request.getRemoteUser           </td><td><%=request.getRemoteUser()%></td></tr>
            <tr><td>request.getContentType          </td><td><%=request.getContentType()%></td></tr>
            <tr><td>request.getContentLength        </td><td><%=request.getContentLength()%></td></tr>
            <tr><td>request.getHeader("Accept")     </td><td><%=request.getHeader("Accept")%>
            <tr><td>request.getHeader("User-Agent") </td><td><%=request.getHeader("User-Agent")%>
            <tr><td>request.getHeader("Referer")    </td><td><%=request.getHeader("Referer")%>
            <tr><td>session.getId                   </td><td><%=session.getId()%></td></tr>
            <tr><td>session.isNew                   </td><td><%=session.isNew()%></td></tr>
            <tr><td>session.getCreationTime         </td><td><%=session.getCreationTime()%></td></tr>
            <tr><td>session.getLastAccessedTime     </td><td><%=session.getLastAccessedTime()%></td></tr>
            <tr><td>session.getMaxInactiveInterval  </td><td><%=session.getMaxInactiveInterval()%></td></tr>
            <tr><td>session.getAttributeNames       </td><td><%=session.getAttributeNames()%></td></tr>
            <tr><td>request.getCookies              </td><td><%=request.getCookies()%></td></tr>
        </table>

        <table border="1">
            <tr><th colspan="2">Cookies</th></tr>
            <tr><td>cookies.length                  </td><td><%=cookies.length%></td></tr>
            <tr><td>Cookies</td><td>
            <%
            for (int i=0; i<cookies.length; i++) {
              out.println(cookies[i].getName()+":\t"+
                cookies[i].getValue()+"<BR>");
            }
            %></td></tr>
        </table>
    </body>
</html>