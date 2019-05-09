<%@page import="model.ClothesCatergory"%>
<%@page import="dao.CategoryDaoImpl"%>
<%@page import="dao.CategoryDao"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Category</title>

        <link href="${pageContext.request.contextPath}/css/mos-style.css" rel='stylesheet' type='text/css' />

    </head>
    <body>

        <%
            CategoryDao categoryDAO = new CategoryDaoImpl();
            ArrayList<ClothesCatergory> listCategory = categoryDAO.getAllCategory();
        %>

        <jsp:include page="header.jsp"></jsp:include>

            <div id="wrapper">

            <jsp:include page="menu.jsp"></jsp:include>

                <div id="rightContent">
                    <h3>Quản lý danh mục</h3>
                    
                    <a href="${pageContext.request.contextPath}/admin/insert_category.jsp">Add Category</a>

                    <table class="data">

                        <tr class="data">
                            <th class="data">ID</th>
                            <th class="data">Name</th>
                            <th class="data" width="90px">Options</th>
                        </tr>

                        <%
                            for(ClothesCatergory category : listCategory){
                        %>
                        <tr class="data">
                            <td class="data"><%=category.getID()%></td>
                            <td class="data"><%=category.getName()%></td>
                            <td class="data" width="90px">
                            <center>
                                <a href="${pageContext.request.contextPath}/admin/update_category.jsp?command=update&category_id=<%=category.getID()%>">Edit</a>&nbsp;&nbsp; | &nbsp;&nbsp;
                                <a href="${pageContext.request.contextPath}/ManagerCategoryServlet?command=delete&category_id=<%=category.getID()%>">Delete</a>
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
