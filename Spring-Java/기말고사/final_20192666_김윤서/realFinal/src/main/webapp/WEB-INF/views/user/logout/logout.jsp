<%--
  Created by IntelliJ IDEA.
  User: kimyoonseo
  Date: 2022/05/30
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta charset="UTF-8"> <html>
<head> <title>Logout</title> </head>
<% request.setCharacterEncoding("UTF-8"); %> <body>
<P> 로그아웃되었습니다. </P>
<a href="../../.."> <spring:message code="back" /> </a> </body>
</html>