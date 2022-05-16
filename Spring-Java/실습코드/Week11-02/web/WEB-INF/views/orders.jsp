<%@ page import="model.CustomerInfo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kimyoonseo
  Date: 2022/05/16
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>주문</title>
</head>
<body>

<form name="form1" method="POST" action="./sel">

    <select name="selectCustomer">
        <c:forEach var="item" items="${customersInfo}">
            <option value="${item.custid}">${item.name}</option>
        </c:forEach>
    </select>
    <select name="selectBook">
        <c:forEach var="item" items="${booksInfo}">
            <option value="${item.bookid},${item.price}">${item.bookname}</option>
        </c:forEach>
    </select>
    <input type="submit" value="선택" />
</form>


</body>
</html>
