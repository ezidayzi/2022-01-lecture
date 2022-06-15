<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<%--
  Created by IntelliJ IDEA.
  User: kimyoonseo
  Date: 2022/05/30
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
  <title>Home</title>
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
      text-decoration: none;
    }
  </style>
</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>
<body>
<c:if test="${empty authInfo}">
  <P> <spring:message code="loginmesg" /> </P>
  <form:form action="submit" modelAttribute="loginInfo">
  <p> <label> <spring:message code="userid" />:<br> <form:input path="userid" />
    <form:errors path="userid" /> </label>
    <br> <spring:message code="rememberid" /> <form:checkbox path="rememberId" /> </label> </p>
  <p> <label> <spring:message code="pwd" />:<br> <form:password path="pwd" />
    <form:errors path="pwd" /> </label> </p>
  <button class="btn" type="submit"> <spring:message code="submit" /> </button>
</form:form>
</c:if>
<c:if test="${! empty authInfo}">
  <P> ${authInfo.userid}님 환영합니다. </P>
  <a class = "button" href="./userInfo/${authInfo.userid}">${authInfo.userid}님 정보</a><br>
  <a class = "button" href="./delivery">${authInfo.userid}님 주문목록</a><br>
  <a class = "button"  href="./modifyUserInfo"> <spring:message code="modifyUserinfo" /> </a><br>
  <a class = "button"  href="user/logout"><spring:message code="logout" /></a><br>
  <a class = "button" href="user/withdraw"><spring:message code="withdraw" />></a><br>
</c:if>
</body>
</body>
</html>
