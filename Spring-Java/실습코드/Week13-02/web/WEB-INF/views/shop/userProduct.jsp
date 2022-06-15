<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: kimyoonseo
  Date: 2022/06/13
  Time: 2:38
  To change this template use File | Settings | File Templates.
--%>
<%--구매 이력 페이지--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>주문완료</title>
</head>
<body>
<h1>주문 완료되었습니다.</h1>
<table border="1">
    <th>상품명</th>
    <th>상세보기</th>
    <th>가격</th>
    <c:forEach var="item" items="${list}">
        <tr>
            <td> ${item.name} </td>
            <td>${item.info}</td>
            <td> ${item.price} </td>
        </tr>
    </c:forEach>
</table>
<p>😊 총 가격: ${sum}</p>
<p>📦 배송비 무료 혜택, 배송비 0원 📦</p>
<p>📍 배송받을 주소를 확인해주세요!</p>
<p>${userInfo.addr}</p>
<a href="./shop"> <spring:message code="back" /> </a>
</body>
</html>
