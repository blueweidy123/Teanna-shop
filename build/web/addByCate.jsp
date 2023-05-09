<%-- 
    Document   : addByCate
    Created on : Mar 22, 2023, 11:08:53 AM
    Author     : anlal
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .page{
                display: grid;
                border: 2px solid green;
                grid-template-columns: repeat(3, 1fr);
                padding: 10px;
                column-gap: 50px;
                row-gap: 50px;
                margin: 2rem 1rem 0 1rem;

            }
            .item{
                border: 1px solid red;
                padding: 20px;
                font-size: 30px;
                text-align: center;
                /*height: 150px;*/
            }
            .pageNav{
                /*border: 1px solid blue;*/
                display: flex;
                position: fixed;
                bottom: 2rem;
                width: 100vw;
                text-align: center;
                margin: 2rem 0 0 0;
                justify-content: center;
            }
            .pageNum a{
                font-size: 20px;
                padding: 10px 20px 10px 20px;
                /*border: 2px solid black;*/
                margin: 8px;
                border-radius: 8px;
                text-decoration: none;
            }
            .descImg{
                height: 200px;
                background: wheat;
            }
            .descImg img{
                /*object-fit: cover;*/
                width: 100%;
                max-height: 100%;
            }
            .picker{
                border: 1px solid #007bff;
                margin-top: 100px;
                margin-left: 50%;
                transform: translateX(-50%);
                margin-right: auto;
                text-align: center;
                display: inline-flex;
                justify-content: center;
            }
        </style>
    </head>
    <body>
        <div class="page">
            <c:forEach var="i" items="${items}">
                <div class="item">
                    <div>
                        <div class="descImg">
                            <img src='data:image/jpeg;base64,${i.getImgLink()}' alt='My Image' alt=""/>
                        </div>
                        <div>
                            ID:${i.getItemID()} | ${i.getItemName()}
                        </div>
                        <div>
                            Price: ${i.getPrice()}
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
