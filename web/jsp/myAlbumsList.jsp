<%-- 
    Document   : myAlbumsList
    Created on : Dec 2, 2018, 8:22:09 PM
    Author     : yaroslav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../MasterPage/Header.jsp" />
<div id="content">																																																																																																									<div class="inner_copy"><a href="http://www.bestfreetemplates.info/flash.php">free flash templates</a><a href="http://www.beautifullife.info/industrial-design/st-valentines-day-gift-ideas/">st. valentine's day ideas</a></div>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="css/stylesheet" href="../css/slider.css">
<%
    String getAlbumServlet = response.encodeURL(request.getContextPath()+"/AlbumDataServlet");
    System.out.println("servlet text: "+getAlbumServlet);
%>
<script type="text/javascript">
    var getAlbumServlet = '<%=getAlbumServlet%>';
</script>
<script src="../js/jquery.js"></script>
<script src="../js/PhotoAlbum.js"></script>
<style>    
    .mySlides {display:none}
    .demo {cursor:pointer}
    .gallery{display:none}
    .container{color: white;}
    /*.background{display:none}*/
    .wrapper2{display:none}
</style>
<div class="container">
    <c:forEach items="${albums}" var="Map">
       <br>
       <a class="linkClass" id="${Map.key}" onclick="openAlbum(this.id)" href="#">
           <c:out value="${Map.value}"></c:out>
       </a>                   
    </c:forEach>
</div> 
    <div id="wrapper2">
        <div class="background">
            <div class="black">                    
                <div id="gallery">
                    <div class="w3-content" style="max-width:800px">
                            <img class="mySlides" src="../images/pic1_1.jpg"  style="width:100%">
                            <img class="mySlides" src="../images/pic1_2.jpg"  style="width:100%">
                            <img class="mySlides" src="../images/pic1_3.jpg"  style="width:100%">
                            <img class="mySlides" src="../images/pic1_4.jpg"  style="width:100%">
                            <img class="mySlides" src="../images/pic1_5.jpg"  style="width:100%">
                            <img class="mySlides" src="../images/pic1_6.jpg"  style="width:100%">
                            <img class="mySlides" src="../images/pic1_7.jpg"  style="width:100%">
                            <img class="mySlides" src="../images/pic1_8.jpg"  style="width:100%">
                            <img class="mySlides" src="../images/pic1_9.jpg"  style="width:100%">
                            <img class="mySlides" src="../images/pic1_10.jpg" style="width:100%">
                <div class="w3-row-padding w3-section">
                    <div class="w3-col s1">
                         <img class="demo w3-opacity w3-hover-opacity-off" src="../images/pic1_1.jpg" style="width:100%" height="40" onclick="currentDiv(1)">
                    </div>
                    <div class="w3-col s1">
                        <img class="demo w3-opacity w3-hover-opacity-off" src="../images/pic1_2.jpg" style="width:100%" height="40" onclick="currentDiv(2)">
                    </div>
                    <div class="w3-col s1">
                         <img class="demo w3-opacity w3-hover-opacity-off" src="../images/pic1_3.jpg" style="width:100%" height="40" onclick="currentDiv(3)">
                    </div>
                    <div class="w3-col s1">
                         <img class="demo w3-opacity w3-hover-opacity-off" src="../images/pic1_4.jpg" style="width:100%" height="40" onclick="currentDiv(4)">
                    </div>
                    <div class="w3-col s1">
                         <img class="demo w3-opacity w3-hover-opacity-off" src="../images/pic1_5.jpg" style="width:100%" height="40" onclick="currentDiv(5)">
                    </div>
                    <div class="w3-col s1">
                         <img class="demo w3-opacity w3-hover-opacity-off" src="../images/pic1_7.jpg" style="width:100%" height="40" onclick="currentDiv(7)">
                    </div>
                    <div class="w3-col s1">
                         <img class="demo w3-opacity w3-hover-opacity-off" src="../images/pic1_8.jpg" style="width:100%" height="40" onclick="currentDiv(8)">
                    </div>
                    <div class="w3-col s1">
                         <img class="demo w3-opacity w3-hover-opacity-off" src="../images/pic1_9.jpg" style="width:100%" height="40" onclick="currentDiv(9)">
                    </div>
                    <div class="w3-col s1">
                         <img class="demo w3-opacity w3-hover-opacity-off" src="../images/pic1_10.jpg" style="width:100%" height="40" onclick="currentDiv(10)">
                    </div>
                </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="pages">               
        </div>
    </div>
</div>
<script>
var slideIndex = 1;
showDivs(slideIndex);

function plusDivs(n) {
  showDivs(slideIndex += n);
}

function currentDiv(n) {
  showDivs(slideIndex = n);
}

function showDivs(n) {
  var i;
  var x = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("demo");
  if (n > x.length) {slideIndex = 1}
  if (n < 1) {slideIndex = x.length}
  for (i = 0; i < x.length; i++) {
     x[i].style.display = "none";
  }
  for (i = 0; i < dots.length; i++) {
     dots[i].className = dots[i].className.replace(" w3-opacity-off", "");
  }
  x[slideIndex-1].style.display = "block";
  dots[slideIndex-1].className += " w3-opacity-off";
}
</script>
<jsp:include page="../MasterPage/Footer.jsp" />
       
