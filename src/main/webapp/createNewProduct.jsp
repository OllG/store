<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Stworz nowy produkt</title>
</head>
<body>
    <form method="post">
        <input type="text" name="name" placeholder="Nazwa produktu">
        <input type="number" step="0.01" name="price" placeholder="Cena">
        <input type="submit">
    </form>

<c:if test="${newId != null}">
    Id nowego produktu to: ${newId}
</c:if>
<br/>
<a href="library">Wstecz</a>
</body>
</html>
