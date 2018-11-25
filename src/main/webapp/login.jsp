<%--
  Created by IntelliJ IDEA.
  User: Olgierd
  Date: 2018-11-25
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form method="post">
        <input type="text" name="login"/><br/>
        <input type="password" name="password"/><br/>
        <input type="submit" value="Zaloguj sie">
    </form>
    <br/>
    <c:if test = "${error != null}">
        Podano bledne dane.
    </c:if>
</body>
</html>
