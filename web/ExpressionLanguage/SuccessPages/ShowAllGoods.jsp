<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2019-03-14
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品展示</title>
</head>
<body>


    <h1>
        所有商品
    </h1>

    <hr>

    <h2>
        <a href="/index.jsp">
            <p>
                返回主页
            </p>
        </a>
    </h2>

    <table border="1">
        <tr>
            <th>
                <p>

                </p>
            </th>
            <th>
                <p>
                    商品编号
                </p>
            </th>
            <th>
                <p>
                    商品名称
                </p>
            </th>
            <th>
                <p>
                    商品价格
                </p>
            </th>
            <th>
                <p>
                    商品剩余量
                </p>
            </th>
        </tr>
    <%
        HttpSession httpSession = request.getSession();
        int number = Integer.valueOf(httpSession.getAttribute("goodListNumber").toString());
        for (int i=0;i<number;i++) {


    %>
        <tr>
            <th>
                <p>
                    <%=i%>
                </p>
            </th>
            <th>
                <p>
                    ${sessionScope.goodList[1].getGood_id()}
                </p>
            </th>
            <th>
                <p>
                    ${sessionScope.goodList[1].getGood_name()}
                </p>
            </th>
            <th>
                <p>
                    ${sessionScope.goodList[1].getGood_price()}
                </p>
            </th>
            <th>
                <p>
                    ${sessionScope.goodList[1].getGood_number()}
                </p>
            </th>
        </tr>
    <%
        }
    %>
    </table>
</body>
</html>
