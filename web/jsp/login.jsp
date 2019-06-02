<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/main.css">
        <link rel="shortcut icon" href="../images/camera.ico" />
        <title>login page</title>
    </head>
    <body>
        <div align="center">
             <h1>welcome to digital photo album</h1>
        </div>
        <div class="login-page">
        
            <div class="form">
                <form onsubmit="return validationSubmit()" action="../loginProcess" method="post">
                 
                   <input type="text" placeholder="Enter Email " id="loginEmailId" name="email"/><br/><br/>  
                   <input type="password" placeholder="Enter Password " id="loginPswId" name="password"/><br/><br/>  
                   <input type="submit" id="loginBtn" value="login"/>
                    <a href="/web/jsp/Registration.jsp">sign up</a>
                    <span id="errorId" style="color:red"></span>
                </form> 
            </div>
            
             <script type="text/javascript">
    function validationSubmit(){
        console.log("test "+document.getElementById("loginEmailId").value.length);
        if((document.getElementById("loginEmailId").value.length<2 )|| 
             (document.getElementById("loginEmailId").value.length>15 ))
     {
         document.getElementById("errorId").textContent="The length of email must be between 2 and 15 characters";
            console.log("email"+document.getElementById("loginEmailId").value);
            return false;
     } 
           
        if((document.getElementById("loginPswId").value.length<5 )|| 
             (document.getElementById("loginPswId").value.length>20 ))
     {
        document.getElementById("errorId").textContent="The length of passwoord must be between 5 and 20 characters";    
           console.log("pass"+document.getElementById("loginPswId").value);
            return false;
     }
     return true;
    };
   </script>
        </div>
    </body>
</html>