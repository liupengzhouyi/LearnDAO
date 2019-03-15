<%@ page import="ExpressionLanguage.AddGoods.Good" %>
<%@ page import="java.util.List" %>
<%@ page import="ExpressionLanguage.GetGoods.GetAllGoods" %><%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2019-03-14
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有商品</title>
</head>
<body>
    <%
        List<Good> listOfGood = new GetAllGoods().getListOfGoods();
        HttpSession httpSession = request.getSession();
        System.out.println("123");
        httpSession.setAttribute("goodsNumber", listOfGood.size());
        httpSession.setAttribute("allGoods", listOfGood);
    %>

    <h1>
        <p>
            所有商品
        </p>
    </h1>

    <hr>

    <form action="" method="post">
        <table border="1">
            <tr>
                <th>
                    商品名称
                </th>
                <th>
                    商品价格
                </th>
                <th>
                    商品数量
                </th>
            </tr>

            <%
                for (Good good : (List<Good>)httpSession.getAttribute("allGoods")
                ) {
                    %>
            <tr>
                <th>
                    <a href="/ExpressionLanguage/ShowGoods/GoodInformationServlet?good_id=<%=good.getGood_id()%>">
                        <%=good.getGood_name()%>
                    </a>
                </th>
                <th>
                    <%=good.getGood_price()%>
                </th>
                <th>
                    <%=good.getGood_number()%>
                </th>
            </tr>
            <%
                }
            %>

            <c:forEach items="${sessionScope.allGoods}" var="item" begin="1" end="${sessionScope.goodsNumber}" step="1" varStatus="user">
                <h3>${user.getGood_name()}</h3>
            </c:forEach>

        </table>
    </form>

</body>
</html>
