var data = null;
var imageText = [];
function openAlbum(albumId)
{        
    var xhr = new XMLHttpRequest();
    xhr.open('GET', image+'?albumId='+albumId, true);
    xhr.send(null);
    xhr.onreadystatechange = function() 
    {
        if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) 
        {
            data = JSON.parse(xhr.responseText);
            if(data!==null && data.length>0)
            {
                document.getElementById("image1").style.display = "initial";
            }
            else
            {
                document.getElementById("image1Text").innerHTML = "no name, no description";
            }
            for(var a=0; a<data.length; a++)
            {
                document.getElementById("image1").style.display = "initial";
                document.getElementById("image"+(a+1)+"Thumb").style.display = "initial";
                $("#image"+(a+1)).attr("src", image_[a] + albumId+"&photo_owner_id="+owner);
                $("#image"+(a+1)+"Thumb").attr("src", image_[a] + albumId+"&photo_owner_id="+owner);
                var idText = "image".concat(a+1).concat("Text");
                imageText[a] = document.getElementById(idText);
                imageText[a].innerHTML = data[a].photoName+" "+data[a].description;
            }
            for(var a=10-(10-data.length); a<10; a++)
            {
                document.getElementById("image"+(a+1)).style.display = "none";
                document.getElementById("image"+(a+1)+"Thumb").style.display = "none";
                imageText[a].innerHTML = "";
            }
        }
    };
        
    var all = document.getElementsByClassName("background");
    for (var i = 0; i < all.length; i++)
    {
      all[i].style.display = "block";
    }  
}

var slideIndex = 1;
showDivs(slideIndex);

function plusDivs(n)
{
  showDivs(slideIndex += n);
}
function currentDiv(n)
{
    showDivs(slideIndex = n);
    /*
    if(data!==null && data.length>0)
    {
        for(var i=0; i<data.length; i++)
        {
            imageText[i].innerHTML = data[i].photoName+" "+data[i].description;
        }
    }
    else
    {
        imageText[i].innerHTML = "ultimate mortal kombat 3";
    }
    */
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

    //show caption text
    var y = document.getElementsByClassName("mySlidesText");
    var dots = document.getElementsByClassName("demo");
    if (n > y.length) {slideIndex = 1;};
    if (n < 1) {slideIndex = y.length;};
    for (i = 0; i < y.length; i++)
    {
        y[i].style.display = "none";
    }
    y[slideIndex-1].style.display = "block";    
}
$("#deletePhotoBtn").click(function()
{
    console.log("delete photo");
    var x = document.getElementsByClassName("mySlides");
    console.log("id of the selected photo = "+x[slideIndex-1].id);
    //var words1 = $('#textAreaID').val();       
    //$('deleteBtn').val("THERE ARE "+wordsInText+" WORDS");
});