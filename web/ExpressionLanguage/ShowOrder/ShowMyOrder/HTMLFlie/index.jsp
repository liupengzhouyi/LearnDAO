<%@ page import="ExpressionLanguage.CreateOrder.Order" %><%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2019-03-15
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的订单</title>
</head>
<body>

    <%
        HttpSession httpSession = request.getSession();
        Order order = (Order) httpSession.getAttribute("new_order");
    %>

    <h1>
        <p>
            该订单已经完成！
        </p>
    </h1>

    <hr>

    <h2>
        <p>
            订单详情
        </p>
    </h2>

    <table>
        <tr>
            <th>
                商品名称
            </th>
            <td>
                <%=order.getGood_id()%>
            </td>
        </tr>
        <tr>
            <th>
                商品名称
            </th>
            <td>
                <%=order.getUser_id()%>
            </td>
        </tr>
        <tr>
            <th>
                商品名称
            </th>
            <td>
                <%=order.getGood_number()%>
            </td>
        </tr>
    </table>
</body>
</html>
