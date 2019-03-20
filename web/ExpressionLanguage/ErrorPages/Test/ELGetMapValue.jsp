<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2019-03-20
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式输出Map中的内容</title>
</head>
<body>
    <%
        Map<String,String> map2 = new HashMap();
        map2.put("a","hello world");
        map2.put("b","this is map");
        request.setAttribute("map2",map2);
    %>


    <p>
        ${map2['a']}
    </p>
    <p>
        ${map2['b']}
    </p>
    <br>
    键值对遍历
    <br>
    <c:forEach var="item" items="${map2}">
        ${item.key} -> ${item.value} <br>
    </c:forEach>
    键遍历
    <br>
    <c:forEach var="item" items="${map2}">
        ${item.key}<br>
    </c:forEach>
    值遍历
    <br>
    <c:forEach var="item" items="${map2}">
        ${item.value}<br>
    </c:forEach>
    <body>
    <br>

</body>
</html>
