/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function deleteAlbum(albumId)
{
    var str = "deleteAlbumBtn$";
    albumId = albumId.substring(str.length-1, albumId.length);
    console.log("delete album with id="+albumId);
    if(confirm("Do you confirm to delete this album (all the photos in the album will also be deleted)?"))
    {
        var xhr = new XMLHttpRequest();
        xhr.open('GET', deleteAlbumVar+'?albumId='+albumId, true);
        xhr.send(null);    
        xhr.onreadystatechange = function()
        {
            if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) 
            {
                var data2 = xhr.responseText;
                if(data2==="true")
                { 
                    location.reload();
                }
                if(data2==="false")
                {                    
                    alert("Sorry, the album can't be deleted");
                };
            };
        };    
    }
    else
    {
        console.log("you canceled to delete the album");
    }
}