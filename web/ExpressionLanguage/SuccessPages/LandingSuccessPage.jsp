<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2019-03-13
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆成功</title>
</head>
<body>

<%
    HttpSession httpSession = request.getSession();

    String user_name = httpSession.getAttribute("user_name").toString();
%>


    <h1>
        尊敬的<%=user_name%>,您已经登陆成功！
    </h1>

</body>
</html>
