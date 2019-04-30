var data = null;
var album = 0;
var imageText = [];
var imageId = [];
function openAlbum(albumId)
{        
    album = albumId;
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
                document.getElementById("image1Text").style.display="block";
            }
            else
            {
                document.getElementById("image1Text").innerHTML = "no name, no description";
            }
            for(var a=0; a<data.length; a++)
            {
                document.getElementById("image"+(a+1)+"Thumb").style.display = "initial";
                $("#image"+(a+1)).attr("src", image_[a] + albumId+"&photo_owner_id="+owner);
                $("#image"+(a+1)+"Thumb").attr("src", image_[a] + albumId+"&photo_owner_id="+owner);
                if(a>=1)
                {
                    document.getElementById("image"+(a+1)).style.display = "none";
                    document.getElementById("image"+(a+1)+"Text").style.display="none";
                }
                var idText = "image".concat(a+1).concat("Text");
                imageText[a] = document.getElementById(idText);
                imageText[a].innerHTML = data[a].photoName+" "+data[a].description;
                var idImage = "image".concat(a+1).concat("Id");
                imageId[a] = document.getElementById(idImage);
                imageId[a].innerHTML = data[a].photoId;
                if(document.getElementById("image"+(a+1)).style.display === "block")
                {
                    document.getElementById("image"+(a+1)).style.display = "none";                    
                    document.getElementById("image"+(a+1)+"Text").style.display="none";
                }
            }
            for(var a=10-(10-data.length); a<10; a++)
            {
                document.getElementById("image"+(a+1)).style.display = "none";
                document.getElementById("image"+(a+1)+"Thumb").style.display = "none";
                document.getElementById("image"+(a+1)+"Text").style.display="none";
                document.getElementById("image"+(a+1)+"Id").innerHTML="";
            }            
            if(data===null || data.length===0)
            {
                document.getElementById("deletePhotoBtn").style.display = "none";
            }
            else
            {
                document.getElementById("deletePhotoBtn").style.display = "initial";
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
}
function showDivs(n)
{
    var i;
    var x = document.getElementsByClassName("mySlides");
    var dots = document.getElementsByClassName("demo");
    if (n > x.length) {slideIndex = 1;}
    if (n < 1) {slideIndex = x.length;}
    for (i = 0; i < x.length; i++)
    {
       x[i].style.display = "none";
    }
    x[slideIndex-1].style.display = "block"; 
    
    for (i = 0; i < dots.length; i++)
    {
       dots[i].className = dots[i].className.replace(" w3-opacity-off", "");
    }           
    dots[slideIndex-1].className += " w3-opacity-off";
    
    //show caption text
    var y = document.getElementsByClassName("mySlidesText");
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
    var image = document.getElementsByClassName("mySlides");
    var n = image[slideIndex-1].id.substring(image[slideIndex-1].id.length-1, image[slideIndex-1].id.length);    
    var imageIdName = "image".concat(n).concat("Id");
    var imageId = document.getElementById(imageIdName);
    //console.log("id="+image[slideIndex-1].id+"; n="+n+"; image text ="+imageText.textContent+"; image id="+imageId.textContent);
    //var words1 = $('#textAreaID').val();
    //$('deleteBtn').val("THERE ARE "+wordsInText+" WORDS");
    if(confirm("Do you confirm to delete this photo ?"))
    {        
        var xhr = new XMLHttpRequest();
        xhr.open('GET', deletePhoto+'?imageId='+imageId.textContent, true);
        xhr.send(null);
        xhr.onreadystatechange = function()
        {
            if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) 
            {
                var data2 = xhr.responseText;
                if(data2==="true")
                {                    
                    openAlbum(album);
                };                
            };
        };       
    }
    else
    {
        console.log("you canceled to delete the photo");
    }
});