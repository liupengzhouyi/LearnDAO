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

<%--

* 1：用户名太长
* 2：用户密码太长
* 3：用户密码不一致
* 4：用户密码太短
* 5：未知原因，用户注册信息没有存储到数据库

--%>
    <%
        HttpSession httpSession = request.getSession();
        String ErroeNumber = httpSession.getAttribute("ErrorNumber").toString();
        System.out.println("错误信息：" + ErroeNumber);
    %>

    <%="错误信息：" + ErroeNumber%>
</body>
</html>
