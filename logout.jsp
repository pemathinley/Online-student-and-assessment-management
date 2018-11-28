<%-- 
    Document   : logout
    Created on : Nov 21, 2018, 10:02:28 PM
    Author     : user
--%>

<%
session.invalidate();
response.sendRedirect("index.html");


%>
