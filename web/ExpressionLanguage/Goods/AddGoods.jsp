<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2019-03-14
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品上传</title>
</head>
<body>
    <form action="/ExpressionLanguage/AddGoods/AddGoodServlet" method="post">
        <table border="1">
            <tr>
                <th>
                    商品名称
                </th>
                <td>
                    <input type="text" name="lp_good_name">
                </td>
            </tr>
            <tr>
                <th>
                    商品价格
                </th>
                <td>
                    <input type="number" name="lp_good_price">
                </td>
            </tr>
            <tr>
                <th>
                    商品数量
                </th>
                <td>
                    <input type="number" name="lp_good_number">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="reset" value="重置">
                </td>
                <td>
                    <input type="submit" value="提交">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
