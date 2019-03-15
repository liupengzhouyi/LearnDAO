<%@ page import="ExpressionLanguage.AddGoods.Good" %><%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2019-03-15
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品详情</title>
</head>
<body>

    <%
        HttpSession httpSession = request.getSession();
        Good good = (Good)httpSession.getAttribute("good_information");
    %>

    <h1>
        商品详情
    </h1>

    <hr>

    <form action="" method="post">
        <table>
            <tr>
                <th>
                    <p>
                        商品名称
                    </p>
                </th>
                <td>
                    <p>
                        <%=good.getGood_name()%>
                    </p>
                </td>
            </tr>
            <tr>
                <th>
                    <p>
                        商品价格
                    </p>
                </th>
                <td>
                    <p>
                        <%=good.getGood_price()%>
                    </p>
                </td>
            </tr>
            <tr>
                <th>
                    <p>
                        选购数量
                    </p>
                </th>
                <td>
                    <p>
                        <input type="number" name="goods_number">
                    </p>
                </td>
            </tr>
            <tr>
                <th>
                    <p>
                        <input type="reset" value="重置">
                    </p>
                </th>
                <td>
                    <input type="submit" value="提交">
                </td>
            </tr>

        </table>
    </form>

</body>
</html>
