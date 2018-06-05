<%-- 
    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%System.out.println("hello");%>
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
                <form class="register-form">
                    <input type="text" placeholder="name"/>
                    <input type="password" placeholder="password"/>
                    <input type="text" placeholder="email address"/>
                    <button>create</button>
                    <p class="message">Already registered? <a href="#">Sign In</a></p>
                </form>
                <form class="login-form">
                    <input type="text" placeholder="username"/>
                    <input type="password" placeholder="password"/>
                    <button>login</button>                    
                </form>
            </div>
        </div>
    </body>
</html>
