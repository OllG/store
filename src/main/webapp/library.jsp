<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Lista Prodoktow</title>
    <link rel="stylesheet" type="text/css" href="library.css">
</head>
<body>
    <table>
        <c:forEach items="${library}" var="product">
            <tr>
                <td class="name">
                    <a href="product?id=${product.id}">${product.name}</a>
                </td>
                <td class="price">
                    ${product.price/100} pln
                </td>
            </tr>
        </c:forEach>
        <a href="home">Wstecz</a>
    </table>
</body>
</html>