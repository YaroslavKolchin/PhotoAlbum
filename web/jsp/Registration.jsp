<%-- 
    Document   : Registration
    Created on : Jul 21, 2018, 4:39:15 PM
    Author     : yaroslav
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%//@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="shortcut icon" href="../images/camera.ico" />
        <link rel="stylesheet" type="text/css" href="../css/pageStructure.css" />
        <title>Registration Page</title>
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
#submitId{
font-size: 28px;
margin: 0 0 12px;
padding: 6px;
}
</style>
    </head>
    <body>
        <div align="center" style="color:white">
            <h1>welcome to digital photo album</h1>
        </div>
        <div id="content">
            <div id="wrapper1">
                <div class="about">
                    <form onsubmit="return validationSubmit()" style="padding: 0px 10px 0px 10px" action="../registrationProcess" method="post">
                        <h1>Sign Up</h1>
                        <br>
                        <label style="float:left" for="email"><b></b></label>
                        <input type="text" maxlength="15" placeholder="Enter Email" name="email" id="emailId" required>

                        <label for="password"><b></b></label>
                        <input type="password" maxlength="20" placeholder="Enter Password" name="password" id="passwordId" required>

                        <label for="psw-repeat"><b></b></label>
                        <input type="password" maxlength="20" placeholder="Repeat Password" name="psw-repeat" id="reppasswordId" required>

                        <div class="clearfix">
                            <button type="button" class="cancelbtn" id="myButton" >Cancel</button>
                            <button type="submit" class="signupbtn" id="submitId" >Sign Up</button>
                        </div>
                        <span id="errorId" style="color:red"></span>
                    </form>
        <script type="text/javascript">
    document.getElementById("myButton").onclick = function () {
        location.href = "/web/jsp/login.jsp";
    };
    function validationSubmit(){
        console.log("test "+document.getElementById("emailId").value.length);
        if((document.getElementById("emailId").value.length<1 )|| 
             (document.getElementById("emailId").value.length>15 ))
     {
         document.getElementById("errorId").textContent="The length of email must be between 1 and 15 characters";
            console.log("email"+document.getElementById("emailId").value);
            return false;
     } 
           
        if((document.getElementById("passwordId").value.length<5 )|| 
             (document.getElementById("passwordId").value.length>20 ))
     {
        document.getElementById("errorId").textContent="The length of passwoord must be between 5 and 20 characters";    
           console.log("pass"+document.getElementById("passwordId").value);
            return false;
     }
        if((document.getElementById("reppasswordId").value.length<5 )|| 
             (document.getElementById("reppasswordId").value.length>20 ))
     {
        document.getElementById("errorId").textContent="The length of passwoord must be between 5 and 20 characters";    
           console.log("reppass"+document.getElementById("reppasswordId").value);
            return false;
     }
        if(!(document.getElementById("passwordId").value===document.getElementById("reppasswordId").value))
     {
         document.getElementById("errorId").textContent="repeat password correctly";
         console.log("pass"+document.getElementById("passwordId").value);    
         console.log("reppass"+document.getElementById("reppasswordId").value);
            return false;
     }
     
     return true;
    };
   </script>
       </div>
    </div>
</div>
<jsp:include page="../MasterPage/Footer.jsp" />
</body>
</html>
