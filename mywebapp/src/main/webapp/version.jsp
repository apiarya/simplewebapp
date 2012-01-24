<%@ page language="java" import="java.util.Properties" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<%
Properties prop = new Properties();
prop.load(pageContext.getServletContext().getResourceAsStream("/META-INF/MANIFEST.MF"));
%>
<h2>Manifest: <%=prop.getProperty("Manifest-Version")%></h2><br />
Archiver-Version: <%=prop.getProperty("Archiver-Version")%><br />
Created-By: <%=prop.getProperty("Created-By")%><br />
Build-Jdk: <%=prop.getProperty("Built-By")%><br />
Class-Path: <%=prop.getProperty("Class-Path")%><br />

Build-Date: <%=prop.getProperty("Build-Date")%><br />
Build-Id: <%=prop.getProperty("Build-Id")%><br />

Project Name: <%=prop.getProperty("Name")%><br />
Specification-Title: <%=prop.getProperty("Specification-Title")%><br />
Specification-Version: <%=prop.getProperty("Specification-Version")%><br />
Specification-Vendor: <%=prop.getProperty("Specification-Vendor")%><br />

Implementation-Title: <%=prop.getProperty("Implementation-Title")%><br />
Implementation-Version: <%=prop.getProperty("Implementation-Version")%><br />
Implementation-Vendor: <%=prop.getProperty("Implementation-Vendor")%><br />
Implementation-Vendor-Id: <%=prop.getProperty("Implementation-Vendor-Id")%><br />

Source-Location: <%=prop.getProperty("Source-Location")%><br />
Source-Revision: <%=prop.getProperty("Source-Revision")%><br />


project-url: <%=prop.getProperty("project-url")%><br />
project-home: <%=prop.getProperty("project-home")%><br />

Jenkins-Build-Number: <%=prop.getProperty("Jenkins-Build-Number")%><br />
Jenkins-Project: <%=prop.getProperty("Jenkins-Project")%><br />
Jenkins-Version: <%=prop.getProperty("Jenkins-Version")%><br />


</html>
