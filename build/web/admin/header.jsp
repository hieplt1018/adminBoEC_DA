
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    String staff = String.valueOf(session.getAttribute("user"));
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>header</title>
    </head>
    <body>

        <div id="header">
            <div class="inHeader">
                <div class="mosAdmin">
                    Hello, <%=staff%><br>
                    <a href="${pageContext.request.contextPath}/ExitServlet">Logout</a> 
                </div>
                <div class="clear"></div>
            </div>
        </div> 

    </body>
</html>
