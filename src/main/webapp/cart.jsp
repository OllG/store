<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Koszyk</title>
</head>
<body>
<table>
    <c:forEach items="${cartItems}" var="item">
        <tr>
            <td>
                    ${item.product.name}
            </td>
            <td>
                <form method="post">
                    <input type="hidden" name="id" value="${item.product.id}">
                    <input type="number" name="amount" value="${item.amount}">
                    <input type="submit" name="change" value="zmien"/>
                    <input type="submit" name="delete" value="usun">
                </form>
            </td>
            <td>
                    ${item.product.price/100 * item.amount} pln
            </td>
        </tr>
    </c:forEach>
</table>
    <a href="library">wstecz</a>
</body>
</html>
