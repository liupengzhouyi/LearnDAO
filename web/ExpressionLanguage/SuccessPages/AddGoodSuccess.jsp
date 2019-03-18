<%@ page import="ExpressionLanguage.AddGoods.Good" %><%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2019-03-14
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品成功</title>
</head>
<body>
    <%
        HttpSession httpSession = request.getSession();
        //Good good = (Good)httpSession.getAttribute("newGood");
    %>

    <h1>
        恭喜您，添加商品成功！
    </h1>

    <hr>

    <table border="1">
        <tr>
            <th>
            商品名称
            </th>
            <td>
                <p>
                    ${sessionScope.newGood.getGood_name()}
                </p>
            </td>
        </tr>
        <tr>
            <th>
                商品价格
            </th>
            <td>
                <p>
                    ${sessionScope.newGood.getGood_price()}
                </p>
            </td>
        </tr>
        <tr>
            <th>
                商品数量
            </th>
            <td>
                <p>
                    ${sessionScope.newGood.getGood_number()}
                </p>
            </td>
        </tr>
    </table>

    <h3>
        <a href="/index.jsp">
            返回主页
        </a>
    </h3>

</body>
</html>
