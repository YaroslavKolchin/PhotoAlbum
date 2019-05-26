<%--
    Document   : Header
    Created on : Jun 16, 2018, 4:53:25 AM
    Author     : talgat
--%>
<%
    if(session.getAttribute("session")== null || session.getAttribute("session").equals("") || !session.getAttribute("session").equals("TRUE"))
    {
        System.out.println("SESSION: "+session.getAttribute("session"));
        //response.sendRedirect("../jsp/error.jsp");
%>
        <jsp:forward page="../jsp/error.jsp" />
<%         
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%//@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Photo Album</title>
        <link rel="shortcut icon" href="../images/album.ico" />
        <link rel="stylesheet" type="text/css" href="../css/menuCss.css" />
        <link rel="stylesheet" type="text/css" href="../css/pageStructure.css" />
        <!--
        <link rel="stylesheet" type="text/css" href="../css/style.css" />
        -->
    </head>
    <body>
        <div id="header">																																																																																
            <div id="inside_header">
                <!--<a href="index.html"><img src="../images/title.jpg" alt="" width="211" height="69" /></a><br /> -->
                <ul>
                    <li><a href="PhotoAlbumAdd.jsp">New Album</a></li>
                    <li><a href="PhotoAdd.jsp">New Photo</a></li>
                    <li><a href="myAlbums.jsp">My albums</a></li>
                    <li><a href="logout.jsp">Logout</a></li>
                </ul>
            </div>
	</div>