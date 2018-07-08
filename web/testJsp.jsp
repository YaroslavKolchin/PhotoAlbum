<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.io.File"%>
<%@page import="java.io.IOException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            String imagePath = response.encodeURL(request.getContextPath()+"/imageServlet");
        %>        
    </head>
    <body>
        <h1>Hello World!</h1>       
        <br>
        <div>
            <img id="Photo" src="<%=imagePath%>" width="500" height ="600" />
        </div>        
    </body>
</html>