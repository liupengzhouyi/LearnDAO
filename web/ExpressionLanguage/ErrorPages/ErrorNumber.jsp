<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2019-03-13
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        HttpSession httpSession = request.getSession();

        String ErroeNumber = httpSession.getAttribute("ErrorNumber").toString();

        System.out.println("错误信息：" + ErroeNumber);

    %>

    <%="错误信息：" + ErroeNumber%>
</body>
</html>
