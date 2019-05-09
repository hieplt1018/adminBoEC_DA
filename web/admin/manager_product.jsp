
<%@page import="helper.categoryClothes.ClothesType"%>
<%@page import="helper.categoryClothes.CategoryClothes"%>
<%@page import="helper.categoryClothes.CategoryClothesFactory"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Clothes"%>
<%@page import="dao.ClothesDaoImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Product</title>

        <link href="${pageContext.request.contextPath}/css/mos-style.css" rel='stylesheet' type='text/css' />

    </head>
    <body>
        <%
            ClothesDaoImpl clothesDAO = new ClothesDaoImpl();
            ArrayList<Clothes> list = clothesDAO.getAllClothes();
            String clothesCategory = null;
            Object message = request.getAttribute("message");
            Object error = request.getAttribute("error");
        %>

        <jsp:include page="header.jsp"></jsp:include>

            <div id="wrapper">

            <jsp:include page="menu.jsp"></jsp:include>

                <div id="rightContent">
                    <h3>Product</h3>
                        <%if (message != null) {%>
                        <div class="sukses">
                            <%=message%>
                        </div>
                        <%} else if (error != null) {%>
                        <div class="gagal">
                            <%=error%>
                        </div>
                        <% } %>

                    <a href="${pageContext.request.contextPath}/admin/insert_product.jsp">Thêm sản phẩm</a>

                    <table class="data">

                        <tr class="data">
                            <th class="data" width="30px">STT</th>
                            <th class="data">ID</th>
                            <th class="data">Name</th>
                            <th class="data">Category</th>
                            <th class="data">Size</th>
                            <th class="data">Price</th>
                            <th class="data">Country</th>
                            <th class="data" width="90px">Options</th>
                        </tr>

                        <%
                            int count = 0;
                            for (Clothes c : list) {
                                count++;
                                 switch (c.getClothesCatergoryID()) {
                                         case 1: {
                                             CategoryClothes categoryClothes = CategoryClothesFactory.getCategory(ClothesType.SKIRT);
                                             clothesCategory = categoryClothes.getCategory();
                                             break;
                                         }
                                         case 2: {
                                             CategoryClothes categoryClothes = CategoryClothesFactory.getCategory(ClothesType.DRESS);
                                             clothesCategory = categoryClothes.getCategory();
                                             break;
                                         }
                                         case 3: {
                                             CategoryClothes categoryClothes = CategoryClothesFactory.getCategory(ClothesType.WINTERDRESS);
                                             clothesCategory = categoryClothes.getCategory();
                                             break;
                                         }
                                         case 4: {
                                             CategoryClothes categoryClothes = CategoryClothesFactory.getCategory(ClothesType.BLOUSE);
                                             clothesCategory = categoryClothes.getCategory();
                                             break;
                                         }
                                         case 5: {
                                             CategoryClothes categoryClothes = CategoryClothesFactory.getCategory(ClothesType.JACKET);
                                             clothesCategory = categoryClothes.getCategory();
                                             break;
                                         }
                                         case 6: {
                                             CategoryClothes categoryClothes = CategoryClothesFactory.getCategory(ClothesType.SWEATER);
                                             clothesCategory = categoryClothes.getCategory();
                                             break;
                                         }
                                     }
                        %>
                        <tr class="data">
                            <td class="data" width="30px"><%=count%></td>
                            <td class="data"><%=c.getID()%></td>
                            <td class="data"><%=c.getName()%></td>
                            <td class="data"><%=clothesCategory %></td>
                            <td class="data"><%=c.getSize()%></td>
                            <td class="data"><%=c.getPrice()%></td>
                            <td class="data"><%=c.getCountry()%></td>
                            <td class="data" width="90px">
                        <center>
                            <a href="${pageContext.request.contextPath}/ManagerProductServlet?command=sendUpdate&id=<%=c.getID()%>">Edit</a>&nbsp;&nbsp; | &nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath}/ManagerProductServlet?command=delete&id=<%=c.getID()%>">Delete</a>
                        </center>
                        </td>
                        </tr>
                        <%}%>

                    </table>
            </div>
            <div class="clear"></div>

            <jsp:include page="footer.jsp"></jsp:include>

        </div>


    </body>
</html>
