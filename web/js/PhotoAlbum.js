/*  
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() 
    {
        if (xhr.readyState == 4) 
        {
            var data = xhr.responseText;
            alert(data);
        }
    }
    xhr.open('GET', 'getAlbumServlet', true);
    xhr.send(null);

    $.get('getAlbumServlet', function(data) 
    {
        alert(data);
    });
 */
function openAlbum(albumId)
{        
    $("#image1").attr("src", image_1 + albumId+"&photo_owner_id="+owner);                
    $("#image2").attr("src", image_2 + albumId+"&photo_owner_id="+owner);
    $("#image3").attr("src", image_3 + albumId+"&photo_owner_id="+owner);
    $("#image4").attr("src", image_4 + albumId+"&photo_owner_id="+owner);
    $("#image5").attr("src", image_5 + albumId+"&photo_owner_id="+owner);
    $("#image6").attr("src", image_6 + albumId+"&photo_owner_id="+owner);
    $("#image7").attr("src", image_7 + albumId+"&photo_owner_id="+owner);
    $("#image8").attr("src", image_8 + albumId+"&photo_owner_id="+owner);
    $("#image9").attr("src", image_9 + albumId+"&photo_owner_id="+owner);
    $("#image10").attr("src", image_10 + albumId+"&photo_owner_id="+owner);

    $("#image1Thumb").attr("src", image_1 + albumId+"&photo_owner_id="+owner);
    $("#image2Thumb").attr("src", image_2 + albumId+"&photo_owner_id="+owner);
    $("#image3Thumb").attr("src", image_3 + albumId+"&photo_owner_id="+owner);
    $("#image4Thumb").attr("src", image_4 + albumId+"&photo_owner_id="+owner);
    $("#image5Thumb").attr("src", image_5 + albumId+"&photo_owner_id="+owner);
    $("#image6Thumb").attr("src", image_6 + albumId+"&photo_owner_id="+owner);
    $("#image7Thumb").attr("src", image_7 + albumId+"&photo_owner_id="+owner);
    $("#image8Thumb").attr("src", image_8 + albumId+"&photo_owner_id="+owner);
    $("#image9Thumb").attr("src", image_9 + albumId+"&photo_owner_id="+owner);
    $("#image10Thumb").attr("src", image_10 + albumId+"&photo_owner_id="+owner);

    //console.log("image_1: "+image_1+albumId+"&photo_owner_id="+owner);
    var all = document.getElementsByClassName("background");
    for (var i = 0; i < all.length; i++)
    {
      all[i].style.display = "block";
    }
    //document.getElementById("wrapper2").style.display = "none";    
}
//console.log("albumId: "+albumId);    
//console.log("owner: "+owner);   
//console.log("getAlbumServlet "+getAlbumServlet);
/*
$.ajax({
    url : getAlbumServlet,
    dataType : 'json',
    method:'GET',
    data:
    {
        albumId:albumId
    },
    error : function() {alert("Error Occured");},
    success : function(data) 
    {
        if (!jQuery.isEmptyObject(data))
        {
            console.log("test return data"+data.toString());
        }
        //call a new servlet get photo image            
    }});
*/   
    var slideIndex = 1;
    showDivs(slideIndex);
       
    function plusDivs(n)
    {
      showDivs(slideIndex += n);
    }
    function currentDiv(n)
    {
      showDivs(slideIndex = n);
    }
    function showDivs(n)
    {
        var i;
        var x = document.getElementsByClassName("mySlides");
        var dots = document.getElementsByClassName("demo");
        if (n > x.length) {slideIndex = 1}
        if (n < 1) {slideIndex = x.length}
        for (i = 0; i < x.length; i++)
        {
           x[i].style.display = "none";
        }
        for (i = 0; i < dots.length; i++)
        {
           dots[i].className = dots[i].className.replace(" w3-opacity-off", "");
        }
        x[slideIndex-1].style.display = "block";
        dots[slideIndex-1].className += " w3-opacity-off";
    }
    $("#deletePhotoBtn").click(function()
    {
        console.log("delete photo");
        //var words1 = $('#textAreaID').val();       
        //$('deleteBtn').val("THERE ARE "+wordsInText+" WORDS");
    });
    