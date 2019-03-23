var data = null;
var imageText0 = document.getElementById("image1Text");
var imageText1 = document.getElementById("image2Text");
var imageText2 = document.getElementById("image3Text");
var imageText3 = document.getElementById("image4Text");
var imageText4 = document.getElementById("image5Text");
var imageText5 = document.getElementById("image6Text");
var imageText6 = document.getElementById("image7Text");
var imageText7 = document.getElementById("image8Text");
var imageText8 = document.getElementById("image9Text");
var imageText9 = document.getElementById("image10Text");
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
            imageText0.innerHTML = data[0].photoName+" "+data[0].description;
            
            for(var a=0; a<data.length; a++)
            {
                console.log(image_[a]);
                $("#image"+(a+1)).attr("src", image_[a] + albumId+"&photo_owner_id="+owner);
                $("#image"+(a+1)+"Thumb").attr("src", image_[a] + albumId+"&photo_owner_id="+owner);
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
    if(data!==null)
    {
        /*
        for(var i=0; i<data.length; i++)
        {
            //var imageData = data[i];
            console.log(data[i].photoName+" "+data[i].description);
        }
        */
        imageText0.innerHTML = data[0].photoName+" "+data[0].description;
        imageText1.innerHTML = data[1].photoName+" "+data[1].description;
        imageText2.innerHTML = data[2].photoName+" "+data[2].description;
        imageText3.innerHTML = data[3].photoName+" "+data[3].description;
        imageText4.innerHTML = data[4].photoName+" "+data[4].description;
        imageText5.innerHTML = data[5].photoName+" "+data[5].description;
        imageText6.innerHTML = data[6].photoName+" "+data[6].description;
        imageText7.innerHTML = data[7].photoName+" "+data[7].description;
        imageText8.innerHTML = data[8].photoName+" "+data[8].description;
        imageText9.innerHTML = data[9].photoName+" "+data[9].description;              
    }
    else
    {
        console.log("sorry its null");
    }
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