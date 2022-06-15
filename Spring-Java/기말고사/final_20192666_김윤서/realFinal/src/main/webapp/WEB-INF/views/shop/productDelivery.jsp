<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kimyoonseo
  Date: 2022/06/13
  Time: 2:37
  To change this template use File | Settings | File Templates.
--%>
<%--상품검색 페이지--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>📦${authInfo.userid}님의 주문목록입니다.📦</h1>
<c:if test="${list != null}">
    <table border="1">
        <th>상품명</th>
        <th>상세정보</th>
        <th>가격</th>
        <c:forEach var="item" items="${list}">
            <tr>
                <td> ${item.name} </td>
                <td> ${item.info} </td>
                <td> ${item.price} </td>
                <td> 배달중</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<br>
<a href="./"> <spring:message code="back" /> </a>
</body>
</html>
