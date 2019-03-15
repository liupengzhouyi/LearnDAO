<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2019-03-15
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>你的订单有一些问题</title>
</head>
<body>

    <%
        HttpSession httpSession = request.getSession();

        String ErrorNumber = (String) httpSession.getAttribute("orderErrorTypeNumber");

        String ErrorInformation = "";

        if (Integer.valueOf(ErrorNumber) == 1) {
            ErrorInformation = "对不起，您的订单中：你的要求数量太大！";
        } else if (Integer.valueOf(ErrorNumber) == 2) {
            ErrorInformation = "对不起，您的订单中：你的要求数量太小！";
        } else if (Integer.valueOf(ErrorNumber) == 3) {
            ErrorInformation = "对不起，您的订单中：选择商品的库存量不足";
        }
    %>

    <h1>
        <p>
            您的订单存在问题！
        </p>
    </h1>

    <hr>

    <h2>
        <%=ErrorInformation%>
    </h2>

</body>
</html>
