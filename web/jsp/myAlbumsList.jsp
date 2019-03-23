<%-- 
    Document   : myAlbumsList
    Created on : Dec 2, 2018, 8:22:09 PM
    Author     : yaroslav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../MasterPage/Header.jsp" />
<div id="content" >																																																																																						<div class="inner_copy"><a href="http://www.bestfreetemplates.info/flash.php">free flash templates</a><a href="http://www.beautifullife.info/industrial-design/st-valentines-day-gift-ideas/">st. valentine's day ideas</a></div>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--
<link rel="stylesheet" type="text/css" href="../css/slider.css">
-->
<%    
    String image    = response.encodeURL(request.getContextPath()+"/PhotoServlet");
    String images[] = new String[10];
    for(int a=0; a<10; a++)
    {
        images[a] = response.encodeURL(request.getContextPath()+"/PhotoServlet"+(a+1)+"?albumId=");
    }
%>
<script type="text/javascript">
    //var getAlbumServlet = '<%//=getAlbumServlet%>';
    var image   = '<%=image%>';
    var image_ = [];
    <%
        for(int a=0; a<10; a++)
        {            
            %>
            image_[<%=a%>] = '<%=images[a]%>';
            <%
        }
    %>
    var owner = '${album_owner_id}';
</script>
<script src="../js/jquery.js"></script>

<style>    
    .mySlides {display:none}
    .demo {cursor:pointer}
    .gallery{display:none}
    .container{color: white;}
    .background{display:none}
    .wrapper2{display:none}
</style>
<div class="container">
    <table id="albumsTable">
        <c:forEach items="${albums}" var="Map">                
           <tr>
               <td>
                    <a class="linkClass" id="${Map.key}" onclick="openAlbum(this.id)" href="#">               
                    <c:out value="${Map.value}"></c:out>
                    </a> 
               </td> 
               <td>
                   <button type="button" id="deleteAlbumBtn${Map.key}" onclick="deleteAlbum(this.id)">Delete this album</button>                   
               </td>
           </tr>
        </c:forEach>
    </table>    
</div>
<div id="wrapper2">
    <div class="background">
        <div class="w3-content" style="max-width:800px">
            <img id="image1" class="mySlides" src=""  style="width:100%">
            <p id="image1Text" class="mySlidesText">Caption Text</p>
            <img id="image2" class="mySlides" src=""  style="width:100%">
            <p id="image2Text" class="mySlidesText">Caption Text</p>
            <img id="image3" class="mySlides" src=""  style="width:100%">
            <p id="image3Text" class="mySlidesText">Caption Text</p>
            <img id="image4" class="mySlides" src=""  style="width:100%">
            <p id="image4Text" class="mySlidesText">Caption Text</p>
            <img id="image5" class="mySlides" src=""  style="width:100%">
            <p id="image5Text" class="mySlidesText">Caption Text</p>
            <img id="image6" class="mySlides" src=""  style="width:100%">
            <p id="image6Text" class="mySlidesText">Caption Text</p>
            <img id="image7" class="mySlides" src=""  style="width:100%">
            <p id="image7Text" class="mySlidesText">Caption Text</p>
            <img id="image8" class="mySlides" src=""  style="width:100%">
            <p id="image8Text" class="mySlidesText">Caption Text</p>
            <img id="image9" class="mySlides" src=""  style="width:100%">
            <p id="image9Text" class="mySlidesText">Caption Text</p>
            <img id="image10" class="mySlides" src="" style="width:100%">  
            <p id="image10Text" class="mySlidesText">Caption Text</p>
            <br>
            <button type="button" id="deletePhotoBtn">Delete this image</button>
            <br>  
            <br>                   
            <div class="w3-row-padding w3-section">
                <div class="w3-col s1">
                    <img id="image1Thumb" class="demo w3-opacity w3-hover-opacity-off" src="" width="72" height="40" onclick="currentDiv(1)">
                    <img id="image2Thumb" class="demo w3-opacity w3-hover-opacity-off" src="" width="72" height="40" onclick="currentDiv(2)">
                    <img id="image3Thumb" class="demo w3-opacity w3-hover-opacity-off" src="" width="72" height="40" onclick="currentDiv(3)">
                    <img id="image4Thumb" class="demo w3-opacity w3-hover-opacity-off" src="" width="72" height="40" onclick="currentDiv(4)">
                    <img id="image5Thumb" class="demo w3-opacity w3-hover-opacity-off" src="" width="72" height="40" onclick="currentDiv(5)">
                    <img id="image6Thumb" class="demo w3-opacity w3-hover-opacity-off" src="" width="72" height="40" onclick="currentDiv(6)">
                    <img id="image7Thumb" class="demo w3-opacity w3-hover-opacity-off" src="" width="72" height="40" onclick="currentDiv(7)">
                    <img id="image8Thumb" class="demo w3-opacity w3-hover-opacity-off" src="" width="72" height="40" onclick="currentDiv(8)">
                    <img id="image9Thumb" class="demo w3-opacity w3-hover-opacity-off" src="" width="72" height="40" onclick="currentDiv(9)">
                    <img id="image10Thumb" class="demo w3-opacity w3-hover-opacity-off" src="" width="72" height="40" onclick="currentDiv(10)">
                </div>
            </div>                    
        </div>
    </div>
    <div id="pages">
    </div>
</div>
</div>
<script src="../js/PhotoAlbum.js"></script>
<script src="../js/PhotoAlbum2.js"></script>
<jsp:include page="../MasterPage/Footer.jsp" />