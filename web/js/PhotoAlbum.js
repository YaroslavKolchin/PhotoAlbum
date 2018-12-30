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
    console.log("albumId: "+albumId);
    console.log("getAlbumServlet "+getAlbumServlet);
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
            if (jQuery.isEmptyObject(data))
            {
                console.log("test return data"+data.toString());
            }
        }});
}
//console.log("hello world");
function clickOnAlbumName(albumId)
{
    console.log("albumId 2: "+albumId);
}