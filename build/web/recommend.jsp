<%-- 
    Document   : recommend
    Created on : Mar 21, 2023, 3:44:11 PM
    Author     : anlal
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recommend</title>
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap');
            *{
                box-sizing: border-box;
                font-family: 'Poppins', sans-serif;
                border: 1px solid #adadad;
            }
            .navbar{
                z-index: 2;
                width: 95%;
                padding: 1px 0;
                background: #1b1b1b;
                justify-content: space-between;
            }
            .navbar.sticky{
                background: #1b1b1b;
                box-shadow: 0px 3px 5px 0px rgba(0,0,0,0.1);
                transition: all 0.5s ease;
            }
            .navbar .content{
                display: flex;
                align-items: center;
                justify-content: space-between;
                width: 100%;
                transform: translate(10px, 10px);
                margin-top: auto;
                margin-bottom: auto;
            }
            .logo{
                margin-bottom: auto;
                margin-bottom: 20px;
            }
            .navbar .logo a{
                color: #fff;
                font-size: 30px;
                font-weight: 600;
                text-decoration: none;
                margin-right: auto 20px auto 0px;
            }
            .menu-list{
                margin-right: auto 20px auto 0px;
                display: inline-flex;
                padding: 10px;
                margin: auto 0px auto auto;
            }
            .menu-list li{
                list-style: none;
            }
            .menu-list li a{
                color: #fff;
                font-size: 18px;
                font-weight: 500;
                margin-left: 25px;
                margin-right: 20px;
                text-decoration: none;
                transition: all 0.3s ease;
            }
            .menu-list li a:hover{
                color: #007bff;
                border: 1px solid #FFF;
                border-radius: 5px;
                padding: 4px 16px;
                transition: all 0.3s ease;
            }

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
        <nav class="navbar" id="navbar" style="position: fixed;top: 0;width: 100vw;">
            <div class="content">
                <div class="logo"><a href="#">Teanna</a></div>
                <ul class="menu-list">
                    <div class="icon cancel-btn">
                        <i class="fas fa-times"></i>
                    </div>
                    <li><a href="Orders">Orders</a></li>
                    <li><a href="ItemManage">Manage</a></li>
                    <li><a href="login">login</a></li>
                    <li><a href="index.html">About</a></li>
                    <li><a href="recommend">Recommend</a></li>
                </ul>
                <div class="icon menu-btn">
                    <i class="fas fa-bars"></i>
                </div>
            </div>
        </nav>

        <div class="picker">
            <h3>Gợi ý sản phẩn theo:</h4>
            <select name="selectMode" onchange="window.location.href='recommend?page=${page}'">
                <option value="0" ${sID}>ID</option>
                <option value="1" ${sP}>Price</option>
            </select>
        </div>


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
        <div class="pageNav">
            <div class="pageNum">
                <a href="recommend?page=1"><<</a>
            </div>

            <c:set var="begin" value="${page-1}" />
            <c:set var="end" value="${page+1}" />

            <c:choose>
                <c:when test="${begin < 1}">
                    <c:set var="begin" value="1" />
                </c:when>
                <c:when test="${end > numOPage}">
                    <c:set var="end" value="${numOPage}" />
                </c:when>
            </c:choose>

            <c:forEach var="i" begin="${begin}" end="${end}">
                <div class="pageNum${i == page ? ' active' : ''}">
                    <a href="recommend?page=${i}" style="background-color: ${i == page ? 'cadetblue' : 'white'}">${i}</a>
                </div>
            </c:forEach>

            <div class="pageNum">
                <a href="recommend?page=${numOPage}">>></a>
            </div>
        </div>



    </body>
</html>
