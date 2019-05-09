
<%@page import="dao.StaffDAOImpl"%>
<%@page import="dao.StaffDAO"%>
<%@page import="dao.BillDao"%>
<%@page import="dao.BillDaoImpl"%>
<%@page import="model.Staff"%>
<%@page import="model.Bill"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý hóa đơn</title>

        <link href="${pageContext.request.contextPath}/css/mos-style.css" rel='stylesheet' type='text/css' />

    </head>
    <body>
        
        <%
           BillDao billDAO = new BillDaoImpl();
           ArrayList<Bill> listBill = billDAO.getAllBill();
           StaffDAO usersDAO = new StaffDAOImpl();
        %>

        <jsp:include page="header.jsp"></jsp:include>

            <div id="wrapper">

            <jsp:include page="menu.jsp"></jsp:include>

                <div id="rightContent">
                    <h3>Bill</h3>

                    <table class="data">
                        <tr class="data">
                            <th class="data" width="30px">ID</th>
                            <th class="data">Customer</th>
                            <th class="data">Total</th>
                            <th class="data">Payment</th>
                            <th class="data">Address</th>
                            <th class="data">Date</th>
                        </tr>
                        
                        <%for(Bill bill : listBill){%>
                        <tr class="data">
                            <td class="data" width="30px"><%=bill.getID()%></td>
                            <td class="data"><%=usersDAO.getUser(bill.getCustomerID()).getUser() %></td>
                            <td class="data"><%=bill.getCost()%>$</td>
                            <td class="data"><%=bill.getPaymentMethod()%></td>
                            <td class="data"></td>
                            <td class="data"><%=bill.getCreateDate() %></td>
                        </tr>
                        <%}%>

                    </table>
                </div>
                <div class="clear"></div>

            <jsp:include page="footer.jsp"></jsp:include>

        </div>


    </body>
</html>
