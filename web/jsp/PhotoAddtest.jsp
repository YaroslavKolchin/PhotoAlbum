<%-- 
    Document   : PhotoAddtest
    Created on : Oct 30, 2018, 8:59:24 PM
    Author     : yaroslav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../MasterPage/Header.jsp" />
<div id="content">
    <div id="wrapper1">
        <div class="about">
        <form onsubmit="return valSubmit()" action="../PhotoUpload" style="border:1px solid #ccc" method="post" enctype="multipart/form-data">
                <h1>Add photo</h1>
                <br>
                <label style="float:left" for="Name"><b>Name</b></label>                
                <input type="text" placeholder="Enter photo name" name="photo_name" id="photoId" required>
                <label for="Description"><b>Description</b></label>
                <input type="text" placeholder="Enter Description " name="photo_description" id="photodesId" required>               
                <select name="albums" id="chooseId" class="dropdown" style="float:right;">
                    <option value="default">choose album</option>
                    <c:forEach items="${albums}" var="Map">
                        <option value="${Map.key}">
                            <c:out value="${Map.value}"></c:out>
                        </option>
                    </c:forEach>
                </select>
                <p><input type="file" name="f" id="fileId" multiple="false">
                <div class="clearfix">
                  <button type="button" class="cancelbtn" id="myButton" >Cancel</button>
                  <button type="submit" class="signupbtn">Upload</button>
                </div>
                <span id="errorId" style="color:red"></span>
        </form>
        <script type="text/javascript">
        document.getElementById("myButton").onclick = function ()
        {
            location.href = "/web/jsp/HomePage.jsp";
        };
        function valSubmit()
        {      
            if((document.getElementById("photoId").value.length<1 )|| 
               (document.getElementById("photoId").value.length>15 ))
            {
                document.getElementById("errorId").textContent="The length of the photo name must be between 1 and 15 characters";
                console.log("file"+document.getElementById("fileId").value);
                return false;
            }          
            if((document.getElementById("photodesId").value.length<2 ) || 
                 (document.getElementById("photodesId").value.length>200 ))
            {
                document.getElementById("errorId").textContent="The length of the photo description must be between 2 and 200 characters";    
                return false;
            }
            if(document.getElementById("fileId").value.length<0)
            {
                document.getElementById("fileId").textContent="image file\n\must be selected";    
                return false; 
            }
            if(document.getElementById("chooseId").value==="default")
            {
                document.getElementById("errorId").textContent="Album must be selected";    
                return false;
            }
            return true;                        
        };
        </script>
    </div>
    </div>
</div>
<jsp:include page="../MasterPage/Footer.jsp" />