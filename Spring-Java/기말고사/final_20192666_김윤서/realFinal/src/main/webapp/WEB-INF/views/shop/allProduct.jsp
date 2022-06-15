<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kimyoonseo
  Date: 2022/06/13
  Time: 2:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--전체 상품 조회 페이지--%>
<html>
<head>
    <style>

    </style>
    <title>주문</title>
    <h1>전체 상품 조회</h1>
</head>
<body>
<c:if test="${! empty authInfo}">
    <P> ${authInfo.userid}님 환영합니다. </P>
</c:if>

<header>
    <form action= "search" method="get">
    <div class="search_box">
        <input type="text" name="keyword" maxlength="225"> <i id="keyboard"
                                               class="fa fa-keyboard-o"></i>
        <input type="submit" class="fa fa-search" value="검색">
    </div>
    </form>
</header>

<form:form action="basket">
    <table border="1">
        <th>상품명</th>
        <th>가격</th>
        <th>장바구니</th>
        <c:forEach var="item" items="${list}">
            <tr>
                <td> ${item.name} </td>
                <td> ${item.price} </td>
                <c:if test="${! empty authInfo}">
                    <td><input type="checkbox" name="item" value="${item.id}"></td>
                </c:if>
                <td><a href="./detail?id=${item.id}"/>상세보기</td>
            </tr>
        </c:forEach>
    </table>
    <c:if test="${! empty authInfo}">
        <button class="btn" type="submit">장바구니에 추가</button>
    </c:if>
</form:form>

<c:if test="${ empty authInfo}">
    <p>상품 구매를  로그인이 된 사용자만 가능합니다.</p>
    <p>구매를 원하신다면 로그인을 먼저해주세요.</p>
</c:if>
    <a href="./"> <spring:message code="back" /> </a>

</body>
</html>
