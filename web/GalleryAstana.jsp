<%-- 
    Document   : GalleryAstana
    Created on : Jun 19, 2018, 5:44:38 PM
    Author     : yaroslav
--%>

<jsp:include page="MasterPage/Header.jsp" />
<div id="content">																																																																																																									<div class="inner_copy"><a href="http://www.bestfreetemplates.info/flash.php">free flash templates</a><a href="http://www.beautifullife.info/industrial-design/st-valentines-day-gift-ideas/">st. valentine's day ideas</a></div>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="slider.css">
<style>
.mySlides {display:none}
.demo {cursor:pointer}
</style>
    <div id="wrapper2">
        <div class="background">
            <div class="black">
                    
                <div id="gallery">
                    <div class="w3-content" style="max-width:800px">
                            <img class="mySlides" src="images/pic1_1.jpg"  style="width:100%">
                            <img class="mySlides" src="images/pic1_2.jpg"  style="width:100%">
                            <img class="mySlides" src="images/pic1_3.jpg"  style="width:100%">
                            <img class="mySlides" src="images/pic1_4.jpg"  style="width:100%">

                <div class="w3-row-padding w3-section">
                    <div class="w3-col s3">
                         <img class="demo w3-opacity w3-hover-opacity-off" src="images/pic1_1.jpg" style="width:100%" height="40" onclick="currentDiv(1)">
                    </div>
                    <div class="w3-col s3">
                        <img class="demo w3-opacity w3-hover-opacity-off" src="images/pic1_2.jpg" style="width:100%" height="40" onclick="currentDiv(2)">
                    </div>
                    <div class="w3-col s3">
                         <img class="demo w3-opacity w3-hover-opacity-off" src="images/pic1_3.jpg" style="width:100%" height="40" onclick="currentDiv(3)">
                    </div>
                    <div class="w3-col s3">
                         <img class="demo w3-opacity w3-hover-opacity-off" src="images/pic1_4.jpg" style="width:100%" height="40" onclick="currentDiv(4)">
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
<jsp:include page="MasterPage/Footer.jsp" />
