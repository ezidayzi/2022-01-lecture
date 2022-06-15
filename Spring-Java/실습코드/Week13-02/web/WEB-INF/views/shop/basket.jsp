<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kimyoonseo
  Date: 2022/06/13
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            width: 100%;
        }
        td {
            padding: 20px;
            border: 1px solid #444444;
        }
    </style>
</head>
<body>
<h1> ${authInfo.userid}님의 장바구니😆</h1>
<form:form action="userProduct">
<table border="1">
    <th>상품명</th>
    <th>상세정보</th>
    <th>가격</th>
    <c:forEach var="item" items="${list}">
        <tr>
            <td> ${item.name} </td>
            <td> ${item.info} </td>
            <td> ${item.price} </td>
            <td><input type="checkbox" name="item" value="${item.id}"></td>
        </tr>
    </c:forEach>
</table>
<br>
선택 상품을 구매하시겠습니까? <button class="btn" type="submit">구매하기</button>
</form:form>
<a href="./shop"> <spring:message code="back" /> </a>

</body>
</html>
