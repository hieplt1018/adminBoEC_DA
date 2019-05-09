

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    Object error = request.getAttribute("errorMessage");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>

    <link href="${pageContext.request.contextPath}/css/mos-style.css" rel='stylesheet' type='text/css' />

</head>
<body>

    <div id="header">
        <div class="inHeaderLogin"></div>
    </div>

    <div id="loginForm">
        <div class="headLoginForm">
            Login Administrator
        </div>
        <div class="fieldLogin">
            <form method="POST" action="LoginServlet">
                <label>Username</label><br>
                <input type="text" class="login" name="username"><br>
                <label>Password</label><br>
                <input type="password" class="login" name="password"><br>
                <%if (error != null) { %>
                    <div style ="color:tomato; margin-bottom: 5px;">
                        <%=error%>
                    </div>
                <%}%>
                <input type="submit" class="button" style="color: #000">
            </form>
        </div>
    </div>

</body>
</html>
