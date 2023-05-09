<%-- 
    Document   : Home
    Created on : Feb 10, 2023, 9:19:30 PM
    Author     : anlal
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">        
        <title>TEANNA HomePage</title>
        <link href="css/index_Style.css" rel="stylesheet" type="text/css"/>
        <link href="css/Order_Style.css" rel="stylesheet" type="text/css"/>
        <link href="css/items_gridView.css" rel="stylesheet" type="text/css"/>
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.1/css/all.css" integrity="sha384-vp86vTRFVJgpjF9jiIGPEEqYqlDwgyBgEF109VFjmqGmIY/Y4HV4d3Gp2irVfcrp" crossorigin="anonymous">
        <script src="https://kit.fontawesome.ccm/a076d05399.js"></script>
        <!-- Bootstrap -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

    </head>
    <body>
        <nav class="navbar" id="navbar" style="position: fixed; right: 2.5vw; max-width: 95%;">
            <div class="content">
                <div class="logo"><a href="#">Teanna</a></div>
                <ul class="menu-list">
                    <div class="icon cancel-btn">
                        <i class="fas fa-times"></i>
                    </div>
<!--                    <li><a href="ItemsAssembly" target="_blank">Data1</a></li>
                    <li><a href="rawData_ItemManage.jsp" target="_blank">Data2</a></li>-->
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
        
        <div class="orderPrice">
            <select id="priceFilter" onchange="Filter()">
                <option value="0">select price filter</option>
                <option value="1" ${se1}>price asc</option>
                <option value="2" ${se2}>price desc</option>
            </select>
        </div>
        <div class="OuterContainer" id="OutC" style="scroll-snap-type: y mandatory;"> 

            <div class="banner" id="banner">
                <div class="bannerHeading" id="bannerHeading">
                    <h1>Teanna</h1>
                </div>
            </div>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-2 col-md-3 sideBar" id="sideBar">
                        <div class="sideBarContent" id="sideBarContent">
<!--                            <div class="itemNav" id="itemNav">
                                <ul>
                                    <li><a href="#FT">Trà hoa quả</a></li>
                                    <li><a href="#GT">Trà xanh</a></li>
                                    <li><a href="#IS">Sinh tố đá xay</a></li>
                                    <li><a href="#MT">Trà sữa</a></li>
                                    <li><a href="#SS">Sinh tố đặc biệt</a></li>
                                    <li><a href="#YS">Sinh tố sữa chua</a></li>
                                </ul>
                            </div>                   -->
                            <div class="itemNav" id="itemNav">
                                <ul>
                                    <li><a href="all?type=FT">Trà hoa quả</a></li>
                                    <li><a href="all?type=GT">Trà xanh</a></li>
                                    <li><a href="all?type=IS">Sinh tố đá xay</a></li>
                                    <li><a href="all?type=MT">Trà sữa</a></li>
                                    <li><a href="all?type=SS">Sinh tố đặc biệt</a></li>
                                    <li><a href="all?type=YS">Sinh tố sữa chua</a></li>
                                    <li><a href="all?type=ALL">ALL</a></li>
                                </ul>
                            </div>                   
                        </div>
                    </div>
                    <div class="col-lg-10 col-md-9 itemsList">
                        <div class="ItemList">
                            <%--<%@include file="ItemsAssembly.jsp" %>--%>
                            <div class="container-fluid">
                                <c:forEach items="${cates}" var="c">
                                    <div class="row">
                                        <div class="Category reveal" id="${c.getCateID()}">
                                            <div>
                                                <h2>${c.getCategory()}</h2>
                                            </div>
                                            <div class="items">

                                                <c:forEach items="${items}" var="i">

                                                    <c:if test="${i.getCateID().equals(c.getCateID())}">
                                                        <div class="col-lg-3 col-md-4 col-sm-6 grid">
                                                            <div class="item" onclick="alert('Ordered ${i.getItemName()} successfully!!');">
                                                                <img src='data:image/jpeg;base64,${i.getImgLink()}' alt='My Image' alt=""/>
                                                                <div class="itemName">${i.getItemName()}</div>
                                                                <div class="itemPrice">${i.getPrice()}$</div>
                                                            </div>
                                                        </div>
                                                    </c:if>

                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
                <div style="padding: 30px 0px 30px; text-align: center; color: #FFF;">
                    copyright © 2023 | “Teanna” are registered trademarks of TA.Trieu | all rights reserved | Accessibility Statement | Terms and Conditions | Privacy Policy
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
        <script src="script/orderScript.js" type="text/javascript"></script>

    </body>
</html>
