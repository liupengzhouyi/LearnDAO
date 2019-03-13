<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2019-03-13
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
    <form action="" method="post">
        <table>
            <tr>
                <th>
                    请输入您的用户编号：
                </th>
                <td>
                    <input type="text" name="user_id">
                </td>
            </tr>
            <tr>
                <th>
                    请输入您的密码
                </th>
                <td>
                    <input type="password" name="user_password">
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
