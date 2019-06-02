<%-- 
    Document   : myAlbums
    Created on : Aug 6, 2018, 12:38:22 AM
    Author     : yaroslav
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="shortcut icon" href="../images/camera.ico" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>  
        <jsp:include page="../albumsServlet" />      
    </body>
</html>