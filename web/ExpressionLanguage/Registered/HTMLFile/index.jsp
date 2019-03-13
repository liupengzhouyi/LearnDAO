<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2019-03-13
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>

<form action="/ExpressionLanguage/Registered/RegisteredUserInfoemationServlet" method="post">
    <table border="1">
        <tr>
            <td>
                请输入用户名
            </td>
            <td>
                <input type="text" name="lp_name">
            </td>
        </tr>
        <tr>
            <td>
                请输入密码
            </td>
            <td>
                <input type="password" name="lp_password01">
            </td>
        </tr>
        <tr>
            <td>
                请再一次输入密码
            </td>
            <td>
                <input type="password" name="lp_password02">
            </td>
        </tr>

        <tr>
            <td>
                <input type="submit" title="提交">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
