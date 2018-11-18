<%-- 
    Document   : PhotoAddtest
    Created on : Oct 30, 2018, 8:59:24 PM
    Author     : yaroslav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form action="PhotoUpload" style="border:1px solid #ccc" method="post" enctype="multipart/form-data">
       <div class="container">
    <h1>Add photo</h1>
    <p>Please fill in this form to add a photo.</p>
    <hr>
    <label for="Name"><b>Name</b></label>
    <input type="text" placeholder="Enter photo name" name="photo_name" required>

    <label for="Description"><b>Description</b></label>
    <input type="text" placeholder="Enter Description " name="photo_description" required>
 
    <select name="albums" class="dropdown" style="float:right;">
         <option value="volvo">choose album</option> 
          <c:forEach items="${albums}" var="Map">      
        <option key="${Map.key}"><c:out value="${Map.value}"></c:out> </option>       
        </c:forEach>
    </select>
       
   <p><input type="file" name="f" multiple="false">
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
