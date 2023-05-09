<%-- 
    Document   : quest
    Created on : Mar 24, 2023, 8:27:22 AM
    Author     : anlal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <form method="get" action="quest">
            <h1>QUESTION:</h1>
            <h2>${Q.getContent()}</h2>
            <input type="radio" name="ans" value="A" onclick="this.form.submit();"/>${Q.getA()}<br>
            <input type="radio" name="ans" value="B" onclick="this.form.submit();"/>${Q.getB()}<br>
            <input type="radio" name="ans" value="C" onclick="this.form.submit();"/>${Q.getC()}<br>
            <input type="radio" name="ans" value="D" onclick="this.form.submit();"/>${Q.getD()}<br>
            
            <input type="hidden" name="index" value="${Q.getId()}"/>
            
            
        </form>
    </body>
</html>
