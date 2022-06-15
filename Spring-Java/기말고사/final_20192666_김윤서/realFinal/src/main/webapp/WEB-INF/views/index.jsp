<%--
  Created by IntelliJ IDEA.
  User: kimyoonseo
  Date: 2022/05/30
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        .button {
            display: block;
            width: 115px;
            height: 25px;
            background: #288CFF;
            padding: 10px;
            text-align: center;
            border-radius: 5px;
            color: white;
            font-weight: bold;
            line-height: 25px;
        }
    </style>
</head>
<body>
<div>
<c:if test="${empty authInfo}">
    <a class="button" href="./shop"><spring:message code="shop"/></a><br>
    <a class="button" href="./login"><spring:message code="login"/></a><br>
    <a class="button" href="./signUp"><spring:message code="signup"/></a><br>
</c:if>

<c:if test="${! empty authInfo}">
    <a class="button" href="./shop"><spring:message code="shop"/></a><br>
    <a class="button" href="./login">마이페이지</a><br>
</c:if>
</div>
</body>
</html>