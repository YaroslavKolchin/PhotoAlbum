<%-- 
    Document   : Registration
    Created on : Jul 21, 2018, 4:39:15 PM
    Author     : yaroslav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../MasterPage/HeaderRegistration.jsp" />
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
</style>
        <form onsubmit="return validationSubmit()" action="../registrationProcess" style="border:1px solid #ccc" method="post">
  <div class="container">
    <h1>Sign Up</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>
    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" id="emailId" required>

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" id="passwordId" required>

    <label for="psw-repeat"><b>Repeat Password</b></label>
    <input type="password" placeholder="Repeat Password" name="psw-repeat" id="reppasswordId" required>
    


    <div class="clearfix">
     <button type="button" class="cancelbtn" id="myButton" >Cancel</button>
      <button type="submit" class="signupbtn" id="submitId" >Sign Up</button>
    </div>
    <span id="errorId" style="color:red"></span>
  </div>
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
<jsp:include page="../MasterPage/Footer.jsp" />
