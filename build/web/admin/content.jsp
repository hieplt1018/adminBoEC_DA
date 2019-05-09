
<%@page import="discount.DiscountUses"%>
<%@page import="discount.Discount"%>
<%@page import="discount.DiscountFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        float discount_goc = 1;
        DiscountUses discount = new DiscountUses();
        float newYear = discount.getDiscount(discount_goc,"NewYear");
        float chirstmas = discount.getDiscount(discount_goc, "Chirstmas");
        float blackFriday = discount.getDiscount(discount_goc,"BlackFriday");
        float vip = discount.getDiscount(discount_goc, "Vip");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>content</title>
    </head>
    <body>

        <div id="rightContent">
            <h3>Dashboard</h3>
            <div class="quoteOfDay">
                <b>Quote:</b><br>
                <i style="color: #5b5b5b;margin: 20%">"If you think you can, you really can"</i>
            </div>

            <div class="clear"></div>

            <div id="smallRight"><h3>Discount Now!!</h3>
                <table style="border: none;font-size: 12px;color: #5b5b5b;width: 100%;margin: 10px 0 10px 0;">
                    <tr><td style="border: none;padding: 4px;">New Year</td><td style="border: none;padding: 4px;"><b><%=newYear %> %</b></td></tr>
                    <tr><td style="border: none;padding: 4px;">Chirstmas</td><td style="border: none;padding: 4px;"><b><%=chirstmas %> %</b></td></tr>
                    <tr><td style="border: none;padding: 4px;">BlackFriday</td><td style="border: none;padding: 4px;"><b><%=blackFriday %> %</b></td></tr>
                    <tr><td style="border: none;padding: 4px;">VIP Customer</td><td style="border: none;padding: 4px;"><b><%=vip %> %</b></td></tr>
                </table>
            </div>
            <div id="smallRight"><h3>Note!</h3>

                <table style="border: none;font-size: 12px;color: #5b5b5b;width: 100%;margin: 10px 0 10px 0;">
                    <tr><td style="border: none;padding: 4px;">Pengunjung online</td><td style="border: none;padding: 4px;"><b>12</b></td></tr>
                    <tr><td style="border: none;padding: 4px;">Pengunjung hari ini</td><td style="border: none;padding: 4px;"><b>12</b></td></tr>
                    <tr><td style="border: none;padding: 4px;">Total pengunjung</td><td style="border: none;padding: 4px;"><b>12</b></td></tr>
                    <tr><td style="border: none;padding: 4px;">Hit hari ini</td><td style="border: none;padding: 4px;"><b>12</b></td></tr>
                </table>
            </div>
        </div>
        <div class="clear"></div>

    </body>
</html>
