<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2019-03-20
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式输出List中的内容</title>
</head>
<body>
    <%
        List list = new ArrayList();
        list.add("abc");
        list.add("123");
        list.add("haha");
        list.add("hehe");

        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("list", list);

    %>

    <c:forEach var="MyList" items="${list}" >
        <tr>
            <td> <c:out value="${MyList[0]}" default="wang"/> </td>
        </tr>
    </c:forEach>

</body>
</html>
