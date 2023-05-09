<%-- 
    Document   : assembleItems
    Created on : Feb 27, 2023, 1:18:40 PM
    Author     : anlal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>ASMITEM</title>
        <jsp:useBean id="cateDAO" class="DAO.CateDAO"/>
        <jsp:useBean id="itemDAO" class="DAO.ItemsDAO"/>
        <%@page import="java.util.ArrayList" %>
        <%@page import="model.Category" %>
        <%@page import="model.Item" %>
        <link href="css/items_gridView.css" rel="stylesheet" type="text/css"/>
        <!--bootstrap CSS-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    </head>
    <body>
        
        <%
            ArrayList<Category> cates = new ArrayList<Category>();
            ArrayList<Item> items = new ArrayList<Item>();
            cates= cateDAO.getAllCate();
            items= itemDAO.getAllItem();
            request.setAttribute("items", items);
            request.setAttribute("cates", cates);
        %>
        
        <div class="container-fluid">
            <% for (Category c : cates) { %>
            <div class="row">
                <div class="Category reveal" id="<%=c.getCateID()%>">
                    <div>
                        <h2><%=c.getCategory()%></h2>
                    </div>
                    <div class="items">
                        <% for (Item i : items) { 
                            if (i.getCateID().equals(c.getCateID())) {
                        %>
                        <div class="col-lg-3 col-md-4 col-sm-6 grid">
                            <div class="item" onclick="alert('Ordered <%=i.getItemName()%> successfully!!');">
                                <img src='data:image/jpeg;base64,<%=i.getImgLink()%>' alt='My Image' alt=""/>
                                <div class="itemName"><%=i.getItemName()%></div>
                                <div class="itemPrice"><%=i.getPrice()+"$"%></div>
                            </div>
                        </div>
                        <% } %>
                        <% } %>
                    </div>
                </div>
            </div>
            <% } %>
        </div>
        <!--bootstrap bundle-->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
        <!--boostrap separate-->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    </body>
</html>
