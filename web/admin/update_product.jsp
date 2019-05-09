

<%@page import="dao.ClothesDAO"%>
<%@page import="dao.ClothesDaoImpl"%>
<%@page import="model.Clothes"%>
<%@page import="model.ClothesCatergory"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.CategoryDaoImpl"%>
<%@page import="dao.CategoryDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    Object message = request.getAttribute("message");
    Object error = request.getAttribute("error");
    ClothesDAO clothesDAO = new ClothesDaoImpl();
    String id = String.valueOf(request.getAttribute("idUpdate"));
    Clothes clothes = clothesDAO.getClothes(id);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Product</title>

        <link href="${pageContext.request.contextPath}/css/mos-style.css" rel='stylesheet' type='text/css' />

    </head>
    <body>

        <jsp:include page="header.jsp"></jsp:include>

            <div id="wrapper">

            <jsp:include page="menu.jsp"></jsp:include>

                <div id="rightContent">
                    <h3>Update Product</h3>
                    <%if (message != null) {%>
                        <div class="sukses">
                        <%=message%>
                        </div>
                    <%} else if (error != null) {%>
                        <div class="gagal">
                        <%=error%>
                        </div>
                    <% } %>
                    <form method="POST" action="${pageContext.request.contextPath}/ManagerProductServlet?command=update&id=<%=clothes.getID()%>">
                        <label>Name</label><br>
                        <input type="text" class="login" name="name" value="<%= clothes.getName() %>"><br>
                        <label>Price</label><br>
                        <input type="text" class="login" name="price" value="<%= clothes.getPrice()%>"><br>
                        <label>Image</label><br>
                        <input type="text" class="login" name="image" value="<%= clothes.getImage()%>"><br>
                        <label>Size</label><br>
                        <input type="text" class="login" name="size" value="<%= clothes.getSize()%>"><br>
                        <label>Category</label><br>
                        <select name="category">
                            <%
                                CategoryDao categoryDAO = new CategoryDaoImpl();
                                ArrayList<ClothesCatergory> listCategory = categoryDAO.getAllCategory();
                                for (ClothesCatergory c : listCategory) {
                                    if(c.getID()==clothes.getClothesCatergoryID()){
                            %>
                                <option value="<%=c.getID()%>" selected><%=c.getName()%></option>
                            <% } else%>
                                <option value="<%=c.getID()%>"><%=c.getName()%></option>
                            <% }; %>
                        </select><br>
                        <label>Country</label><br>
                        <input type="text" class="login" name="country" value="<%= clothes.getCountry()%>"><br>
                        
                        <input type="submit" class="button" style="color: #000" >
                    </form>
                </div>
                <div class="clear"></div>

            <jsp:include page="footer.jsp"></jsp:include>

        </div>


    </body>
</html>
