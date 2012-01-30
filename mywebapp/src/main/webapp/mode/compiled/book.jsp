<html>
<body>
<h2>This is COMPILED mode</h2>
Welcome page: <a href="<%=request.getRequestURL()%>"><%=request.getRequestURL()%></a>
<BR>
    <table border="1">
        <tr><td>request.getMethod               </td><td><%=request.getMethod()%></td></tr>
        <tr><td>request.getScheme               </td><td><%=request.getScheme()%></td></tr>
        <tr><td>request.ServerName              </td><td><%=request.getServerName()%></td></tr>
        <tr><td>request.getServerPort           </td><td><%=request.getServerPort()%></td></tr>
        <tr><td>request.getContextPath()        </td><td><%=request.getContextPath( )%>
        <tr><td>request.getServletPath          </td><td><%=request.getServletPath()%></td></tr>
        <tr><td>request.getRequestURL           </td><td><%=request.getRequestURL()%></td></tr>
        <tr><td>request.getRequestURI           </td><td><%=request.getRequestURI()%></td></tr>
        <tr><td>request.getRealPath("/")        </td><td><%=request.getRealPath("/")%>
    </table>
</body>
</html>
