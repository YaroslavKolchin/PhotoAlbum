<%-- 
    Document   : myAlbums
    Created on : Aug 6, 2018, 12:38:22 AM
    Author     : yaroslav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="/MyAlbums" flush="true" />
          <%
           // String album = response.encodeURL(request.getContextPath()+"/MyAlbums");
           %>    
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
