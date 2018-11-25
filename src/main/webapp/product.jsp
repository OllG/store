<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>${product.name}</title>
</head>
<body>
${product.name}<br/>
${product.price/100}pln<br/>
<form method="post">
    <input type="hidden" name="id" value="${product.id}"/>
    <input type="number" name="amount" value="1"/>
    <input type="submit"/>
</form>
<c:if test="${added != null}">
    Dodano: ${added} sztuk, o lacznej wartosci: ${product.price*added/100} PLN
</c:if>
<br/>
<a href="cart">Koszyk</a><br/>
<a href="library">wstecz</a>
</body>
</html>
