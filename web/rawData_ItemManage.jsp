<%-- 
    Document   : rawData_ItemManage
    Created on : Feb 27, 2023, 10:22:50 PM
    Author     : anlal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="cateDAO" class="DAO.CateDAO"/>
        <jsp:useBean id="itemDAO" class="DAO.ItemsDAO"/>
        <%@page import="java.util.ArrayList" %>
        <%@page import="model.Category" %>
        <%@page import="model.Item" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/rawDataTable.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <div style="overflow: scroll;">
            <%
                ArrayList<Category> cates = new ArrayList<Category>();
                ArrayList<Item> items = new ArrayList<Item>();
                cates= cateDAO.getAllCate();
                items= itemDAO.getAllItem();
                request.setAttribute("items", items);
                request.setAttribute("cates", cates);
            %>
            <div class="dataContainer">
                <table class="itemTable" id="itemTable">
                        <% for (Category c : cates) { %>
                        <tr>
                            <th colspan="5">
                                <%=c.getCategory()%>
                            </th>
                        </tr>
                        <% for (Item i : items) { 
                            if (i.getCateID().equals(c.getCateID())) {
                        %>
                        <tr class="table-row">
                            <td style="text-align: center;">
                                <%=i.getCateID()%>
                            </td>
                            <td style="text-align: center;">
                                <%=i.getItemID()%>
                            </td>
                            <td style="display: none;">
                                <%=i.getImgLink()%>
                            </td>
                            <td style="font-size: 20px;">
                                <%=i.getItemName()%> 
                            </td>
                            <td style="text-align: center;">
                                <%=i.getPrice()%>
                            </td>
                        </tr>
                        <% } %>
                        <% } %>
                        <% } %>
                </table>
            </div>
        </div>

    </body>
</html>
