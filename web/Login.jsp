<%-- 
    Document   : Login
    Created on : Feb 10, 2023, 9:18:33 PM
    Author     : anlal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/index_Style.css" rel="stylesheet" type="text/css"/>
        <link href="css/Login_Style.css" rel="stylesheet" type="text/css"/>
        <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
        <style>
            body {
                font-family: 'Montserrat';
                font-size: 22px;
            }
        </style>
    </head>
    <body>
        <div class="containerLogin">
            <h1>Login</h1>
            <form method="post" action="login">
                <div class="txt_field">
                    <input type="text" required name="acc">
                    <span></span>
                    <label>Username</label>
                </div>
                <div class="txt_field">
                    <input type="password" required name="pass">
                    <span></span>
                    <label>Password</label>
                </div>
                <input type="submit" value="Login" name="log">
            </form>
        </div>
    </body>
</html>
