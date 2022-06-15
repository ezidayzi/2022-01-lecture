<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: kimyoonseo
  Date: 2022/05/23
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>대문페이지</title>
</head>
<body>
<P> <spring:message code="homemsg" /> </P>
<h3> <a href = "/user"><spring:message code="user" /> </h3>
<h3> <a href = "/search"><spring:message code="search" /> </h3>
</body>
</html>
