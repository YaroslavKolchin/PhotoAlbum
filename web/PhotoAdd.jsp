<%-- 
    Document   : PhotoAdd
    Created on : Sep 16, 2018, 12:37:24 PM
    Author     : talgat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="PhotoAdd.css" />
        <style>
        </style>
    </head>
    <body>
        <jsp:include page="/latest_products.jsp" />
        <c:out value="${message }"></c:out>
         <form action="PhotoAdd" style="border:1px solid #ccc" method="post">
       <div class="container">
    <h1>Add photo</h1>
    <p>Please fill in this form to add a photo.</p>
    <hr>
    <label for="email"><b>Name</b></label>
    <input type="text" placeholder="Enter photo name" name="photo_name" required>

    <label for="password"><b>Description</b></label>
    <input type="text" placeholder="Enter Description " name="photo_description" required>
    <form enctype="multipart/form-data" method="post">
    <select class="dropdown" style="float:right;">
        <option value="volvo">choose album</option>
    </select>
   <p><input type="file" name="f">
   <input type="submit" value="upload"></p>  
    <input type="hidden" album_owner_id="album_%%">
    
    <div class="clearfix">
      <button type="button" class="cancelbtn">Cancel</button>
      <button type="submit" class="signupbtn">Add</button>
    </div>
  </div>
        </form>
    </body>
</html>
