<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/main.css">
        <title>login page</title>
    </head>
    <body>
        <div align="center">
             <h1>welcome to digital photo album</h1>
        </div>
        <div class="login-page">
            <div class="form">
                <form action="../loginProcess" method="post">  
                   <input type="text" placeholder="Enter Email " name="email"/><br/><br/>  
                   <input type="password" placeholder="Enter Password " name="password"/><br/><br/>  
                   <input type="submit" id="loginBtn" value="login"/>
                    
                </form> 
                <a href="/web/jsp/Registration.jsp">sign up</a>
            </div>
        </div>
    </body>
</html>