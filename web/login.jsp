<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="main.css">
        <title>login page</title>
    </head>
    <body>
        <div align="center">
             <h1>welcome to digital photo album</h1>
        </div>
        <div class="login-page">
            <div class="form">
                <form action="loginProcess" method="post">  
                    Email:<input type="text" name="email"/><br/><br/>  
                    Password:<input type="password" name="password"/><br/><br/>  
                    <input type="submit" value="login"/>
                </form> 
            </div>
        </div>
    </body>
</html>