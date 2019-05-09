
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>menu</title>
    </head>
    <body>

        <div id="leftBar">
            <ul>
                <li><a href="${pageContext.request.contextPath}/admin/index.jsp">Home</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/manager_category.jsp">Category</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/manager_product.jsp">Product</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/manager_bill.jsp">Bill</a></li>
            </ul>
        </div>

    </body>
</html>
