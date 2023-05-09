<%-- 
    Document   : ItemManage
    Created on : Feb 10, 2023, 9:19:41 PM
    Author     : anlal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Item Manager</title>
        <link href="css/index_Style.css" rel="stylesheet" type="text/css"/>
        <link href="css/ItemManage_Style.css" rel="stylesheet" type="text/css"/>
        <link href="css/rawDataTable.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
        <div class="tool-list">
            <div class="t-bttn">
                <button type="button" onclick="addItem();"> 
                    <ion-icon name="add-circle-outline"></ion-icon>
                    <label>new Drink</label>
                </button>
            </div>
            <div class="t-bttn">
                <div class="searchInput">
                    <input type="text" name="search" id="search" placeholder="Search item...">
                    <button>
                        <ion-icon name="search-outline"></ion-icon>
                    </button>
                </div>
            </div>
            <div class="t-bttn">
                <button type="button" onclick="location.href = 'Orders'">
                    <label>To home page</label>
                    <ion-icon name="chevron-forward-outline"></ion-icon></ion-icon>
                </button>
            </div>

        </div>

        <div class="filterContainer">
            <label class="switch">
                <h4 style="color: #FFF; transform: translateX(-7rem);">
                    Category
                </h4>
                <input type="checkbox" checked id="showCate">
                <span class="slider round"></span>
            </label>

            <select name="cateFilter" class="cateFilter" id="cateFilter" >
                <option value="0">cateFilter</option>
                <option value="FT" ${selected}>Trà hoa quả</option>
                <option value="GT">Trà xanh</option>
                <option value="IS">Sinh tố đá xay</option>
                <option value="MT">Trà Sữa</option>
                <option value="SS">Sinh tố đặc biệt</option>
                <option value="YS">Sinh tố sữa chua</option>
            </select>

        </div>

    </div>

    <div class="editView" id="editView">
        <div class="editView-desc" id="editView-desc">
            <h1>Choose Item to EDIT</h1>
        </div>
        <form class="editForm" id="edForm" method="post" action="ItemManage" enctype="multipart/form-data">
            <div class="hiddem-para">
                <input readonly type="text" name="iId" class="iId" id="iId" value="">
                <input readonly type="text" name="mode" class="mode" id="mode" value="0">
                <input readonly type="text" name="user" class="mode" id="mode" value="name">
                <input readonly type="text" name="level" class="mode" id="mode" value="0">
            </div>
            <div class="editItemImg" id="editItemImg">
                <!--<img src="css/newDrink.jpg" alt="IMG"/>-->
            </div>

            <div class="editItemCate" id="editItemCate">
                <div class="cateSelectLabel">
                    Category: 
                </div>
                <select name="cates" class="cateSelect" id="cateSelect" required>
                    <option value="FT">Trà hoa quả</option>
                    <option value="GT">Trà xanh</option>
                    <option value="IS">Sinh tố đá xay</option>
                    <option value="MT">Trà Sữa</option>
                    <option value="SS">Sinh tố đặc biệt</option>
                    <option value="YS">Sinh tố sữa chua</option>
                </select>
            </div>
            <!--                <div class="file-Picker" id="file-Picker">
                                <input type="file" id="filePick" name="filePick" accept="image/png, image/jpeg">
                            </div>-->
            <div class="editItemImgUrl" id="editItemImgUrl">
                <label for="iURL">imgURL:</label>
                <input required type="text" name="iURL" class="iURL" id="iURL" value="">
                <button type="button" onclick="browseFile();">browse</button>
            </div>
            <div class="editItemName" id="editItemName">
                <label for="iName">Name:</label>
                <input required type="text" name="iName" class="iName" id="iName" value="">
            </div>
            <div class="editItemPrice" id="editItemPrice">
                <label for="iPrice">price:</label>
                <input required type="number" name="iPrice" class="iPrice" id="iPrice" value="">
            </div>
            <div class="editButton">
                <button type="button" name="cfBttn" onclick="confirm();">COMFIRM</button>
                <button type="button" onclick="cancelEdit();">CANCEL</button>
            </div>
            <div class="editButton-delete">
                <button type="button" onclick="del();"><ion-icon name="trash-outline"></ion-icon></button>
            </div>
        </form>
    </div>

    <div class="dataList">
        <%@include file="rawData_ItemManage.jsp" %>
        <!--            <div class="dataContainer">
                        <table class="itemTable" id="itemTable">
                            <c:forEach items="${cates}" var="c">
                                <tr>
                                    <th colspan="5">
        ${c.getCategory()}
    </th>
</tr>
<c:forEach items="${items}" var="i">
    <c:if test="${i.getCateID().equals(c.getCateID())}">
        <tr class="table-row">
            <td>
        ${i.getCateID()}
    </td>
    <td>
        ${i.getItemID()}
    </td>
    <td>
        ${i.getImgLink()}
    </td>
    <td>
        ${i.getItemName()}
    </td>
    <td>
        ${i.getPrice()}
    </td>
</tr>
</c:if>
</c:forEach>
</c:forEach>
</table>
</div>-->
    </div>
    <script src="script/itemManageBehaviour.js" type="text/javascript"></script>
    <!--icon-->
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    <!--bootstrap-->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
