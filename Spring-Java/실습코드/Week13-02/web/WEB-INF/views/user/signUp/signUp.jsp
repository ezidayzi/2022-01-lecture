<%--
  Created by IntelliJ IDEA.
  User: kimyoonseo
  Date: 2022/05/31
  Time: 2:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<meta charset="UTF-8"> <html>
<head> <title>회원가입</title> </head>
<% request.setCharacterEncoding("UTF-8"); %>
<body>
    <form:form action="submitsignup" modelAttribute="userInfo">
        <p> <label> <spring:message code="userid" />:<br>
            <form:input path="userid" />
            <form:errors path="userid" /> </label>
        <p> <label> <spring:message code="pwd" />:<br>
            <form:password path="pwd" />
            <form:errors path="pwd" /> </label> </p>
        <p> <label> <spring:message code="email" />:<br>
            <form:input path="email" />
            <form:errors path="email" /> </label> </p>
        <p> <label> <spring:message code="addr" />:<br>
            <form:input path="addr" />
            <form:errors path="addr" /> </label> </p>
        <p> <label> <spring:message code="tel" />:<br>
            <form:input path="tel" />
            <form:errors path="tel" /> </label> </p>
        <p> <label> <spring:message code="birthday" />:<br>
            <form:input path="birthday" />
            <form:errors path="birthday" /> </label> </p>
        <button class="btn" type="submit"> <spring:message code="submit" /> </button>
    </form:form>
</body>
</html>