<%-- 
    Document   : Header
    Created on : Jun 16, 2018, 4:53:25 AM
    Author     : talgat
--%>
<%
    if(session.getAttribute("session")== null || session.getAttribute("session").equals("") || !session.getAttribute("session").equals("TRUE"))
    {
        System.out.println("SESSION: "+session.getAttribute("session"));
%>
        <jsp:forward page="../error.jsp" />
<%         
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Photo Album</title>
        <link rel="stylesheet" type="text/css" href="style.css" />
    </head>
    <body>
        <div id="header">																																																																																<div class="inner_copy"><a href="http://www.greatdirectories.org/categories/arts-directories/">free art directories list</a><a href="http://www.bestfreetemplates.org/categories/artworks/">artworks templates</a></div>
            <div id="inside_header">
                <a href="index.html"><img src="images/title.jpg" alt="" width="211" height="69" /></a><br />																																																																																																								
                <ul id="menu">
                    <li><a href="HomePage.jsp" class="but1_active"><img src="images/but1.jpg" alt="" width="70" height="47" /></a></li>
                    <li><a href="Gallery.jsp" class="but2"><img src="images/but2.jpg"         alt="" width="70" height="47" /></a></li>
                    <li><a href="PhotoAlbumAdd.jsp" class="but3"><img src="images/but3.jpg"   alt="" width="70" height="47" /></a></li>
                    <li><a href="GalleryAstana.jsp" class="but5"><img src="images/but5.jpg"   alt="" width="70" height="47" /></a></li>
                    <li><a href="logout.jsp" class="but6"><img src="images/but6.jpg"          alt="" width="70" height="47" /></a></li>
                    <li><a href="myAlbums.jsp" class="but7"><img src="images/but7.jpg"        alt="" width="70" height="47" /></a></li>
                </ul>
            </div>
	</div>
        
