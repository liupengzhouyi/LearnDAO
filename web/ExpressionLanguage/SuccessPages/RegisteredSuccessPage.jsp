<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2019-03-13
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册成功</title>
</head>
<body>
<%
    HttpSession httpSession = request.getSession();

    String user_id = httpSession.getAttribute("user_id").toString();

    String user_name = httpSession.getAttribute("user_name").toString();
%>

<h1>
    尊敬的用户，<%=user_name%>您好！我是您爸爸！
</h1>

<hr>

<h2>
    我们刚刚收到您的注册信息，现在，您已经加入我们了，您的编号是：<%=user_id%>.
</h2>
</body>
</html>
