<%-- 
    Document   : AlbumAdd
    Created on : Aug 1, 2018, 2:05:29 PM
    Author     : yaroslav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../MasterPage/Header.jsp" />
        <title>Add new album</title>
        
        <style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box}

input[type=text], input[type=password] {
    width: 100%;
    padding: 15px;
    margin: 5px 0 22px 0;
    display: inline-block;
    border: none;
    background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
    background-color: #ddd;
    outline: none;
}

hr {
    border: 1px solid #f1f1f1;
    margin-bottom: 25px;
}


button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
    opacity: 0.9;
}

button:hover {
    opacity:1;
}


.cancelbtn {
    padding: 14px 20px;
    background-color: #f44336;
}


.cancelbtn, .signupbtn {
  float: left;
  width: 50%;
}


.container {
    padding: 16px;
}


.clearfix::after {
    content: "";
    clear: both;
    display: table;
}


@media screen and (max-width: 300px) {
    .cancelbtn, .signupbtn {
       width: 100%;
    }
}
#myButton{
font-size: 28px;
margin: 0 0 12px;
padding: 6px;
}
#createId{
font-size: 28px;
margin: 0 0 12px;
padding: 6px;
}
</style>
<div id="content">
    <div id="wrapper1">
        <div class="about">
            <form onsubmit="return valSubmit()" action="../AlbumAdd" style="border:1px solid #ccc" method="post">
                <h1>Add album</h1>
                <br>
                <label style="float:left" for="album"><b></b></label>
                <input type="text" maxlength="15" placeholder="Enter album name" name="album_name" id="nameId" required>

                <label for="description"><b></b></label>
                <input type="text" placeholder="Enter Description " name="album_description" id="desId" required>

                <div class="clearfix">
                  <button type="button" class="cancelbtn" id="myButton" >Cancel</button>
                  <button type="submit" class="signupbtn" id="createId">Create</button>
                </div>
                <span id="errorId" style="color:red"></span>
            </form>
        <script type="text/javascript">
    document.getElementById("myButton").onclick = function () {
        location.href = "/web/jsp/HomePage.jsp";
    };
    function valSubmit(){      
        if((document.getElementById("nameId").value.length<1 )|| 
             (document.getElementById("nameId").value.length>15 ))
     {
         document.getElementById("errorId").textContent="The length of the album name must be between 1 and 15 characters";
          console.log("name"+document.getElementById("nameId").value);  
            return false;
     } 
           
        if((document.getElementById("desId").value.length<2 )|| 
             (document.getElementById("desId").value.length>200 ))
     {
        document.getElementById("errorId").textContent="The length of the album description must be between 2 and 200 characters";    
         console.log("des"+document.getElementById("desId").value);
            return false;
     }
        return true;
    };
        </script>
       </div>
    </div>
</div>        
<jsp:include page="../MasterPage/Footer.jsp" />
